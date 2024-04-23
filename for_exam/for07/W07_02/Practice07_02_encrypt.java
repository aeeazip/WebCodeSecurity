package for_exam.for07.W07_02;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Practice07_02_encrypt {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("암호화 키 파일 : ");
        String keyFile = br.readLine();

        PublicKey publicKey;
        try(FileInputStream fis = new FileInputStream(keyFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            publicKey = (PublicKey) ois.readObject();
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

        System.out.print("암호데이터 출력 파일 : ");
        String encryptFile = br.readLine();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        try(FileOutputStream fis = new FileOutputStream(encryptFile);
        CipherOutputStream cis = new CipherOutputStream(fis, cipher)) {
            cis.write(data);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
