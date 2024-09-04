class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        boolean goingDown = false;
        int rowPos = 0;

        for (char c : s.toCharArray()) {
            rows[rowPos].append(c);

            if (rowPos == 0 || rowPos == numRows - 1) {
                goingDown = !goingDown;
            }

            rowPos += goingDown ? 1 : -1;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }
}
