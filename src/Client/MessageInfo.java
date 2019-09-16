package Client;

import java.io.Serializable;

public class MessageInfo implements Serializable {

    private String afsender;
    private String besked;

    public MessageInfo(String afsender, String besked) {
        this.afsender = afsender;
        this.besked = besked;
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
}
