class Solution {
    
  public String solution(String s) {
      
        String[] wordArr = s.split(" ");
        char end = s.charAt(s.length() - 1);
      
        String result = "";
        for (int i = 0; i < wordArr.length; i++) {
          
            for (int j = 0; j < wordArr[i].length(); j++) {
                char alpha = wordArr[i].charAt(j);
                
                if (j == 0) {
                    alpha = Character.toUpperCase(alpha);
                } else {
                    alpha = Character.toLowerCase(alpha);
                }

                result += alpha;
            }
            result += " ";
        }
      
        if (end == ' ') {
            return result;
        }

        return result.trim();
  }
}