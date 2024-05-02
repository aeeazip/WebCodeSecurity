// 컴퓨터학과, 20201019, 정채원
package Practice09.W09_01;

import java.io.*;
import java.security.*;

public class Practice09_01_verification {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String keyAlgorithm = "RSA";
        final String signAlgorithm = "SHA256withRSA";

        System.out.print("서명에 사용할 데이터 : ");
        byte[] data = br.readLine().getBytes();

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

        byte[] readSigned = new byte[]{};
        try(FileInputStream fis = new FileInputStream(signedFile)) {
            readSigned = fis.readAllBytes();
        }

        System.out.println("입력된 서명 정보 : " + readSigned.length + " bytes");
        for(byte bytes : readSigned) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        Signature sig = Signature.getInstance(signAlgorithm);
        sig.initVerify(publicKey);
        sig.update(data);

        boolean result = sig.verify(readSigned);
        System.out.println(result);
    }
}
