// 컴퓨터학과, 20201019, 정채원
package Practice02;

public class Practice02_01 {
    public static void calcSum(Integer... n) {
        int sum = 0;
        for(Integer i : n) {
            sum += i;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        calcSum(10, 20);
        calcSum(10, 20, 30);
        calcSum(10, 20, 30, 40, 50);
    }
}
