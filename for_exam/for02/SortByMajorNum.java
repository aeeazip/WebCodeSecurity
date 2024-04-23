package for_exam.for02;

import java.util.Comparator;

public class SortByMajorNum implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.major.equals(s2.major))
            return s1.num - s2.num;
        return s1.major.compareTo(s2.major);
    }
}
