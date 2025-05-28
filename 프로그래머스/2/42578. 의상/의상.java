import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 1) + 1);
        }
        
        for (String key : hm.keySet()) {
            int value = hm.get(key);
            answer *= value;
        }
        
        return answer - 1;
    }
}