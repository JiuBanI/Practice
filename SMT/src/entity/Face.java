package entity;

/**
 * Created by 涔呬即銆�on 2018/1/25.
 */

public class Face {
    private int face_id;
    private String account;
    private String date;
    private int rose;

    public int getFace_id() {
        return face_id;
    }

    public void setFace_id(int face_id) {
        this.face_id = face_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRose() {
        return rose;
    }

    public void setRose(int rose) {
        this.rose = rose;
    }

    public Face() {
    }

    public Face(int face_id, String account, String date, int rose) {
        this.face_id = face_id;
        this.account = account;
        this.date = date;
        this.rose = rose;
    }
}
