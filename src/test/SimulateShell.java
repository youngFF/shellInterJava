package test;

import command.util.ShellCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 当前版本存在的问题： 1）输入一些简单的命令可以，如ps ，ls
 *                  2）复杂命令还不知道怎么处理 ，如cd----无法进行切换目录
 *                     比如：输入pwd -> cd -> pwd ，前后pwd的结果一样
 *                  3) 无法与命令进行交互，比如当命令有输入的情况，如sudo su
 *
 */
public class SimulateShell {

    private static String line = null ;
    public static void main(String[] args)  {
        System.out.println("下面进行bash模拟，请输入命令：");

        String promptor = System.getProperty("user.name") + ">>";

        Scanner scanner = new Scanner(System.in);

        while (true) {

//            Scanner scanner = new Scanner(System.in);

            System.out.print(promptor);
            try {
                Process process = ShellCommand.executeShellCommand(scanner.nextLine());
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                printShellResult(reader);
            } catch (IOException e) {
                System.out.println("命令不存在，或者shell语法错误");

            }

            // reset scanner
            scanner.reset() ;

        }

    }


    public static void printShellResult(BufferedReader reader) throws IOException {
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        line = null ;
    }
}
