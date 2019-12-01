import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable{
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch startLatch;
    private CountDownLatch finishLatch;
    private Semaphore smpTunnel;
    private Lock lock;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch startLatch, CountDownLatch finishLatch, Semaphore smpTunnel, Lock lock) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.startLatch = startLatch;
        this.finishLatch = finishLatch;
        this.smpTunnel = smpTunnel;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            startLatch.countDown();
        }

        try {
            startLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Прохождение трассы
        for (int i = 0; i < race.getStages().size(); i++) {
            //Если Туннель, то пускаем по семафору
            if (race.getStages().get(i).stageType.equals("tunnel")){
                try {
                    smpTunnel.acquire();
                    race.getStages().get(i).go(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    smpTunnel.release();
                }
            } else //Иначе, нет ограничений
                race.getStages().get(i).go(this);
        }

        //Записываем и объявляем победителя гонки
        try {
            if (lock.tryLock(5L, TimeUnit.SECONDS)){
                if (race.getWinner().isEmpty()) {
                    race.setWinner(name);
                    System.out.println(name + " - WIN");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        //Защелка финица всех участников
        finishLatch.countDown();

    }

}
