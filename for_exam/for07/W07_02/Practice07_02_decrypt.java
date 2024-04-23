package for_exam.for07.W07_02;

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
        String keyFile = br.readLine();

        PrivateKey privateKey;
        try(FileInputStream fis  = new FileInputStream(keyFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            privateKey = (PrivateKey) ois.readObject();
        } catch(ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }

        System.out.print("암호데이터 파일 : ");
        String encryptFile = br.readLine();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        try(FileInputStream fis = new FileInputStream(encryptFile);
        CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(cis));
            StringBuffer sb = new StringBuffer();

            String line = br1.readLine();
            while(line != null) {
                sb.append(line + "\n");
                line = br1.readLine();
            }

            System.out.println("복호화 결과 : " + sb);
        }

    }
}
