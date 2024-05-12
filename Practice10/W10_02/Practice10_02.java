// 컴퓨터학과, 20201019, 정채원
package Practice10.W10_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice10_02 {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Diary original = new Diary();
        System.out.println("Original Array: ");
        System.out.println(original);

        Diary cloned = (Diary) original.clone(); // 복제
        System.out.println("Cloned Array: ");
        System.out.println(cloned);

        System.out.print("\n변경하고 싶은 배열을 선택하세요(1-original/2-cloned): ");
        int arrayIndex = Integer.parseInt(br.readLine());
        System.out.print("변경하고 싶은 날짜의 인덱스를 입력하세요: ");
        int dateIndex = Integer.parseInt(br.readLine());

        System.out.print("년도: ");
        int year = Integer.parseInt(br.readLine());
        System.out.print("월: ");
        int month = Integer.parseInt(br.readLine());
        System.out.print("일: ");
        int date = Integer.parseInt(br.readLine());

        if(arrayIndex == 1) { // original
            original.listOfDates[dateIndex].year = year;
            original.listOfDates[dateIndex].month = month;
            original.listOfDates[dateIndex].date = date;
        } else { // cloned
            cloned.listOfDates[dateIndex].year = year;
            cloned.listOfDates[dateIndex].month = month;
            cloned.listOfDates[dateIndex].date = date;
        }

        System.out.println("\nOriginal Array: ");
        System.out.println(original);
        System.out.println("Cloned Array: ");
        System.out.println(cloned);
    }
}
