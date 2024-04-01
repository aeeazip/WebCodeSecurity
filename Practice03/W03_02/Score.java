// 컴퓨터학과, 20201019, 정채원
package Practice03.W03_02;

public enum Score {
    WIN, LOSE, EQUAL, ERROR;

    public static String print(Score score) {
        if(score == Score.WIN)
            return "당신이 이겼습니다.";
        else if(score == Score.LOSE)
            return "컴퓨터가 이겼습니다.";
        else if(score == Score.EQUAL)
            return "비겼습니다.";
        else
            return "에러가 발생했습니다.";
    }
}
