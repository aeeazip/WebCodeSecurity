package for_exam.for06.W06_02;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Practice06_02_encrypt {
    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
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

        System.out.print("데이터 파일 이름 : ");
        String dataFile = br.readLine();

        byte[] data = new byte[]{};
        try(FileInputStream fis = new FileInputStream(dataFile)) {
            data = fis.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("암호화 출력 파일 : ");
        String encryptFile = br.readLine();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try(FileOutputStream fostream = new FileOutputStream(encryptFile);
        CipherOutputStream costream = new CipherOutputStream(fostream, cipher)) {
            costream.write(data);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
