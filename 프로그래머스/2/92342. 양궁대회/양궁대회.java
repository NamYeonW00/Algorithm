import java.util.*;

class Solution {
    int[] answer = {-1};
    int maxGap = 0;

    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        return answer;
    }
    
    // depth = 이번에 처리할 점수 (10점 ~ 0점)
    void dfs(int depth, int arrowsLeft, int[] ryan, int[] apeach) {
        // 모든 점수구간을 다 봤다면
        if (depth == 11) {
            // 남은 화살 모두 0점(마지막)에 몰아 넣기
            ryan[10] += arrowsLeft;

            int ryanScore = 0;
            int apeachScore = 0;

            for (int i = 0; i < 11; i++) {
                if (ryan[i] == 0 && apeach[i] == 0) continue;
                if (ryan[i] > apeach[i]) ryanScore += (10 - i);
                else apeachScore += (10 - i);
            }

            int gap = ryanScore - apeachScore;

            if (gap > 0) {
                if (gap > maxGap) {
                    maxGap = gap;
                    answer = ryan.clone();
                } else if (gap == maxGap) {
                    if (isBetter(ryan, answer)) {
                        answer = ryan.clone();
                    }
                }
            }

            ryan[10] -= arrowsLeft;
            return;
        }

        int needArrow = apeach[depth] + 1;

        if (arrowsLeft >= needArrow) {
            ryan[depth] = needArrow;
            dfs(depth + 1, arrowsLeft - needArrow, ryan, apeach);
            ryan[depth] = 0;
        }

        ryan[depth] = 0;
        dfs(depth + 1, arrowsLeft, ryan, apeach);
    }

    boolean isBetter(int[] cand, int[] curAns) {
        for (int i = 10; i >= 0; i--) {
            if (cand[i] != curAns[i]) {
                return cand[i] > curAns[i];
            }
        }
        return false;
    }
}