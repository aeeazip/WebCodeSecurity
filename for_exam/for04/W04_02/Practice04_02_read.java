package for_exam.for04.W04_02;

import for_exam.for04.W04_01.Student;

import java.io.*;

public class Practice04_02_read {
    public static Student readObject(String fname) {
        try(FileInputStream fis = new FileInputStream(fname);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            Student student = (Student) ois.readObject();
            return student;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("정보를 읽어올 파일 이름을 입력하세요 : ");
        String fname = br.readLine();

        System.out.println("생성된 학생 객체의 정보입니다.");
        Student student = readObject(fname);
        student.toString();
    }
}
