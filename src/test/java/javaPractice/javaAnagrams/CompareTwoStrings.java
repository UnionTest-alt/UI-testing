package javaPractice.javaAnagrams;

import java.util.Arrays;
import java.util.Locale;

public  class CompareTwoStrings {
    static String a;
    static String b;
    CompareTwoStrings(String a, String b){
        this.a = a;
        this.b = b;
    }
    public  boolean isAnagram() {
        out:
        if (a.length() >= 1 && a.length() <= 50 && b.length() >= 1
                && b.length() <= 50 && a.length() == b.length()) {
            String aTemp = a.toLowerCase(Locale.ROOT);
            String bTemp = b.toLowerCase(Locale.ROOT);
            String[] arrayA = aTemp.split("");
            String[] arrayB = bTemp.split("");
            Arrays.sort(arrayA);
            Arrays.sort(arrayB);
            String tempA = "";
            String tempB = "";

            for (int i = 0; i < arrayA.length; i++) {
                if (a.charAt(i) < 65 || a.charAt(i) > 122) {
                    break out;
                }
                tempA += arrayA[i] + "";
                tempB += arrayB[i] + "";

            }
            if (tempA.equals(tempB)) {
                return true;

            } else {

            }
        }
        return false;
    }
}
