// 컴퓨터학과, 20201019, 정채원
package Practice06.W06_01;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Practice06_01_save {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("암호화 알고리즘 : ");
        String algorithm = br.readLine();

        KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
        keyGen.init(128);  // key의 길이 지정
        Key secretKey = keyGen.generateKey();   // 비밀키 생성

        byte[] result = secretKey.getEncoded();
        System.out.println("키의 길이 (bytes) : " + result.length);

        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("비밀키를 저장할 파일 이름 : ");
        String output = br.readLine();

        try (FileOutputStream fstream = new FileOutputStream(output)) {
            try (ObjectOutputStream ostream = new ObjectOutputStream(fstream)) {
                ostream.writeObject(secretKey); // 생성된 비밀키 객체를 파일에 저장
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
