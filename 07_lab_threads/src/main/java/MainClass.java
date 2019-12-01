import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        final CountDownLatch startLatch = new CountDownLatch(CARS_COUNT);
        final CountDownLatch finishLatch = new CountDownLatch(CARS_COUNT);
        final Semaphore smpTunnel = new Semaphore(CARS_COUNT / 2);
        final Lock lock = new ReentrantLock();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), startLatch, finishLatch, smpTunnel, lock);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        //Ждем когда все будут готовы к старту
        try {
            startLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        //Ждем финиша всех участников
        try {
            finishLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }

}
