import java.util.*;

class Solution {
    public int[] solution(long n) {
        if (n == 0)
            return new int[]{0};
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while (n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }
        
        int answer[] = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}