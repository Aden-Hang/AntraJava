package Assignment3;

import java.util.*;

public class Assignment3_2 {
    public static void main(String[] args) {
        Circle c1 = new Circle(15);
        Circle c2 = new Circle(8);
        Rectangle r = new Rectangle(5,10);
        Square s = new Square(12);

        List<Circle> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        System.out.println(c1.area());
        System.out.println(c2.area());
        System.out.println(r.area());
        System.out.println(s.area());

        System.out.println(list.get(0).area());

    }
}

interface Shape {
    public float area();
}

class Circle implements Shape, Comparable<Circle>{
    float radius;
    Circle(float radius){
        this.radius = radius;
    }

    @Override
    public float area() {
        return radius * radius * (float)Math.PI;
    }

    @Override
    public int compareTo(Circle c) {
        if(this.area() == c.area()){
            return 0;
        }
        if(this.area() < c.area()){
            return -1;
        }else{
            return 1;
        }
    }
}

class Rectangle implements Shape, Comparable<Rectangle>{
    float height;
    float width;

    Rectangle(float height, float width){
        this.height = height;
        this.width = width;
    }

    @Override
    public float area() {
        return height * width;
    }

    @Override
    public int compareTo(Rectangle r) {
        if(this.area() == r.area()){
            return 0;
        }
        if(this.area() < r.area()){
            return -1;
        }else{
            return 1;
        }
    }
}

class Square implements Shape, Comparable<Square>{
    float length;

    Square(float length){
        this.length = length;
    }

    @Override
    public float area() {
        return length * length;
    }

    @Override
    public int compareTo(Square s) {
        if(this.area() == s.area()){
            return 0;
        }
        if(this.area() < s.area()){
            return -1;
        }else{
            return 1;
        }
    }
}
