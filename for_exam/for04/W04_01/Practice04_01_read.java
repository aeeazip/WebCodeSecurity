package for_exam.for04.W04_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Practice04_01_read {
    public static Student readFromFile(String fname) {
        try(BufferedReader br = new BufferedReader(new FileReader(fname))) {
            Student student = new Student(br.readLine(), br.readLine(), br.readLine());
            return student;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("정보를 읽어올 파일 이름을 입력하세요 : ");
        String fname = br.readLine();

        System.out.println("생성된 학생 객체의 정보입니다.");
        Student student = readFromFile(fname);
        student.toString();
    }
}
