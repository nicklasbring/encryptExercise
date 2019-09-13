import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Base64;

public class Cipher {

    private String key;
    private int shift;


    public Cipher(String key){
        this.key = key;
        // Generate shift length from input key
        if (key.length() > 26) {
            if (key.length() / 2 > 26) {
                this.shift = key.length() / 3;
            }
            else {
                this.shift = key.length() / 2;
            }
        }
        else {
            this.shift = key.length();
        }
    }

    public String encrypt(String msg){

        // Convert string to charArray
        char[] chars = msg.toCharArray();

        // Iterate over chars
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            switch (letter) {
                case ('Å'): letter = 'Å';
                case ('å'): letter = 'å';
                case ('Æ'): letter = 'Æ';
                case ('æ'): letter = 'æ';
                case ('Ø'): letter = 'Ø';
                case ('ø'): letter = 'ø';
                    continue;
            }
            letter = (char) (letter + this.shift);
            if (letter > '~') {
                letter = (char) (letter - 26);
            } else if (letter < ' ') {
                letter = (char) (letter + 26);
            }
            chars[i] = letter;
        }
        return Base64.getEncoder().encodeToString(new String(chars).getBytes());
    }

    public String decrypt(String input){
        //Decode Base64
        char[] chars = new String(Base64.getDecoder().decode(input)).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            switch (letter) {
                case ('Å'): letter = 'Å';
                case ('å'): letter = 'å';
                case ('Æ'): letter = 'Æ';
                case ('æ'): letter = 'æ';
                case ('Ø'): letter = 'Ø';
                case ('ø'): letter = 'ø';
                    continue;
            }
            letter = (char) (letter - this.shift);
            if (letter > '~') {
                letter = (char) (letter - 26);
            } else if (letter < ' ') {
                letter = (char) (letter + 26);
            }
            chars[i] = letter;
        }
        return new String(chars);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
