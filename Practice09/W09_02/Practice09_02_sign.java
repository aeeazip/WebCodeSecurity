// 컴퓨터학과, 20201019, 정채원
package Practice09.W09_02;

import java.io.*;
import java.security.*;

public class Practice09_02_sign {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String keyAlgorithm = "RSA";
        final String signAlgorithm = "SHA256withRSA";

        System.out.print("데이터 파일 이름 : ");
        String dataFile = br.readLine();

        byte[] readData = new byte[0]; // plain text
        try(FileInputStream fis = new FileInputStream(dataFile)) {
            readData = fis.readAllBytes();
        }

        System.out.print("개인키 파일 이름 : ");
        String privateKeyFile = br.readLine();

        PrivateKey privateKey;
        try(FileInputStream fis = new FileInputStream(privateKeyFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            privateKey = (PrivateKey) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Signature sig = Signature.getInstance(signAlgorithm);
        sig.initSign(privateKey);
        sig.update(readData);

        byte[] signature = sig.sign(); // 전자서명 생성

        System.out.println("생성된 서명 정보 : " + signature.length + " bytes");
        for(byte bytes : signature) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("서명을 저장할 파일 이름 : ");
        String signedFile = br.readLine();

        try(FileOutputStream fos = new FileOutputStream(signedFile)) {
            fos.write(signature);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("서명을 파일에 저장했습니다.");
    }
}
