package Assignment6;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment6_4 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("after");
        l1.add("noon");
        l1.add("cool");
        l1.add("submit");

        System.out.println(upperCase(l1));
    }

    public static List<String> upperCase(List<String> list) {
        return list.stream()
                        .map(x -> x.toUpperCase())
                        .collect(Collectors.toList());
    }
}
