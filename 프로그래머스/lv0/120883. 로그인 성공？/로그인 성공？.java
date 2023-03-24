class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String result = "";
        for(String[] info : db) {
            if(info[0].equals(id_pw[0])) {
                if (!info[1].equals(id_pw[1])) {
                    result = "wrong pw";
                } else {
                    result = "login";
                }
            }
        }
        if(result.equals("")) {
            result = "fail";
        }

        return result;
    }
}