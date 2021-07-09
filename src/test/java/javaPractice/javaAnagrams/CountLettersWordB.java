package javaPractice.javaAnagrams;

import java.util.Locale;

public  class CountLettersWordB extends CompareTwoStrings{
    CountLettersWordB(String b) {
        super(a, b);
    }
    @Override
    public boolean isAnagram() {
        int wordCountB = 0;
        System.out.println("Character | Frequency: " + b);
        b = b.toLowerCase(Locale.ROOT);
        for (char letter = 'a'; letter <= 'z'; letter++) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == letter) {
                    wordCountB++;
                }
            }
            if (wordCountB > 0) {
                System.out.println(Character.toUpperCase(letter) + " or " + letter +
                        " \t  | " + wordCountB);
                wordCountB = 0;
            }

        }
        return true;
    }
}
