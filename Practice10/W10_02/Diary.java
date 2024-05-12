// 컴퓨터학과, 20201019, 정채원
package Practice10.W10_02;

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

    public Object clone() throws CloneNotSupportedException {
        Diary diary = (Diary) super.clone();
        diary.listOfDates = listOfDates.clone();

        /* 아래 코드 추가해야 배열 하위 요소까지 deep cloning 가능 */
        for (int i = 0; i < listOfDates.length; i++) {
            diary.listOfDates[i] = (Date) this.listOfDates[i].clone();
        }
        return diary;
    }
}
