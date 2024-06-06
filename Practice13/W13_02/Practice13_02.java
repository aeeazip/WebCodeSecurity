// 컴퓨터학과, 20201019, 정채원
package Practice13.W13_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice13_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("날짜를 입력하세요 : ");
        String[] numbers = br.readLine().split("-");

        int year = Integer.parseInt(numbers[0]);
        int month = Integer.parseInt(numbers[1]);
        int day = Integer.parseInt(numbers[2]);
//        Date date = new Date(year, month, day);
//
//        String result = date.printWestern();
//        System.out.println("서양식 표기 : " + result);
    }
}
