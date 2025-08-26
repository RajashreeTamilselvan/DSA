package Arrays;

class Solution {

    //  Approach 1
    //  calculate prefix as product from start to end. If prefix becomes 
    //  calculate suffix as product from end to start
    //  if 0 is found in suffix or prefix we will calculate product again from 1

    public int maxProduct(int[] nums) {
        int prefix = 1,suffix=1, maxProd=Integer.MIN_VALUE;
        //prefix will calculate product from start to end and viceversa for suffix
        // if 0 is found we will calculate product again from 1
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];
            maxProd = Math.max(maxProd,Math.max(prefix,suffix));   
        }
        return maxProd;
    }
}

