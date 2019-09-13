import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("[+] Indtast adgangskode: ");
        String password = input.nextLine();

        Cipher cipher = new Cipher(password);
        System.out.println("[+] Indtast besked til at kryptere: ");
        String inputMsg = input.nextLine();
        try {
            PrintWriter printWriter = new PrintWriter("textFile.txt");
            printWriter.println(cipher.encrypt(inputMsg));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
