package for_exam.for04.W04_01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Student {
    private String sid;
    private String name;
    private String major;

    public Student(String sid, String name, String major) {
        this.sid = sid;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    boolean writeToFile(String fname) {
        try(FileOutputStream fstream = new FileOutputStream(fname)) {
            String str = getSid() + "\n" + getName() + "\n" + getMajor();
            byte[] bytes = str.getBytes();
            fstream.write(bytes);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
