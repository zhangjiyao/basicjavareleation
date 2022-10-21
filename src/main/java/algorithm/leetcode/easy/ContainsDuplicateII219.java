package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII219 {
    public static void main(String[] args) {
        ContainsDuplicateII219 test = new ContainsDuplicateII219();
        int[] arr={1,2,3,1};
        boolean b = test.containsNearbyDuplicate(arr,3);
        System.out.println(b);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = -1;
        boolean check = true;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && check){
                flag=nums[i];
                check=false;
            }

            if(map.containsKey(nums[i]) && flag==nums[i]){
                int j = map.get(nums[i]);
                if(Math.abs(i-j)<=k){
                    return true;
                }else map.put(nums[i],i);
            }else if(map.containsKey(nums[i]) && flag!=nums[i]){
                return false;
            }else map.put(nums[i],i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
