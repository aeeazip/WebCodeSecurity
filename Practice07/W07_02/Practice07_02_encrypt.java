// 컴퓨터학과, 20201019, 정채원
package Practice07.W07_02;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;

public class Practice07_02_encrypt {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("암호화 키 파일 : ");
        String encryptKeyFile = br.readLine();

        // 공개키 파일 읽어오기
        PublicKey publicKey;
        try (FileInputStream fis = new FileInputStream(encryptKeyFile)) {
            try (ObjectInputStream ois  = new ObjectInputStream(fis)) {
                Object object = ois.readObject();
                publicKey = (PublicKey) object;
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("데이터 파일 이름 : ");
        String dataFile = br.readLine();

        // 데이터 파일 읽기
        byte[] data;
        try (FileInputStream fis = new FileInputStream(dataFile)) {
            data = fis.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("암호데이터 출력 파일 : ");
        String encryptDataFile = br.readLine();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // 데이터 파일 암호화해서 저장
        try (FileOutputStream fos = new FileOutputStream(encryptDataFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            cos.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
