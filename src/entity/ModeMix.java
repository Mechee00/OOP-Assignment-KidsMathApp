package entity;

public class ModeMix extends Game {
    public ModeMix() {
        super.setGameMode(mode.Mix);
        // Set operator
        int randMode = super.GenerateRandomNumber(1, 3);
        switch (randMode) {
        case 1: // Add
            super.setVar1(super.GenerateRandomNumber(1, 20));
            super.setVar2(super.GenerateRandomNumber(1, 20));
            super.setAnswer((super.getVar1() + super.getVar2()));
            super.setModeOp(mode.Add);
            break;
        case 2: // Minus
            super.setVar1(super.GenerateRandomNumber(10, 11));
            super.setVar2(super.GenerateRandomNumber(1, 10));
            super.setAnswer((super.getVar1() - super.getVar2()));
            super.setModeOp(mode.Minus);
            break;
        case 3: // Multiply
            super.setVar1(super.GenerateRandomNumber(1, 10));
            super.setVar2(super.GenerateRandomNumber(1, 10));
            super.setAnswer((super.getVar1() * super.getVar2()));
            super.setModeOp(mode.Multiply);
            break;
        default:
            break;
        }
    }
}
