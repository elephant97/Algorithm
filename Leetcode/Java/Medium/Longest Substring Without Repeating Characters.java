class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int currentLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexMap.containsKey(c) && charIndexMap.get(c) >= start) {
                start = charIndexMap.get(c) + 1;
                currentLength = i - start + 1;
            } else {
                currentLength++;
            }
            charIndexMap.put(c, i);
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
