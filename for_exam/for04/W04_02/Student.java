package for_exam.for04.W04_02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private String sid;
    private String name;
    private String major;

    public Student(String sid, String name, String major) {
        this.sid = sid;
        this.name = name;
        this.major = major;
    }

    static boolean writeToFile(String fname, Student s) {
        try(FileOutputStream fstream = new FileOutputStream(fname);
        ObjectOutputStream ostream = new ObjectOutputStream(fstream)) {
            ostream.writeObject(s);
            return true;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
