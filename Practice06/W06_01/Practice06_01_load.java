// 컴퓨터학과, 20201019, 정채원
package Practice06.W06_01;

import javax.crypto.SecretKey;
import java.io.*;
import java.security.Key;

public class Practice06_01_load {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("비밀키를 저장한 파일 이름 : ");
        String input = br.readLine();

        Key secretKey = null;
        try (FileInputStream fis = new FileInputStream(input)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object obj = ois.readObject();
                secretKey = (SecretKey) obj;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        String algorithm = secretKey.getAlgorithm();
        System.out.println("암호화 알고리즘 : " + algorithm);

        byte[] result = secretKey.getEncoded();
        System.out.println("키의 길이 (bytes) : " + result.length);

        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
    }
}
