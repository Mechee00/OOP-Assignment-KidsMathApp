package entity;

public abstract class Game {
    // Basic and common properties for different game
    private int var1;
    private int var2;
    private int answer;
    private int userAnswer;
    private boolean ansIsCorrect;
    private mode modeOp;
    private mode gameMode;

    public enum mode {
        Add, Minus, Multiply, Mix
    }

    // Common method for generating random number
    public int GenerateRandomNumber(int min, int max) {
        return (int)(Math.random() * max) + min;
    }

    // Common method for cehcking the user's answer
    public void checkUserAnswer() {
        if (answer == userAnswer) {
            ansIsCorrect = true;
        } else {
            ansIsCorrect = false;
        }
    }

    // Empty constructor
    public Game() {
    }

    // Full par consturctor
    public Game(int var1, int var2, int answer, int userAnswer, boolean ansIsCorrect, mode modeOp, mode gameMode) {
        this.var1 = var1;
        this.var2 = var2;
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.ansIsCorrect = ansIsCorrect;
        this.modeOp = modeOp;
        this.gameMode = gameMode;
    }

    // Getter
    public int getVar1() {
        return this.var1;
    }

    public int getVar2() {
        return this.var2;
    }

    public int getAnswer() {
        return this.answer;
    }

    public int getUserAnswer() {
        return this.userAnswer;
    }

    public boolean isAnsIsCorrect() {
        return this.ansIsCorrect;
    }

    public boolean getAnsIsCorrect() {
        return this.ansIsCorrect;
    }

    public mode getModeOp() {
        return this.modeOp;
    }

    public mode getGameMode() {
        return this.gameMode;
    }

    // Setter
    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void setAnsIsCorrect(boolean ansIsCorrect) {
        this.ansIsCorrect = ansIsCorrect;
    }

    public void setModeOp(mode modeOp) {
        this.modeOp = modeOp;
    }

    public void setGameMode(mode gameMode) {
        this.gameMode = gameMode;
    }

    @Override
    public String toString() {
        return "{" + " var1='" + getVar1() + "'" + ", var2='" + getVar2() + "'" + ", answer='" + getAnswer() + "'"
                + ", userAnswer='" + getUserAnswer() + "'" + ", ansIsCorrect='" + isAnsIsCorrect() + "'" + ", modeOp='"
                + getModeOp() + "'" + ", gameMode='" + getGameMode() + "'" + "}";
    }

}