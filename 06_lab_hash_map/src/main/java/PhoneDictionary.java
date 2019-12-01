import java.util.*;

public class PhoneDictionary {
    private Map<String, List<Integer>> dictionary = new LinkedHashMap<>();

    //Добавить адресата
    public void add(Integer num, String fio){
        if (dictionary.containsKey(fio)) {
            dictionary.get(fio).add(num);
        }
        else
        {
            dictionary.put(fio, new ArrayList<>(Arrays.asList(num)));
        }
    }

    //Найти номер по фамилии
    public void get(String fio){
        if (dictionary.containsKey(fio)){
            System.out.println("Номер адресата " + fio + " : " + dictionary.get(fio));
        }
        else {
            System.out.println("Адресат с фамилией '" + fio + "' отсутствует!");
        }
    }

    //Печать телефонного справочника
    public void print(){
        for (Map.Entry<String, List<Integer>> o: dictionary.entrySet()) {
            System.out.println(o.getKey());
            Iterator<Integer> iter = o.getValue().iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
    }
}
