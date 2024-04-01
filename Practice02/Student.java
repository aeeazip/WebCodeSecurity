// 컴퓨터학과, 20201019, 정채원
package Practice02;

public class Student implements Comparable<Student> {
    String major;
    int number;
    String name;

    public Student(String major, int number, String name) {
        this.major = major;
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return major + "/" + number + "/" + name;
    }

    @Override
    public int compareTo(Student o) {
        // 현재객체.변수 - 매개변수객체.변수 : 오름차순 정렬
        // 매개변수객체.변수 - 현재객체.변수 : 내림차순 정렬
        return this.number - o.number;
    }
}
