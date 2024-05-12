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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
