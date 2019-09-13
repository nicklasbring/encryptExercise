import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //System.out.print("[+] Indtast adgangskode: ");
        //String password = input.nextLine();

        Cipher cipher = new Cipher("1234");
        System.out.println(cipher.decrypt("TGluJFJtZ29wZXcwJHJ5JHh2c3YkbmlrJGV4JGhpeCR6bXZvaXY="));
        //System.out.println("[+] Indtast besked til at kryptere: ");
        //String inputMsg = input.nextLine();
        //System.out.println(cipher.encrypt(inputMsg));
    }
}
