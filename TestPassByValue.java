import java.util.regex.Pattern;

public class TestPassByValue {
    public static void main(String[] args) {
        Test t = new Test(5);
        System.out.println(t.getValue());
        a(t);

        String S = "5";
        System.out.println(Pattern.matches("/d*",S));
        System.out.println(t.getValue());
    }

    public static void a(Test test){
        System.out.println(test.getValue());
        test.setValue(10);
    }
}

class Test {
    int value;
    Test(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
