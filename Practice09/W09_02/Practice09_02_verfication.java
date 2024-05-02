// 컴퓨터학과, 20201019, 정채원
package Practice09.W09_02;

import java.io.*;
import java.security.*;

public class Practice09_02_verfication {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String keyAlgorithm = "RSA";
        final String signAlgorithm = "SHA256withRSA";

        System.out.print("데이터 파일 이름 : ");
        String dataFile = br.readLine();

        byte[] readData = new byte[0];
        try(FileInputStream fis = new FileInputStream(dataFile)) {
            readData = fis.readAllBytes();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("공개키 파일 이름 : ");
        String publicKeyFile = br.readLine();

        PublicKey publicKey;
        try(FileInputStream fis = new FileInputStream(publicKeyFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            publicKey = (PublicKey) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.print("전자서명 파일 이름 : ");
        String signedFile = br.readLine();

        byte[] signature = new byte[0];
        try(FileInputStream fis = new FileInputStream(signedFile)) {
            signature = fis.readAllBytes();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("입력된 서명 정보 : " + signature.length + " bytes");
        for(byte bytes : signature) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        Signature sig = Signature.getInstance(signAlgorithm);
        sig.initVerify(publicKey);
        sig.update(readData); // 검증할 평문을 매개변수로

        boolean result = sig.verify(signature); // 암호화된 해시값을 매개변수로 검증
        System.out.println("서명 검증 결과 : " + result);
    }
}
