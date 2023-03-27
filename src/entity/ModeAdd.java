package entity;

public class ModeAdd extends Game {

    public ModeAdd() {
        super.setVar1(super.GenerateRandomNumber(1, 20));
        super.setVar2(super.GenerateRandomNumber(1, 20));
        super.setAnswer((super.getVar1() + super.getVar2()));
        super.setModeOp(mode.Add);
        super.setGameMode(mode.Add);
    }
}
