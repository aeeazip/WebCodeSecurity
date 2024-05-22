// 컴퓨터학과, 20201019, 정채원
package Practice12.W12_02;

import java.util.Scanner;

// getInput 메소드의 반환 값에 대한 post-condition으로 체크
public class Practice12_02_getInput2 {
    // 사용자가 이기면 1, 비기면 0, 사용자가 지면 -1을 반환
    private static int whoswin(String com, String you) {
        if(com.equals(you)) {
            return 0;
        }

        if(you.equals("바위")) {
            return com.equals("보") ? -1 : 1;
        } else if(you.equals("가위")) {
            return com.equals("보") ? 1 : -1;
        } else if(you.equals("보")) {
            return com.equals("가위") ? -1 : 1;
        }

        throw new IllegalArgumentException("판별할 수 없습니다.");
    }

    private static boolean checkInput(String input) {
        String[] possible = {"가위", "바위", "보"};
        for(String p : possible) {
            if(input.equals(p))
                return true;
        }
        return false;
    }

    private static String getInput(Scanner s) {
        return s.next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("컴퓨터의 생성 : ");
        String computer = getInput(sc);
        assert checkInput(computer): "잘못된 입력입니다.";

        System.out.print("당신의 입력 : ");
        String you = getInput(sc);
        assert checkInput(you): "잘못된 입력입니다.";

        int result = whoswin(computer, you);
        if(result == 0)
            System.out.println("비겼습니다.");
        else if(result == 1)
            System.out.println("당신이 이겼습니다.");
        else if(result == -1)
            System.out.println("컴퓨터가 이겼습니다.");
    }
}
