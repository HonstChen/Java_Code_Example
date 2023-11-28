package CustManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KB {
    public static String scan() {
        String str = "";
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            str = buf.readLine();
        } catch (Exception e) {

        }
        return str;
    }
}
