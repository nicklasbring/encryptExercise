import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PrintWriter printWriter = null;

            System.out.println("[+] Indtast adgangskode: ");
            String password = input.nextLine();
            Cipher cipher = new Cipher(password);

            System.out.println("[+] Tast 1 for at kryptere en besked");
            System.out.println("[+] Tast 2 for at dekryptere en besked ");

            int decision = input.nextInt();

            switch (decision) {

                case 1:
                    System.out.println("[+] Indtast besked til at kryptere: ");
                    input.nextLine(); //throw away the \n not consumed by nextInt()
                    String inputMsg = input.nextLine();
                    try {
                        printWriter = new PrintWriter("textFile.txt");
                        printWriter.println(cipher.encrypt(inputMsg));
                        printWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } break;


                case 2:
                    BufferedReader bufferedReader = null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader("textFile.txt"));
                        String decryptedText;
                        while ((decryptedText = bufferedReader.readLine()) != null) {
                            printWriter = new PrintWriter("textFile.txt");
                                printWriter.println(cipher.decrypt(decryptedText));
                                printWriter.close();
                                System.out.println(cipher.decrypt(decryptedText));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } break;

                default:
                    System.out.println("Du har indtastet et forkert nummer. Prøv igen!");
                    break;

            }
        }
}
