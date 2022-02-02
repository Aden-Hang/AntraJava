package Assignment3;

import java.util.*;

public class Assignment3_1 {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(10);

        Map<String, String> B = new HashMap<>();
        B.put("a", "1");
        B.put("b", "2");
        B.put("c", "3");

        Iterator iter = A.iterator();
        while(iter.hasNext()){
            if(B.containsValue(String.valueOf(iter.next()))){
                iter.remove();
            }
        }

        System.out.println(A);
    }
}
