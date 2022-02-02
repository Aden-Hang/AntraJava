package Assignment1;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment1_2 {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        int b[] = {21,22,23,24,25,26,27};

        int c[] = new int[a.length + b.length];

        for(int i=0;i<a.length;i++){
            c[i] = a[i];
        }

        for(int i=0;i<b.length;i++){
            c[a.length+i] = b[i];
        }

        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}
