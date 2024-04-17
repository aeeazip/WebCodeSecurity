// 컴퓨터학과, 20201019, 정채원
package Practice07.W07_01;

import java.io.*;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Practice07_01_load {
    // 키 정보 출력 메소드
    public static void printKeyInfo(byte[] encodedKey, String algorithm) {
        System.out.println("암호화 알고리즘 : " + algorithm);
        System.out.println("복구된 공개키 정보 : ");
        System.out.println("키의 길이 (bytes) : " + encodedKey.length);
        for(byte bytes : encodedKey) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("공개키를 저장한 파일 이름 : ");
        String publicKeyFile = br.readLine();

        // 공개키 읽기 (자바 역직렬화 이용)
        PublicKey publicKey;
        try (FileInputStream fis = new FileInputStream(publicKeyFile)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object object = ois.readObject();
                publicKey = (PublicKey) object;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // 공개키 정보 출력
        byte[] encodedPublicKey = publicKey.getEncoded();
        String publicAlgorithm = publicKey.getAlgorithm();

        printKeyInfo(encodedPublicKey, publicAlgorithm);

        System.out.print("개인키를 저장한 파일 이름 : ");
        String privateKeyFile = br.readLine();

        // 개인키 읽기 (자바 역직렬화 이용)
        PrivateKey privateKey;
        try (FileInputStream fis = new FileInputStream(privateKeyFile)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object object = ois.readObject();
                privateKey = (PrivateKey) object;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // 개인키 정보 출력
        byte[] encodedPrivateKey = privateKey.getEncoded();
        String privateAlgorithm = privateKey.getAlgorithm();

        printKeyInfo(encodedPrivateKey, privateAlgorithm);

        br.close();
    }
}
