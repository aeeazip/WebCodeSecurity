// 컴퓨터학과, 20201019, 정채원
package Practice07.W07_02;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public class Practice07_02_decrypt {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("복호화 키 파일 : ");
        String decryptKeyFile = br.readLine();

        // 개인키 파일 읽어오기
        PrivateKey privateKey;
        try (FileInputStream fis = new FileInputStream(decryptKeyFile);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
           Object object = ois.readObject();
           privateKey = (PrivateKey) object;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("암호데이터 파일 : ");
        String encryptedDataFile = br.readLine();

        // 데이터 파일 읽기
        byte[] data;
        try (FileInputStream fis = new FileInputStream(encryptedDataFile)) {
            data = fis.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 데이터 파일 복호화
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        try (FileInputStream fis = new FileInputStream(encryptedDataFile);
                CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(cis));
            StringBuffer sb  = new StringBuffer();

            String line = br1.readLine();
            while(line != null) {
                sb.append(line + "\n");
                line = br1.readLine();
            }

            System.out.println("복호화 결과 : \n" + sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
