package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellWIthJava {

    public static void main(String[] args) throws IOException {
        System.out.println("下面进行bash脚本模拟");
        Process process = Runtime.getRuntime().exec("ps  --help");

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));


        String line = null ;


        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
