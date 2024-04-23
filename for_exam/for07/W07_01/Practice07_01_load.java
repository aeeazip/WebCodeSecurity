package for_exam.for07.W07_01;

import java.io.*;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Practice07_01_load {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("공개키를 저장한 파일 이름 : ");
        String publicFile = br.readLine();

        PublicKey publicKey;
        try(FileInputStream fis = new FileInputStream(publicFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            publicKey = (PublicKey) ois.readObject();
        } catch(ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        byte[] publicResult = publicKey.getEncoded();
        System.out.println("암호화 알고리즘 : " + publicKey.getAlgorithm());
        System.out.println("복구된 공개키 정보 : ");
        System.out.println("키의 길의 (bytes) : " + publicResult.length);
        for(byte bytes : publicResult) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("개인키를 저장한 파일 이름 : ");
        String privateFile = br.readLine();

        PrivateKey privateKey;
        try(FileInputStream fis = new FileInputStream(privateFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
          privateKey = (PrivateKey) ois.readObject();
        } catch(ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        byte[] privateResult = privateKey.getEncoded();
        System.out.println("암호화 알고리즘 : " + privateKey.getAlgorithm());
        System.out.println("복구된 개인키 정보 : ");
        System.out.println("키의 길이 (bytes) : " + privateResult.length);
        for(byte bytes : privateResult) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
    }
}
