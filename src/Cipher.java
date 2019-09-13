public class Cipher {

    private String key;
    private int shift;


    public Cipher(String key){
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

        return null;
    }

    public String decrypt(){
        return null;
    }


}
