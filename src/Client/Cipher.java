package Client;

import java.util.Base64;

public class Cipher {

    private byte[] key;
    private int pos = 0;


    public Cipher(String key){
        this.key = key.getBytes();
    }

    public String encrypt(String msg){

        // Convert string to charArray
        byte[] bytes = msg.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] += getNextInKey();
        }

        pos = 0;

        String res = Base64.getEncoder().encodeToString(bytes);

        return res;
    }

    public String decrypt(String input){

        //Decode Base64
        byte[] bytes = Base64.getDecoder().decode(input);

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] -= getNextInKey();
        }

        pos = 0;

        return new String(bytes);
    }

    //Finds the next letter in the key array (resetting at the end of array and starts over)
    private byte getNextInKey(){

        if(pos < key.length){
            return key[pos++];
        } else {
            pos = 0;
            return key[pos++];
        }
    }
}