package entity;

public abstract class Game {

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

    public int GenerateRandomNumber(int min, int max) {
        return (int)(Math.random() * max) + min;
    }

    public void checkUserAnswer() {
        if (answer == userAnswer) {
            ansIsCorrect = true;
        } else {
            ansIsCorrect = false;
        }
    }

    public Game() {
    }

    public Game(int var1, int var2, int answer, int userAnswer, boolean ansIsCorrect, mode modeOp, mode gameMode) {
        this.var1 = var1;
        this.var2 = var2;
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.ansIsCorrect = ansIsCorrect;
        this.modeOp = modeOp;
        this.gameMode = gameMode;
    }

    public int getVar1() {
        return this.var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return this.var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isAnsIsCorrect() {
        return this.ansIsCorrect;
    }

    public boolean getAnsIsCorrect() {
        return this.ansIsCorrect;
    }

    public void setAnsIsCorrect(boolean ansIsCorrect) {
        this.ansIsCorrect = ansIsCorrect;
    }

    public mode getModeOp() {
        return this.modeOp;
    }

    public void setModeOp(mode modeOp) {
        this.modeOp = modeOp;
    }

    public mode getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(mode gameMode) {
        this.gameMode = gameMode;
    }

    public Game var1(int var1) {
        setVar1(var1);
        return this;
    }

    public Game var2(int var2) {
        setVar2(var2);
        return this;
    }

    public Game answer(int answer) {
        setAnswer(answer);
        return this;
    }

    public Game userAnswer(int userAnswer) {
        setUserAnswer(userAnswer);
        return this;
    }

    public Game ansIsCorrect(boolean ansIsCorrect) {
        setAnsIsCorrect(ansIsCorrect);
        return this;
    }

    public Game modeOp(mode modeOp) {
        setModeOp(modeOp);
        return this;
    }

    public Game gameMode(mode gameMode) {
        setGameMode(gameMode);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " var1='" + getVar1() + "'" +
            ", var2='" + getVar2() + "'" +
            ", answer='" + getAnswer() + "'" +
            ", userAnswer='" + getUserAnswer() + "'" +
            ", ansIsCorrect='" + isAnsIsCorrect() + "'" +
            ", modeOp='" + getModeOp() + "'" +
            ", gameMode='" + getGameMode() + "'" +
            "}";
    }

}