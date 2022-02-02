package Assignment1;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment1_3 {

    public static void main(String[] args) {
        int a[] = {1,2,5,3,4,8,6,2,10};
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-2));
    }
}
