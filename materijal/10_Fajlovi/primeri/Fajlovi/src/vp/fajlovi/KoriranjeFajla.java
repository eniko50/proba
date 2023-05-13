package vp.fajlovi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class KoriranjeFajla {

	public static void main(String[] args) throws IOException  {
		FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/vp/fajlovi/turing.txt");
            out = new FileOutputStream("src/vp/fajlovi/outturing.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
       }
}
