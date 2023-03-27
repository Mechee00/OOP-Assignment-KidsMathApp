package entity;

public class ModeMinus extends Game {
    // Constructor
    public ModeMinus() {
        // Set minus mode properties
        super.setVar1(super.GenerateRandomNumber(10, 11));
        super.setVar2(super.GenerateRandomNumber(1, 10));
        super.setAnswer((super.getVar1() - super.getVar2()));
        super.setModeOp(mode.Minus);
        super.setGameMode(mode.Minus);
    }

}
