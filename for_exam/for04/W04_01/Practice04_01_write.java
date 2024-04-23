package for_exam.for04.W04_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice04_01_write {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("학생 정보를 입력하세요: ");
        String[] str = br.readLine().split(" ");

        System.out.println("생성된 학생 객체의 정보입니다.");
        Student student = new Student(str[0], str[1], str[2]);
        student.toString();

        System.out.print("정보를 저장할 파일을 입력하세요 : ");
        String fname = br.readLine();
        student.writeToFile(fname);

        System.out.print("프로그램을 종료합니다.");
    }
}
