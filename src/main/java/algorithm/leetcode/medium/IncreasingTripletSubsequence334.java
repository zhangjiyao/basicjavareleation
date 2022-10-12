package algorithm.leetcode.medium;

public class IncreasingTripletSubsequence334 {
    public static void main(String[] args) {
        IncreasingTripletSubsequence334 t = new IncreasingTripletSubsequence334();
//        int [] arr ={1,2,3,4,5};
        int [] arr ={1,5,0,4,1,3};
        boolean b = t.increasingTriplet(arr);
        System.out.println(b);
    }

    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if(length<3){
            return false;
        }
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
}
