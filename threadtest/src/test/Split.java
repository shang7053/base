package test;

import java.io.UnsupportedEncodingException;

public class Split {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(isGBK("s"));
    }

    public static boolean isGBK(String str) {
        char[] chars = str.toCharArray();
        boolean isGBK = false;
        for (char c : chars) {
            byte[] bytes = ("" + c).getBytes();
            if (bytes.length == 2) {
                int[] ints = new int[2];
                ints[0] = bytes[0] & 0xff;
                ints[1] = bytes[1] & 0xff;
                if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE) {
                    isGBK = true;
                    break;
                }
            }
        }
        return isGBK;
    }
}
