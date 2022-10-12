package algorithm.leetcode.medium;

import java.util.LinkedList;

/***
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 */
public class MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {
        MaximumLengthofRepeatedSubarray f = new MaximumLengthofRepeatedSubarray();
//        int[] n1={1,2,3,2,1};
//        int[] n2={3,2,1,4,7};
        int[] n1={0,0,0,0,0};
        int[] n2={0,0,0,0,0};
        int length = f.findLength(n1, n2);
        System.out.println(length);
    }
    public int findLength(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int ans=0;
        int dp[][]= new int[n+1][m+1];

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++){

                if(nums1[i-1]==nums2[j-1] ){
                    dp[i][j]= 1+ dp[i-1][j-1];
                    ans=Math.max (ans,dp[i][j] );
                }
                else dp[i][j]=0;
            }
        return ans;
    }
}
