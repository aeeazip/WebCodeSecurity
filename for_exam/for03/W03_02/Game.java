package for_exam.for03.W03_02;

public enum Game {
    ROCK(0), PAPER(1), SCISSORS(2), ERROR(-1);

    private final int num;

    Game(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }
}
