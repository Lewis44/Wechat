

public class MessageRequestPacket extends Packet {


    private static final Byte MESSAGE_REQUEST = 3;
    private String message;

    public static Byte getMessageRequest() {
        return MESSAGE_REQUEST;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Byte getCommand() {

        return MESSAGE_REQUEST;

    }

}
