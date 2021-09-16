package HashMap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class hashMap {
    public static void main(String[] args){
        Map<String,Employee> staff = new HashMap<>();
        Employee harry = new Employee("Harry Hacker",190,20);
        Employee brown = new Employee("Dan Brown",237,19);
        staff.put("987-82-9997",harry);
        staff.put("986-45-9878",brown);
        Map<String,Integer> scores = new HashMap<>();
        scores.put(harry.getName(),100);
        staff.remove("986-45-9878");//删除其中一个键值对//
        String telephone =  "987-82-9997";
        Employee jackson = staff.get(telephone);
        System.out.println(jackson.getAge());
        System.out.println(staff.size());//返回staff中的元素数//

        Map<String,Employee> staff2 = new LinkedHashMap<>();
        staff2.put("144-21-4553",new Employee("Amy Lee",975,32));
        staff2.put("567-32-4627",new Employee("Gary Joe",85,27));
        staff2.put("102-33-6784",new Employee("Andrew Martin",572,54));
        staff2.put("902-21-9483",new Employee("Emma Namphy",21,22));
        staff2.keySet().iterator();
        staff2.values().iterator();


    }
    public static class Employee{
        private String name;
        private Integer ID;
        private Integer age;
        public Employee(String aname,Integer aID,Integer aage){
            name = aname;
            ID = aID;
            age = aage;
        }

        public Integer getAge() {
            return age;
        }
        public String getName(){
            return name;
        }
        public Integer getID(){
            return ID;
        }

    }
}
