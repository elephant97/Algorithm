class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] answer = new int[nums1.length];
        int x = 0;
        int numPos1 = 0;
        int numPos2 = 0;

        while(x < nums1.length){
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;
            if(numPos1 < m){
                num1 = nums1[numPos1];
            }

            if(numPos2 < n){
                num2 = nums2[numPos2];
            }
            if(num1 <= num2){
                answer[x] = num1;
                numPos1++;
            }else{
                answer[x] = num2;
                numPos2++;
            }
            
            x++;
        }
        System.arraycopy(answer, 0, nums1, 0, nums1.length);
    }
}
