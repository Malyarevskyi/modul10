package modul10;

import java.io.*;

public class dz10 {
    public static void main(String[] args) throws IOException {

        File file = new File("Test.txt");
        try (FileReader reader = new FileReader(file); FileWriter writer = new FileWriter("Test_new.txt");) {
            char[] buffer = new char[(int) file.length()];
            reader.read(buffer);
            System.out.println(new String(buffer));
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a encode key");
            int key = Integer.parseInt(input.readLine());
//            System.out.println(encode(new String(buffer), key));
            String encodetext = encode(new String(buffer), key);
            writer.write(encodetext);
//            System.out.println(decode(encode(new String(buffer), key), key));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static String decode(String enc, int key) {
        return encode(enc, 26 - key);
    }

    public static String encode(String enc, int key) {
        key = key % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + key) % 26));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + key) % 26));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

}
