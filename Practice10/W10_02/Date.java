// 컴퓨터학과, 20201019, 정채원
package Practice10.W10_02;

public class Date implements Cloneable {
    public int year;
    public int month;
    public int date;

    @Override
    public String toString() {
        return year + "년 " + month + "월 " + date + "일";
    }

    public Date(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
