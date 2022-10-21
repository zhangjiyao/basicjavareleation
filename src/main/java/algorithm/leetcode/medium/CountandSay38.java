package algorithm.leetcode.medium;

public class CountandSay38 {
    public static void main(String[] args) {
        CountandSay38 test = new CountandSay38();
        String s = test.countAndSay(4);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if(n<1) return "";
        else return stringT("1",--n);
    }

    private String stringT(String s, int n) {
        if(n<1) return s;
        char[] chars = s.toCharArray();
        String temp = "";
        int count =0;
        for (int i = 0; i < s.length(); i++) {
            if((i+1<s.length() && chars[i] != chars[i+1]) ||i+1>=s.length()){
                temp+=(++count)+(chars[i]+"");
                count=0;
            }else count++;
        }
        return stringT(temp, --n);
    }


}
