// 컴퓨터학과, 20201019, 정채원
package Practice06.W06_02;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Practice06_02_decrypt {
    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("비밀키 파일 : ");
        String secretKeyFile = br.readLine();

        Key secretKey = null;
        try (FileInputStream fis = new FileInputStream(secretKeyFile)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object obj = ois.readObject();
                secretKey = (SecretKey) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("암호 파일 : ");
        String encrypedFile = br.readLine();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(encrypedFile)) {
            try (CipherInputStream cis = new CipherInputStream(fis, cipher)) {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(cis));
                StringBuffer sb = new StringBuffer();

                String line = br1.readLine();
                while(line != null) {
                    sb.append(line + "\n");
                    line = br1.readLine();
                }

                System.out.println(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
