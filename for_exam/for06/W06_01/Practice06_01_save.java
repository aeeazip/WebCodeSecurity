package for_exam.for06.W06_01;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Practice06_01_save {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);

        SecretKey secretKey = keyGen.generateKey();
        byte[] result = secretKey.getEncoded();

        System.out.print("암호화 알고리즘 : " + secretKey.getAlgorithm());
        System.out.print("키의 길의 (bytes) : " + result.length);

        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("비밀키를 저장할 파일 이름 : ");
        String fname = br.readLine();

        try(FileOutputStream fstream = new FileOutputStream(fname);
        ObjectOutputStream ostream = new ObjectOutputStream(fstream)) {
            ostream.writeObject(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
