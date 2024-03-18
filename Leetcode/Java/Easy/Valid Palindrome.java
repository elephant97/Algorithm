class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right){
            char start = Character.toLowerCase(s.charAt(left));
            char end = Character.toLowerCase(s.charAt(right));

            if(!((start >= 'a' && start <= 'z') || (start >= '0' && start <= '9'))){
                left++;
                continue;
            }

            if(!((end >= 'a' && end <= 'z') || (end >= '0' && end <= '9'))){
                right--;
                continue;
            }
            
            if(start != end) return false;
            right--;
            left++;
        }

        return true;
    }
}
