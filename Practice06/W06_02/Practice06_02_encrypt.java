// 컴퓨터학과, 20201019, 정채원
package Practice06.W06_02;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Practice06_02_encrypt {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("비밀키 파일 : ");
        String secretKeyFile = br.readLine();

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        Key secretKey = keyGen.generateKey();

        try (FileOutputStream fostream = new FileOutputStream(secretKeyFile)) {
            try (ObjectOutputStream oostream = new ObjectOutputStream(fostream)) {
                oostream.writeObject(secretKey); // 생성된 비밀키 객체를 파일에 저장
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.print("데이터 파일 이름 : ");
        String dataFile = br.readLine();

        byte[] input;
        try (FileInputStream fistream = new FileInputStream(dataFile)) {
            input = fistream.readAllBytes();
        }

        System.out.print("암호화 출력 파일 : ");
        String encryptedFile = br.readLine();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (FileOutputStream fostream = new FileOutputStream(encryptedFile)) {
            try (CipherOutputStream cos = new CipherOutputStream(fostream, cipher)) {
                cos.write(input);
                cos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
