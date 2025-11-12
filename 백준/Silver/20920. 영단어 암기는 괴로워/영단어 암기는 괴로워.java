import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      if (word.length() >= m) {
        if (map.containsKey(word))
          map.put(word, map.get(word) + 1);
        else {
          map.put(word, 1);
        }
      }
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

    list.sort((a, b) -> {
      int cmp = b.getValue().compareTo(a.getValue());
      if (cmp != 0)
        return cmp;

      cmp = Integer.compare(b.getKey().length(), a.getKey().length());
      if (cmp != 0)
        return cmp;

      return a.getKey().compareTo(b.getKey());
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    for (Map.Entry<String, Integer> entry : list)
      bw.write(entry.getKey() + "\n");

    bw.flush();
    bw.close();
  }
}