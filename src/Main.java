import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("[+] Indtast adgangskode: ");
        String password = input.nextLine();
        Cipher cipher = new Cipher(password);

        System.out.println("[+] Tast 1 for at kryptere en besked");
        System.out.println("[+] Tast 2 for at dekryptere en besked ");

        int decision = input.nextInt();

        if (decision == 1) {
                System.out.println("[+] Indtast besked til at kryptere: ");
                String inputMsg = input.nextLine();
            System.out.println(inputMsg);
        }


        /*switch (decision) {
            case (1):
                System.out.println("[+] Indtast besked til at kryptere: ");
                String inputMsg = input.nextLine();*/

        /*if (decision == 1){
            System.out.println("[+] Indtast besked til at kryptere: ");
            String inputMsg = input.nextLine();
        }*/

        /*

        else if (decision == 2){
            System.out.println("2");
        }

        else{
            System.out.println("Forkert tal");
        }
*/




    }
}
