// 컴퓨터학과, 20201019, 정채원
package Practice03.W03_02;

import java.util.Scanner;

public class Practice03_02 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);

        System.out.print("컴퓨터의 입력 : ");
        String comInput = s.next();
        Game com = Game.encode(comInput);

        System.out.print("당신의 입력 : ");
        String yourInput = s.next();
        Game user = Game.encode(yourInput);

        Score rslt = whoswin(user, com);
        System.out.println(Score.print(rslt));

        s.close();
    }

    public static Score whoswin(Game user, Game com) {
        // 사용자는 row ) 가위, 주먹, 보
        // 컴퓨터는 column ) 가위, 주먹, 보
        Score[][] scoreBoard = {
                { Score.EQUAL, Score.LOSE, Score.WIN },
                { Score.WIN, Score.EQUAL, Score.LOSE },
                { Score.LOSE, Score.WIN, Score.EQUAL }
        };

        // 주먹(0) 보(1) 가위(2)
        return scoreBoard[user.getCode()][com.getCode()];
    }
}
