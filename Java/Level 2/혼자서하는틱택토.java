import java.util.HashMap;

class Solution {
    final int FALSE = 0;
    final int TRUE = 1;

    public int solution(String[] board) {
        HashMap<Character,Integer> count = new HashMap<Character,Integer>(){{
            put('O',0);
            put('X',0);
        }};
        boolean XbingoFlag = false;
        boolean ObingoFlag = false;

        for(String data: board){
            int beforeO = count.get('O');
            int beforeX = count.get('X');
            for(int index = 0; index < 3; index++){
                if(data.charAt(index) == 'O' || data.charAt(index) == 'X')
                   count.put(data.charAt(index), count.get(data.charAt(index))+1);
            }

            // 가로 빙고인 경우
            if(( count.get('X')-beforeX ) >= 3) XbingoFlag = true; 
            if(( count.get('O')-beforeO ) >= 3) ObingoFlag = true; 
        }
        //선공보다 후공이 더 많은 경우
        if(count.get('O') < count.get('X')) return FALSE;
        //선공보다 후공이 2번 이상 더 많이 진행 된 경우
        if(Math.abs(count.get('O') - count.get('X')) > 1) return FALSE;
        //선공만 진행되었거나 아무도 시작하지 않은 경우
        if((count.get('O') <= 1 && count.get('X') == 0) || (count.get('O') == count.get('X') && count.get('O') == 0)) return TRUE;
        // 대각선 빙고인 경우
        if((board[1].charAt(1) == board[0].charAt(0) && board[1].charAt(1) == board[2].charAt(2)) ||
           (board[1].charAt(1) == board[0].charAt(2) && board[1].charAt(1) == board[2].charAt(0)) ){
            if(board[1].charAt(1) == 'X')  XbingoFlag = true;
            if(board[1].charAt(1) == 'O')  ObingoFlag = true;
        }
        // 세로 빙고인 경우
        for(int i = 0; i < 3; i++){
            if((board[0].charAt(i) == board[1].charAt(i)) && (board[1].charAt(i) == board[2].charAt(i))){
                if(board[1].charAt(i) == 'X')  XbingoFlag = true;
                if(board[1].charAt(i) == 'O')  ObingoFlag = true;
            }
        }
        //X또는 O에서 bingo가 만들어졌는데, 계속 진행한 경우
        if((XbingoFlag && count.get('O') > count.get('X')) || (ObingoFlag && count.get('X') >= count.get('O'))) return FALSE;
        if(XbingoFlag == true && ObingoFlag == true) return FALSE;
       
        return TRUE;
    }
}
