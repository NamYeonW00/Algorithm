import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    
    String password = br.readLine();
    while (!password.equals("end")) {
      boolean isAcc = true;
      
      boolean hasVowel = false;
      for (char v : vowels)
          if (password.indexOf(v) != -1)
              hasVowel = true;
      
      if (!hasVowel)
          isAcc = false;

      int vowelCount = 0;
      int consonantCount = 0;
      char last = '-';
      for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);

        boolean isVowel = false;
        for (char v : vowels) {
            if (c == v) {
                isVowel = true;
                break;
            }
        }    
        if (isVowel) {
          vowelCount++;
          consonantCount = 0;
        }
        else {
          consonantCount++;
          vowelCount = 0;
        }

        if (vowelCount == 3 || consonantCount == 3)
          isAcc = false;
        
        if (c == last)
          if(c != 'e' && c != 'o')
            isAcc = false;

        last = c;
      }

      if (isAcc == true)
        System.out.println("<" + password + ">" + " is acceptable.");
      else
        System.out.println("<" + password + ">" + " is not acceptable.");

      password = br.readLine();
    }
  }
}