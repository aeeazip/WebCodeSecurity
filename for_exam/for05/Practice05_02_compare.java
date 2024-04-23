package for_exam.for05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Practice05_02_compare {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력 파일 이름 : ");
        String inputFile = br.readLine();

        byte[] inputs = new byte[]{};
        try(FileInputStream fis = new FileInputStream(inputFile)) {
            inputs = fis.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(inputs);
        byte[] result = messageDigest.digest();

        System.out.println("계산된 해시값");
        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("저장된 해시갑 파일 이름 : ");
        String hashFile = br.readLine();

        byte[] hashResult = new byte[]{};
        try(FileInputStream fis = new FileInputStream(hashFile)) {
            hashResult = fis.readAllBytes();
        }

        for(byte bytes : hashResult) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();
        System.out.print("비교 결과 : " + new String(result).equals(new String(hashResult)));
    }
}
