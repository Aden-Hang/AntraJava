package Assignment6;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment6_2 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(5);
        l1.add(14);
        l1.add(88);
        l1.add(53);

        System.out.println(getString(l1));
    }

    public static String getString(List<Integer> list){
        String str = list.stream()
                        .map(x -> {
                            if(x % 2 == 0){
                                return "e" + x + " ";
                            }else{
                                return "o" + x + " ";
                            }
                        })
                        .collect(Collectors.joining());
        str = str.trim().replace(" ", ",");
        return str;
    }
}
