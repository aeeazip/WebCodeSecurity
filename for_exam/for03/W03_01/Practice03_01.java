package for_exam.for03.W03_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03_01 {
    public static Game encode(String str) {
        if(str.equals("가위"))
            return Game.SCISSORS;
        else if(str.equals("바위"))
            return Game.ROCK;
        else if(str.equals("보"))
            return Game.PAPER;
        return Game.ERROR;
    }

    public static Score whoswin(Game com, Game you) {
        if(you == com)
            return Score.EQUAL;

        if(you == Game.ROCK)
            return com == Game.PAPER ? Score.LOSE : Score.WIN;
        else if(you == Game.PAPER)
            return com == Game.ROCK ? Score.WIN : Score.LOSE;
        else if(you == Game.SCISSORS)
            return com == Game.PAPER? Score.WIN : Score.LOSE;

        return Score.ERROR;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("컴퓨터의 입력: ");
        String computer = br.readLine();

        System.out.print("당신의 입력: ");
        String your = br.readLine();

        Score score = whoswin(encode(computer), encode(your));

        if(score == Score.WIN)
            System.out.println("당신이 이겼습니다.");
        else if(score == Score.LOSE)
            System.out.println("컴퓨터가 이겼습니다.");
        else
            System.out.println("비겼습니다.");
    }
}
