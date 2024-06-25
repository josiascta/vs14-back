package tasks;

import java.util.Scanner;

public class TaskNove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();

        if (palavra.equals("dog")) {
            System.out.println("cachorro");
        } else if (palavra.equals("city")) {
            System.out.println("cidade");
        } else if (palavra.equals("happy")) {
            System.out.println("feliz");
        } else if (palavra.equals("sad")) {
            System.out.println("triste");
        }if (palavra.equals("cachorro")) {
            System.out.println("dog");
        } else if (palavra.equals("cidade")) {
            System.out.println("city");
        } else if (palavra.equals("feliz")) {
            System.out.println("happy");
        } else if (palavra.equals("triste")) {
            System.out.println("sad");
        }else {
            System.out.println("Esse idioma não é válido.");
        }


    }
}
