package javaPractice.javaAnagrams;

public class CombineClass extends CompareTwoStrings {

    CombineClass(String a, String b) {
        super(a, b);
    }
    @Override
    public boolean isAnagram() {

        CountLettersWordA wordA = new CountLettersWordA(a);
        wordA.isAnagram();
        CountLettersWordB wordB = new CountLettersWordB(b);
        wordB.isAnagram();

        CompareTwoStrings word = new CompareTwoStrings(a, b);
        if (word.isAnagram()){
            System.out.println("Anagram");
        }else{
            System.out.println("Not Anagram");
        }
        return true;
    }

}
