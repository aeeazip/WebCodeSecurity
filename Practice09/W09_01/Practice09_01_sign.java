// 컴퓨터학과, 20201019, 정채원
package Practice09.W09_01;

import java.io.*;
import java.security.*;

public class Practice09_01_sign {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 제출 시 privatekey 같이 제출할 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String keyAlgorithm = "RSA";
        final String signAlgorithm = "SHA256withRSA";

        System.out.print("서명에 사용할 데이터 : ");
        byte[] data = br.readLine().getBytes();

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
        sig.update(data);

        byte[] signature = sig.sign(); // 서명
        System.out.println("생성된 서명 정보 : " + signature.length + " bytes");
        for(byte bytes : data) {
            System.out.print(String.format("%02x", bytes) + "\t");
        }
        System.out.println();

        System.out.print("서명을 저장할 파일 이름 : ");
        String signedFile = br.readLine();

        try(FileOutputStream fos = new FileOutputStream(signedFile)) {
            fos.write(signature);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("서명을 파일에 저장했습니다.");
    }
}
