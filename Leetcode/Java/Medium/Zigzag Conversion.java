class Solution {
public String convert(String s, int numRows) {
        StringBuilder answer = new StringBuilder();
        StringBuilder[] rows = new StringBuilder[numRows];
        boolean reverseFlag = false;
        int rowPos = 0;

        if(s.length() <= 2 || numRows == 1) return s;

        for(int i = 0; i < s.length(); i++)
        {
            if(i < numRows)
            {
                rows[i] = new StringBuilder();
            }
            
            rows[rowPos].append(s.charAt(i));
            
            if(rowPos == numRows-1) reverseFlag = true;
            else if (rowPos == 0) reverseFlag = false;

            if(reverseFlag) rowPos--;
            else    rowPos++;
        }

        for(int i = 0; i < numRows; i++)
        {
            if(rows[i] != null)
                answer.append(rows[i]);
        }

        return answer.toString();
    }

}
