package for_exam.for06.W06_02;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Practice06_02_decrypt {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("비밀키 파일 : ");
        String keyFile = br.readLine();

        SecretKey secretKey;
        try(FileInputStream fis = new FileInputStream(keyFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            secretKey = (SecretKey) ois.readObject();
        } catch(ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("암호 파일 : ");
        String encryptFile = br.readLine();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] data = new byte[]{};
        try(FileInputStream fis = new FileInputStream(encryptFile);
            CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(cis));
            StringBuffer sb = new StringBuffer();

            String line = br1.readLine();
            while(line != null) {
                sb.append(line + "\n");
                line = br1.readLine();
            }

            System.out.print(sb);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
