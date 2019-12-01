import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        String[] strArr = {"Январь", "Февраль", "Февраль", "Март", "Март", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

        //Ключем будет слово, а значением - сколько раз оно встречается
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            if (map.containsKey(strArr[i])){
                map.put(strArr[i], map.get(strArr[i]).intValue() + 1);
            }
            else
            {
                map.put(strArr[i], 1);
            }

        }
        System.out.println("Список уникальных слов:");
        System.out.println(map.keySet());
        System.out.println("Сколько каждое слово встречается раз:");
        System.out.println(map);

        System.out.println("Телефонный справочник:");
        PhoneDictionary dict = new PhoneDictionary();
        dict.add(11111, "Иванов");
        dict.add(22222, "Петров");
        dict.add(33333, "Сидоров");
        dict.add(44444, "Сидоров");
        dict.add(55555, "Сидоров");

        dict.print();

        dict.get("Иванов");
        dict.get("Сидоров");
        dict.get("Пупкин");
    }
}
