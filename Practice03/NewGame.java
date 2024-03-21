package Practice03;

public enum NewGame {
    ROCK(0), PAPER(1), SCISSORS(2), ERROR(-1);

    private int code;

    NewGame(int code) {	// Constructor
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static NewGame encode(String input) {
        if(input.equals("바위"))
            return NewGame.ROCK;
        else if(input.equals("보"))
            return NewGame.PAPER;
        else if(input.equals("가위"))
            return NewGame.SCISSORS;
        else
            return NewGame.ERROR;
    }
}
