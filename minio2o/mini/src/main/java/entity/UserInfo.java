package entity;

public class UserInfo {
    private String userName;
    private String gender;
    private int qqNumber;
    private String addr;


    public UserInfo(String userName, String gender, int qqNumber, String addr) {
        this.userName = userName;
        this.gender = gender;
        this.qqNumber = qqNumber;
        this.addr = addr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(int qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
