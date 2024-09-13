class Solution {
    char[][] phoneNumber = new char[][]
        {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };

    public List<String> letterCombinations(String digits) {
        List<String> combinationLists = new ArrayList<>();

        if(digits.isEmpty()) return combinationLists;
        
        StringBuilder letter = new StringBuilder();

        findcombination(combinationLists, digits, 0, letter);

        return combinationLists;
    }

    void findcombination(List<String> combination, String digits, int pos, StringBuilder letter){
        int number = Character.digit(digits.charAt(pos), 10) - 2; 

        for(int i = 0; i < phoneNumber[number].length; i++){
            StringBuilder makeLetter = new StringBuilder();
            makeLetter.append(letter);

            if(pos == digits.length()-1){
                combination.add(makeLetter.append(phoneNumber[number][i]).toString());
            }else{
                findcombination(combination, digits, pos+1, makeLetter.append(phoneNumber[number][i]));
            }
        }
    }
}
