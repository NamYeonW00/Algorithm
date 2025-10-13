import java.util.*;

class Solution {
    public int solution(String word) {
        int[] weight = {781, 156, 31, 6, 1};
        int array[] = new int[5];
        
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'A':
                    array[i] = 0;
                    break;
                case 'E':
                    array[i] = 1;
                    break;
                case 'I':
                    array[i] = 2;
                    break;
                case 'O':
                    array[i] = 3;
                    break;
                default:
                    array[i] = 4;
                    break;
            }
            
            answer += weight[i] * array[i] + 1;
        }
        
        return answer;
    }
}