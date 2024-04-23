package for_exam.for06.W06_01;

import javax.crypto.SecretKey;
import java.io.*;

public class Practice06_01_load {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("비밀키를 저장한 파일 이름 : ");
        String fname = br.readLine();

        SecretKey secretKey;
        try(FileInputStream fis = new FileInputStream(fname);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            secretKey = (SecretKey) ois.readObject();
        } catch(ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        byte[] result = secretKey.getEncoded();
        System.out.println("암호화 알고리즘 : " + secretKey.getAlgorithm());
        System.out.println("키의 길이 (bytes) : " + result.length);
        for(byte bytes : result) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();
    }
}
