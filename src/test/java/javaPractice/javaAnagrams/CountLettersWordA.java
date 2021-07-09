package javaPractice.javaAnagrams;


import java.util.Locale;

public  class CountLettersWordA extends CompareTwoStrings {

    CountLettersWordA(String a) {
        super(a, b);
    }

    @Override
    public boolean isAnagram() {
        int wordCountA = 0;
        System.out.println("Character | Frequency: " + a);
        a = a.toLowerCase(Locale.ROOT);
        for (char letter = 'a'; letter <= 'z'; letter++) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == letter) {
                    wordCountA++;
                }
            }
            if (wordCountA > 0) {
                System.out.println(Character.toUpperCase(letter) + " or " + letter +
                        " \t  | " + wordCountA);
                wordCountA = 0;
                }

        }
        return true;
    }
}








