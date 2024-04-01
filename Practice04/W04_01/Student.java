// 컴퓨터학과, 20201019, 정채원
package Practice04.W04_01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    private String sid; // 학번
    private String name; // 이름
    private String major; // 전공

    public Student(String sid, String name, String major) {
        this.sid = sid;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student[" + name + ", " + sid + ", " + major + "]";
    }

    // 해당 객체를 주어진 파일에 텍스트 형태로 저장
    boolean writeToFile(String fname) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write(sid + "\n" + name + "\n" + major);
            bw.flush();
            bw.close();
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
