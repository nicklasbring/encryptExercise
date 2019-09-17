package Client;

import javax.crypto.Cipher;
import java.io.Serializable;

public class MessageInfo implements Serializable {

    private String afsender;
    private String besked;
    private String kode;

    public MessageInfo(String kode, String afsender, String besked) {
        this.afsender = afsender;
        this.besked = besked;
        this.kode = kode;
    }

    public String getAfsender() {
        return afsender;
    }

    public void setAfsender(String afsender) {
        this.afsender = afsender;
    }

    public String getBesked() {
        return besked;
    }

    public void setBesked(String besked) {
        this.besked = besked;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
