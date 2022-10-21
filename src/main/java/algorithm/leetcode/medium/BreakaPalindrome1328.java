package algorithm.leetcode.medium;

import java.util.Arrays;

public class BreakaPalindrome1328 {
    public static void main(String[] args) {
        String abc = "abc";
        char[] chars = abc.toCharArray();
        System.out.println();
    }

    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<2){
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]-'a'>0 && chars[i]-'a'<=26 && i!= chars.length/2){
                chars[i]='a';
                return new String(chars);
            }
            if(i==chars.length-1){
                chars[i]=++chars[i];
                return new String(chars);
            }
        }
        return "";
    }
}
