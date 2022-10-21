package algorithm.leetcode.easy;

import java.util.Arrays;

public class CheckiftheSentenceIsPangram1832 {
    public static void main(String[] args) {
        CheckiftheSentenceIsPangram1832 test = new CheckiftheSentenceIsPangram1832();
        boolean b = test.checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
        System.out.println(b);
//        boolean b1 = test.checkIfPangram("leetcode");
//        System.out.println(b1);
    }
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;
        int count = 0;
        char[] arr = new char[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i]='0';
        }
        char[] chars = sentence.toCharArray();
        for (char c : chars) {
            int i = c - 'a';
            if (arr[i] == '0') {
                arr[i]='1';
                count++;
            }
        }

        if (count==26) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkIfPangram1(String sentence) {
        int seen = 0;
        for(char c : sentence.toCharArray()) {
            int ci = c - 'a';
            seen = seen | (1 << ci);
        }
        return seen == ((1 << 26) - 1);
    }
}
