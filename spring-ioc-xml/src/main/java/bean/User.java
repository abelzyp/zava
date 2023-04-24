package bean;

/**
 * @author Zhang
 * @since 2023/4/15
 */
public class User {

    private String nameP;
    private String emailP;

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public void add() {
        System.out.println("add ...");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + nameP + '\'' +
                ", email='" + emailP + '\'' +
                '}';
    }
}
