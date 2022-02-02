package Assignment5;

public class Assignment5_1 {
    static int turn = 0;

    public static void main(String[] args) {
        WestVehicle v1 = new WestVehicle();
        EastVehicle v2 = new EastVehicle();



        for(int i=0;i<5;i++){
            new Thread(){
                public void run(){ v1.getStart();}

            }.start();

            new Thread(){
                public void run(){ v2.getStart();}

            }.start();
        }
    }

    public static synchronized void StartAcross(int i){
        System.out.println(Thread.currentThread().getName() + " Start to across the bridge");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Finish across the bridge");

        turn++;
    }
}
class Vehicle {

}

class WestVehicle {


    public void getStart(){
        System.out.println("A west bound vehicle " + Thread.currentThread().getName() + " Created");
        WaitToAcross();
    }

    public void WaitToAcross() {
        System.out.println(Thread.currentThread().getName() + " Wait to across the bridge");
        Assignment5_1.StartAcross(1);
    }

}

class EastVehicle {

    public void getStart(){
        System.out.println("A east bound vehicle " + Thread.currentThread().getName() + " Created");
        WaitToAcross();
    }

    public void WaitToAcross() {
        System.out.println(Thread.currentThread().getName() + " Wait to across the bridge");
        Assignment5_1.StartAcross(2);
    }

}