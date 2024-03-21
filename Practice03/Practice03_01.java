package Practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03_01 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("컴퓨터의 입력: ");
        String computer = br.readLine();
        System.out.print("당신의 입력: ");
        String user = br.readLine();

        Score score = whoswin(encode(computer), encode(user));
        System.out.println(Score.print(score));
    }

    static Game encode(String str) {
        if(str.equals("바위"))
            return Game.ROCK;
        else if(str.equals("보"))
            return Game.PAPER;
        else if(str.equals("가위"))
            return Game.SCISSORS;
        else
            return Game.ERROR;
    }

    static Score whoswin(Game com, Game you) {
        if(com == you) {
            return Score.EQUAL;
        }

        if(you == Game.ROCK) {
            return com == Game.PAPER ? Score.LOSE : Score.WIN;
        } else if(you == Game.SCISSORS) {
            return com == Game.PAPER ? Score.WIN : Score.LOSE;
        } else if(you == Game.PAPER) {
            return com == Game.SCISSORS ? Score.LOSE : Score.WIN;
        } else
            return Score.ERROR;
    }
}
