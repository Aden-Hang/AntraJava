package Assignment4;

import java.io.*;
import java.util.Optional;

public class Assignment4_1 {

    static String output = "";
    static boolean isChange = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        Input i = new Input();
        Output o = new Output();
        new Thread(){
            public void run(){
                try {
                    i.inputThread();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

        new Thread(){
            public void run(){
                try {
                    o.outputThread();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }

    public static synchronized String ModifyInfo(String output, int i){
        if(i == 0){
            Assignment4_1.output = output;
            isChange = true;
            return "-1";
        }else{
            return  Assignment4_1.output;
        }
    }
}

class Input {

    public void inputThread() throws IOException, InterruptedException {

        System.out.println("This is input thread");

        BufferedReader br = new BufferedReader(new FileReader("./Assignment4/input.txt"));

        String input = br.readLine();
        int result = 0;
        boolean isAdd = true;

        while(input != null){
            String clean[] = input.split(" ");
            if(clean.length > 1){
                for(String str : clean){
                    if(str.equals("+")){
                        isAdd = true;
                    }else if(str.equals("-")){
                        isAdd = false;
                    }else {
                        if(isAdd){
                            result += Integer.parseInt(str);
                        }else{
                            result -= Integer.parseInt(str);
                        }
                    }
                }
                while(Assignment4_1.isChange){

                }
                Assignment4_1.ModifyInfo(input + " = " + result, 0);
                System.out.println("finish reading... Go to sleep...");
                Thread.sleep(1000);
            }else{
                while(Assignment4_1.isChange){

                }
                Assignment4_1.ModifyInfo(input,0);
                System.out.println("finish reading... Go to sleep...");
                Thread.sleep(1000);
            }
            result = 0;
            isAdd = true;
            input = br.readLine();
        }

        Assignment4_1.ModifyInfo(null, 0);
    }
}

class Output {

    public void outputThread() throws IOException, InterruptedException {

        System.out.println("This is output thread");

        BufferedWriter br = new BufferedWriter(new FileWriter("./Assignment4/output.txt"));

        while(Assignment4_1.ModifyInfo("",1) != null){

            if(Assignment4_1.isChange){
                br.write(Assignment4_1.ModifyInfo("",1) + "\n");
                Assignment4_1.isChange = false;

                System.out.println("finish writing... Go to sleep...");
                Thread.sleep(1000);
            }
        }
        br.close();
    }
}