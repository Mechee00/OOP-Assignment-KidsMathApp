package entity;

public class Player {
    private String pName;

    public Player() {
    }

    public Player(String pName) {
        this.pName = pName;
    }

    public String getPName() {
        return this.pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public Player pName(String pName) {
        setPName(pName);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " pName='" + getPName() + "'" + "}";
    }

}
