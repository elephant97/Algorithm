class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> strMap = new HashMap<>();
        List<List<String>> answerList = new ArrayList<>();
        int pos = 0;

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            
            if (strMap.get(String.valueOf(charArray)) == null) {
                strMap.put(new String(charArray), pos);
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                answerList.add(tempList);
                pos++;
            } else {
                int listPos = strMap.get(String.valueOf(charArray));
                answerList.get(listPos).add(strs[i]);
            }
        }

        return answerList;
    }
}
