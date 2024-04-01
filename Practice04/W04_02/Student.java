// 컴퓨터학과, 20201019, 정채원
package Practice04.W04_02;

import java.io.Serializable;

// 직렬화를 위해 Serializable 구현
public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // 버전 정보 (구현 시 재정의 필요)
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
}

