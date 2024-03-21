package Practice02;

import java.util.Comparator;

// 전공에 의한 오름차순 정렬 + 같은 전공 내에서는 학번을 오름차순 정렬
public class SortByMajorNum implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.major.equals(o2.major))
            return o1.number - o2.number;
        else
            return o1.major.compareTo(o2.major);
    }
}