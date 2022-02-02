package Assignment6;

import java.util.ArrayList;
import java.util.List;

public class Assignment6_3 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(80);
        l1.add(33);
        l1.add(52);

        System.out.println(average(l1));
    }

    public static Double average(List<Integer> list){
        return list.stream()
                        .mapToDouble(x -> x)
                        .average()
                        .getAsDouble();
    }
}
