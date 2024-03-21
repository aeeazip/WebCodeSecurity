package Practice02;

import java.util.Comparator;

// 학번에 의한 내림차순 정렬
public class SortByNumDesc implements Comparator<Student> {
    /*
    // version 1

    @Override
    public int compare(Practice02.Student o1, Practice02.Student o2) {
        if(o1.number > o2.number) return -1;
        else if(o1.number < o2.number) return 1;
        else return 0;
    }
    */

    // version 2
    @Override
    public int compare(Student o1, Student o2) {
        return o2.number - o1.number;
    }
}
