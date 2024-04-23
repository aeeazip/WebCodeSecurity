package for_exam.for02;

import java.util.Comparator;

// 학번으로 내림차순
public class SortByNumDesc implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.num - s2.num;
    }
}
