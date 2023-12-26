import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class PsmResolve {
    Map<String, List<Integer>> infoMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String inf : info) {
            String[] split = inf.split(" ");
            int score = Integer.parseInt(split[4]);
            // 모든 조합에 대해 점수를 저장
            generateCombination(split, score, "", 0);
        }

        // 각 리스트를 점수 기준으로 정렬
        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].replaceAll(" and ", " ").split(" ");
            int queryScore = Integer.parseInt(splitQuery[4]);
            answer[i] = countMatches(splitQuery, queryScore);
        }

        return answer;
    }

    private void generateCombination(String[] info, int score, String current, int index) {
        if (index == 4) {
            infoMap.putIfAbsent(current, new ArrayList<>());
            infoMap.get(current).add(score);
            return;
        }
        // 해당 조건을 포함하는 경우와 포함하지 않는 경우(와일드카드 "-") 모두 고려
        generateCombination(info, score, current + "-", index + 1);
        generateCombination(info, score, current + info[index], index + 1);
    }

    private int countMatches(String[] query, int queryScore) {
        String key = query[0] + query[1] + query[2] + query[3];
        if (!infoMap.containsKey(key)) {
            return 0;
        }
        List<Integer> scores = infoMap.get(key);
        // 이진 검색으로 필요한 점수 이상을 얻은 개수 계산
        int start = 0, end = scores.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) >= queryScore) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return scores.size() - start;
    }
}
