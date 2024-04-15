// 컴퓨터학과, 20201019, 정채원
package Practice05.W05_02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Practice05_02_compare {
    // 평문 파일의 해시 값을 계산하는 기능
    public static byte[] caculateHash(String input) throws NoSuchAlgorithmException {
        byte[] data = new byte[]{};

        try (FileInputStream in = new FileInputStream(input)) {
            data = in.readAllBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(data);
            return messageDigest.digest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    // 파일에 저장된 해시 값을 불러오는 기능
    public static String readHash(String output) {
        try (FileInputStream in = new FileInputStream(output)) {
            byte[] result = in.readAllBytes();
            return new String(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    // 2개의 해시 값이 동일한지 여부를 판단하는 기능
    public static boolean compare(String hash, String save) {
        return hash.equals(save);
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hash = "";

        System.out.print("입력 파일 이름 : ");
        String input = br.readLine();

        System.out.println("계산된 해시값");
        byte[] result = caculateHash(input);
        for(byte bytes : result) {
            hash += String.format("%02x", bytes) + "\t";
        }
        System.out.println(hash);

        System.out.print("저장된 해시값 파일이름 : ");
        String output = br.readLine();
        String save = readHash(output);

        boolean compareResult = compare(hash, save);
        System.out.print("비교 결과 : " + compareResult);
        br.close();
    }
}
