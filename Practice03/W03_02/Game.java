// 컴퓨터학과, 20201019, 정채원
package Practice03.W03_02;

public enum Game {
    ROCK(0), PAPER(1), SCISSORS(2), ERROR(-1);

    private int code;

    Game(int code) {	// Constructor
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Game encode(String input) {
        if(input.equals("바위"))
            return Game.ROCK;
        else if(input.equals("보"))
            return Game.PAPER;
        else if(input.equals("가위"))
            return Game.SCISSORS;
        else
            return Game.ERROR;
    }
}
