import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        // 장르별 총 재생 횟수 집계
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }

        // 가장 많이 재생된 장르순으로 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a, b)-> map.get(b).compareTo(map.get(a)));
        int answerPos = 0;
        // 장르별 재생 횟수 리스트 생성
        for (String genre : keySet) {
            HashMap<Integer,Integer> genrePlay = new HashMap<>();
			for(int i = 0; i < plays.length; i++){
                if(genres[i].equals(genre)){
                    genrePlay.put(i,plays[i]);
                }
            }
            
            // 장르별 재생 횟수 정렬
            List<Integer> sortValue = new ArrayList<>(genrePlay.keySet());
            Collections.sort(sortValue,(a, b)-> genrePlay.get(b).compareTo(genrePlay.get(a)));
            // 재생 횟수별 list 선별
            for(int i = 0; (i < 2 && i < sortValue.size()); i++){
                answerList.add(sortValue.get(i));
            }
		} 
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
