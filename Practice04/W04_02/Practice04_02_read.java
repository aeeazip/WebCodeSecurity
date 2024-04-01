// 컴퓨터학과, 20201019, 정채원
package Practice04.W04_02;

import java.io.*;

public class Practice04_02_read {
    // 주어진 파일에 저장된 정보를 이용하여 객체를 생성 및 반환
    // 객체 정보는 파일에 텍스트 형태로 저장되어 있다고 가정
    static Student readObject(String fname) throws IOException {
        try(FileInputStream fis = new FileInputStream(fname)) {
            try(ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object obj = ois.readObject();
                Student student = (Student) obj;
                return student;
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("정보를 읽어올 파일 이름을 입력하세요 : ");
        String fname = br.readLine();

        System.out.println("생성된 학생 객체의 정보입니다.");
        Student student = readObject(fname);
        System.out.println(student.toString());
    }
}
