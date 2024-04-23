package for_exam.for02;

public class Practice02_01 {
    public static void calcSum(Integer... nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        calcSum(10, 20);
        calcSum(10, 20, 30);
        calcSum(10, 20, 30, 40, 50);
    }
}
