// 컴퓨터학과, 20201019, 정채원
package Practice04.W04_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice04_01_write {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("학생 정보를 입력하세요 : ");
        String[] input = br.readLine().split(" "); // 입력 형식 : 학번 이름 학과
        Student student = new Student(input[0], input[1], input[2]);

        System.out.println("생성된 학생 객체의 정보입니다.");
        System.out.println(student.toString());

        System.out.print("정보를 저장할 파일 이름을 입력하세요 : ");
        String fname = br.readLine();
        boolean result = student.writeToFile(fname);

        if(result)
            System.out.println("프로그램을 종료합니다.");
    }
}
