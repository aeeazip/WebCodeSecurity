package for_exam.for03.W03_02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03_02 {
    public static Score whoswin(Game com, Game you) {
        Score[][] scoreBoard = {
                {Score.EQUAL, Score.LOSE, Score.WIN},
                {Score.WIN, Score.EQUAL, Score.LOSE},
                {Score.LOSE, Score.WIN, Score.EQUAL}
        };

       if(com == you)
           return Score.EQUAL;

       return scoreBoard[you.getNum()][com.getNum()];
    }

    public static Game encode(String str) {
        if(str.equals("가위"))
            return Game.SCISSORS;
        else if(str.equals("바위"))
            return Game.ROCK;
        else if(str.equals("보"))
            return Game.PAPER;
        return Game.ERROR;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("컴퓨터의 입력: ");
        String computer = br.readLine();

        System.out.print("당신의 입력: ");
        String your = br.readLine();

        Score score = whoswin(encode(computer), encode(your));
        System.out.println(Score.print(score));
    }
}
