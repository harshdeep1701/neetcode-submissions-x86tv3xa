class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        int[] result = new int[nums.length];

        int product = 1;
        for(int i=0;i<nums.length;i++) {
            product*=nums[i];
            prefixProduct[i] = product;
        }

        product = 1;
        for(int i=nums.length-1;i>=0;i--) {
            product*=nums[i];
            suffixProduct[i] = product;
        }

        for(int i=0; i<nums.length; i++){
            if(i==0 && nums.length>1) {
                result[i] = suffixProduct[i+1];
            }else if(i==nums.length-1 && nums.length>1) {
                result[i] = prefixProduct[i-1];
            } else {
                result[i] = suffixProduct[i+1] * prefixProduct[i-1];
            }
        }
        
        return result;
    }
}  
