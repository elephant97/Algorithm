class Solution {
    int[] romanValue = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanSymbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < romanValue.length; i++) {         
            while (num >= romanValue[i]) {
                answer.append(romanSymbol[i]); 
                num -= romanValue[i]; 
            }
        }

        return answer.toString(); 
    }
}
