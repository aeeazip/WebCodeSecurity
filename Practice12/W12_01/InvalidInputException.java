// 컴퓨터학과, 20201019, 정채원
package Practice12.W12_01;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super("잘못된 입력입니다.");
    }
}
