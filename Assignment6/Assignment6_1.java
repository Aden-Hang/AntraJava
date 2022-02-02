package Assignment6;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment6_1 {
    public static void main(String[] args) {
        List<Person> l1 = new ArrayList<>();
        l1.add(new Person("alex", 20, "male"));
        l1.add(new Person("bob", 15, "male"));
        l1.add(new Person("susan", 23, "female"));
        l1.add(new Person("add", 10, "male"));
        l1.add(new Person("anderson", 18, "male"));
        l1.add(new Person("ana", 10, "female"));

        System.out.println(search(l1));
    }
    public static List<String> search(List<Person> list){
        return list.stream()
                .map(Person::getName)
                .filter(x -> x.length() == 3)
                .filter(x -> x.startsWith("a"))
                .collect(Collectors.toList());
    }
}

class Person{
    String name;
    int age;
    String sex;

    Person(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName(){
        return name;
    }
}
