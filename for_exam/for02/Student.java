package for_exam.for02;

public class Student implements Comparable<Student> {
    String major;
    int num;
    String name;

    public Student(String major, int num, String name) {
        this.major = major;
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" +
                major + '\'' +
                "/" + num +
                "/" + name + '\'' +
                ']';
    }

    public int compareTo(Student s) {
        return this.num - s.num;
    }
}
