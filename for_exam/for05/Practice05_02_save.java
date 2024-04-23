package for_exam.for05;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Practice05_02_save {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력 파일 이름 : ");
        String inputFile = br.readLine();

        byte[] inputs;
        try(FileInputStream fis = new FileInputStream(inputFile)) {
            inputs = fis.readAllBytes();
        }

        // 해시 암호화
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(inputs);
        byte[] result = messageDigest.digest();

        System.out.println("계산된 해시값");
        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("해시값을 저장할 파일 이름 : ");
        String outputFile = br.readLine();

        try(FileOutputStream fostream = new FileOutputStream(outputFile)) {
            fostream.write(result);
        }
    }
}
