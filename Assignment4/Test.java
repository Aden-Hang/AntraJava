package Assignment4;

import java.io.*;

public class Test {

    static String output = "";

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new FileReader("./Assignment4/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("./Assignment4/output.txt"));

        String input = br.readLine();
        int result = 0;
        boolean isAdd = true;
        String output = "";

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
                output = input + " = " + result + "\n";
                bw.write(output);
                System.out.println("finish reading... Go to sleep...");
            }else{
                bw.write("\n");
            }
            result = 0;
            isAdd = true;


            input = br.readLine();


        }


        bw.close();
    }

    public static synchronized String ModifyInfo(String output, int i){
        if(i == 0){
            Assignment4_1.output = output;
            System.out.println("Input: " + Assignment4_1.output);
            return null;
        }else{
            System.out.println("Output: " + Assignment4_1.output);
            return  Assignment4_1.output;
        }
    }
}