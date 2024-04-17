// 컴퓨터학과, 20201019, 정채원
package Practice07.W07_01;

import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;

public class Pratice07_01_save {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA"); // key 알고리즘 지정
        keyPairGen.initialize(1024); // keysize 지정
        KeyPair keyPair = keyPairGen.generateKeyPair(); // KeyPair 생성

        String algorithm = keyPairGen.getAlgorithm();
        System.out.println("암호화 알고리즘: " + algorithm);

        PublicKey publicKey = keyPair.getPublic(); // 공개키 획득
        PrivateKey privateKey = keyPair.getPrivate(); // 개인키 획득

        byte[] encodedPublicKey = publicKey.getEncoded();
        byte[] encodedPrivateKey = privateKey.getEncoded();

        // 공개키 정보 출력
        System.out.println("생성된 공개키 정보 : ");
        System.out.println("키의 길이 (bytes) : " + encodedPublicKey.length);
        for(byte bytes : encodedPublicKey) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        // 개인키 정보 출력
        System.out.println("생성된 개인키 정보 : ");
        System.out.println("키의 길이 (bytes) : " + encodedPrivateKey.length);
        for(byte bytes : encodedPrivateKey) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("공개키를 저장할 파일 이름 : ");
        String publicKeyFile = br.readLine();

        // 공개키 저장
        try (FileOutputStream fostream = new FileOutputStream(publicKeyFile)) {
            try (ObjectOutputStream oostream = new ObjectOutputStream(fostream)) {
                oostream.writeObject(publicKey); // 자바 직렬화로 PublicKey 객체 출력
            }
        }

        System.out.print("개인키를 저장할 파일 이름 : ");
        String privateKeyFile = br.readLine();

        // 개인키 저장
        try (FileOutputStream fostream = new FileOutputStream(privateKeyFile)) {
            try (ObjectOutputStream oostream = new ObjectOutputStream(fostream)) {
                oostream.writeObject(privateKey); // 자바 직렬화로 PrivateKey 객체 출력
            }
        }

        br.close();
    }
}
