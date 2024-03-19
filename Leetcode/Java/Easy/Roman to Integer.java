class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanSet = new HashMap<>();

        romanSet.put('I', 1);
        romanSet.put('V', 5);
        romanSet.put('X', 10);
        romanSet.put('L', 50);
        romanSet.put('C', 100);
        romanSet.put('D', 500);
        romanSet.put('M', 1000);

        int answer = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int now = romanSet.get(s.charAt(i));
            if (i < length - 1 && romanSet.get(s.charAt(i + 1)) > now) {
                answer += romanSet.get(s.charAt(i + 1)) - now;
                i++;
            } else {
                answer += now;
            }
        }
        return answer;
    }
}
