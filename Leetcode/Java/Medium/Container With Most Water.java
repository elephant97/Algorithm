class Solution {
public int maxArea(int[] height) {
        
        int start = 0, end = height.length-1, maxAmount = 0; 
        
        while(start < end)
        {
            int waterLevel = Math.min(height[start], height[end]);
            int waterAmount = (end - start) * waterLevel;
            if(maxAmount < waterAmount)
                maxAmount = waterAmount;
            
            if(height[start] > height[end]) end--;
            else start++;
        }

        return maxAmount;
    }
}
