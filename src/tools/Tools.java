package tools;

import java.util.Scanner;

public class Tools {
    
    public static void print(String str) {
        System.out.println(str);
    }

    public static String input (String msg) {

        Scanner scan = new Scanner(System.in);
        System.out.print(msg);
        String userInput = scan.nextLine();
        System.out.print("\n");
        
        return userInput;
    }

    public static String encrypt (String str) {
        return str;
    }
}
