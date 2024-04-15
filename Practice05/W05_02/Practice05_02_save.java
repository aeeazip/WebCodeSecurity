// 컴퓨터학과, 20201019, 정채원
package Practice05.W05_02;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Practice05_02_save {
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

    // 해시 값을 파일에 저장하는 기능
    public static void saveHash(String output, byte[] result) {
        try (FileOutputStream out = new FileOutputStream(output)) {
            for(byte bytes : result) {
                String str = String.format("%02x", bytes) + "\t";
                out.write(str.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력 파일 이름 : ");
        String input = br.readLine();

        System.out.println("계산된 해시값");
        byte[] result = caculateHash(input);
        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }

        System.out.println();
        System.out.print("해시값을 저장할 파일이름 : ");
        String output = br.readLine();
        saveHash(output, result);

        br.close();
    }
}
