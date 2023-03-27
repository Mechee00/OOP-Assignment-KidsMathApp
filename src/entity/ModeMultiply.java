package entity;

public class ModeMultiply extends Game {
    // Constructor
    public ModeMultiply() {
        // Set multiply mode properties
        super.setVar1(super.GenerateRandomNumber(1, 10));
        super.setVar2(super.GenerateRandomNumber(1, 10));
        super.setAnswer((super.getVar1() * super.getVar2()));
        super.setModeOp(mode.Multiply);
        super.setGameMode(mode.Multiply);
    }
}
