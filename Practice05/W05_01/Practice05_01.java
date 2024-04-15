// 컴퓨터학과, 20201019, 정채원
package Practice05.W05_01;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Practice05_01 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plainText1 = "The Road Not Taken by Robert Frost";  // 평문
        byte[] data1 = plainText1.getBytes(); // String -> byte형 배열로 변환

        MessageDigest messageDigest1 = MessageDigest.getInstance("SHA-1");
        messageDigest1.update(data1); // 입력값 누적
        byte[] result1 = messageDigest1.digest();   // 해시값 계산 후 반환

        System.out.println("plaint text1 : " + plainText1);
        System.out.print("result1 (hex) : ");
        for (byte bytes : result1) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }

        System.out.println();

        // 실험 1. 같은 입력 값에 대해서 항상 같은 값이 출력되는가? -> 동일
        String plainText2 = "The Road Not Taken by Robert Frost";
        byte[] data2 = plainText1.getBytes();

        MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-1");
        messageDigest2.update(data2);
        byte[] result2 = messageDigest2.digest();

        System.out.println("\n실험1. 같은 입력 값에 대해서는 항상 같은 값이 출력되는가?");
        System.out.println("plain text2 : " + plainText2);
        System.out.print("result2 (hex) : ");
        for (byte bytes : result2) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }

        System.out.println();

        // 실험 2. 데이터에서 1글자 혹은 1단어가 달라지는 경우, 해시값은 얼마나 영향을 받는가? -> 영향 X
        String plainText3 = "The Road Not Taken by Lobert Frost";   // Robert -> Lobert로 변경
        byte[] data3 = plainText3.getBytes();

        MessageDigest messageDigest3 = MessageDigest.getInstance("SHA-1");
        messageDigest3.update(data3);
        byte[] result3 = messageDigest3.digest();

        int percentage = 0;
        for (int i = 0; i < result3.length; i++) {
            if(result3[i] == result1[i])
                percentage += 5;
        }

        System.out.println("\n실험2. 데이터에서 1글자 혹은 1단어가 달라지는 경우, 해시값은 얼마나 영향을 받는가?");
        System.out.println("plain text3 : " + plainText3);
        System.out.print("result3 (hex) : ");
        for (byte bytes : result3) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println("\nresult3과 result1은 " + percentage + "% 일치\n");

        // 실험 3. 데이터가 달라지는 위치는 결과 해시 값의 위치에 영향을 주는가? -> 영향 X (전혀 다른 값)
        String plainText4 = "The Road Not Taken by Frost Robert"; // Frost와 Robert 위치 변경
        byte[] data4 = plainText4.getBytes();

        MessageDigest messageDigest4 = MessageDigest.getInstance("SHA-1");
        messageDigest4.update(data4);
        byte[] result4 = messageDigest4.digest();

        System.out.println("실험3. 데이터가 달라지는 위치는 결과 해시 값의 위치에 영향을 주는가?");
        System.out.println("plain text4 : " + plainText4);
        System.out.print("result4 (hex) : ");
        for (byte bytes : result4) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }

        System.out.println();
    }
}
