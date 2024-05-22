// 컴퓨터학과, 20201019, 정채원
package Practice10.W10_01;

import java.util.Arrays;

public class Diary implements Cloneable {
    public Date[] listOfDates = new Date[] {
            new Date(2019, 5, 13),
            new Date(2000, 1, 1),
            new Date(1988, 12, 25)
    };

    @Override
    public String toString() {
        return Arrays.toString(listOfDates);
    }

    /*
         clone 메소드는 protected 타입이므로 호출하는 클래스에서 Object를 상속을 받던가, 같은 패키지 내에 있어야 함
         근데 상속도 안받고, 같은 패키지 내에 있지도 않기 때문에
         Diary에서 public으로 오버라이딩 하지 않으면 메인에서 diary.clone 사용 불가
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
