package for_exam.for07.W07_01;

import java.io.*;
import java.security.*;

public class Practice07_01_save {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        byte[] publicResult = publicKey.getEncoded();
        byte[] privateResult = privateKey.getEncoded();

        System.out.print("암호화 알고리즘 : " + keyPairGen.getAlgorithm());
        System.out.println("생성된 공개키 정보 :");
        System.out.println("키의 길이 (bytes) : " + publicResult.length);
        for(byte bytes : publicResult) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.println("생성된 개인키 정보 : ");
        System.out.println("키의 길이 (bytes) : " + privateResult.length);
        for(byte bytes : privateResult) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("공개키를 저장할 파일 이름 : ");
        String publicFile = br.readLine();

        try(FileOutputStream fstream = new FileOutputStream(publicFile);
        ObjectOutputStream ostream = new ObjectOutputStream(fstream)) {
            ostream.writeObject(publicKey);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("개인키를 저장할 파일 이름 : ");
        String privateFile = br.readLine();

        try(FileOutputStream fstream = new FileOutputStream(privateFile);
        ObjectOutputStream ostream = new ObjectOutputStream(fstream)) {
            ostream.writeObject(privateKey);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
