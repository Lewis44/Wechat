
public class LoginRequestPacket extends Packet {

    private Integer userId;



    private String username;

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private String password;



    @Override

    public Byte getCommand() {



        return Command.LOGIN_REQUEST;

    }

}
