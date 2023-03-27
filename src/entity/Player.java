package entity;

public class Player {
    // Player property
    private String pName;

    // Consturctor
    public Player() {
    }

    // Full par consturctor
    public Player(String pName) {
        this.pName = pName;
    }

    // Getter
    public String getPName() {
        return this.pName;
    }

    // Setter
    public void setPName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "{" + " pName='" + getPName() + "'" + "}";
    }

}
