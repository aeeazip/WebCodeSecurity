package for_exam.for04;

import java.io.*;
import java.util.Scanner;

public class Test_Stream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("output.txt");

        try {
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
        } finally {
            if(fis != null)
                fis.close();

            if(fos != null)
                fos.close();
        }

        /**********************************************************************/
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        pw.println("9.5");
        pw.println("567");
        pw.flush();

        Double sum = 0.0d;
        Scanner sc = new Scanner(new BufferedReader(new FileReader("output.txt")));
        while(sc.hasNext()) {
            if(sc.hasNextDouble()) {
                sum += sc.nextDouble();
            } else {
                sc.next();
            }
        }

        if(pw != null)
            pw.close();

        if(sc != null)
            sc.close();
    }
}
