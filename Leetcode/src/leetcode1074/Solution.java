package leetcode1074;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String S) {

        if(S.length() == 0 || S.length() == 1)return S;
        int len = S.length();
        for(int i = 1; i < len; ){
            //length = 0
            if(len == 0 || len == 1)return S;

            //左边和右边相同的时候
            if(S.charAt(i-1) == S.charAt(i)){
                len = len-2;
                S = removeString(S,i);
                i=1;
            }else{
                i++;
            }
        }

        return S;
    }

    private String removeString(String s, int i) {
        if(s.length() == 2){
            s = "";
            return s;
        }
        String preSubString = "";
        if(i > 1) {
            preSubString = s.substring(0, i - 1);
        }

        String lastSubString = "";
        if(s.length() > i+1){
            lastSubString = s.substring(i+1,s.length());
            s = preSubString+lastSubString;
        }else{
            s = preSubString;
        }
        return s;
    }


    public String removeDuplicates1(String S) {
        //栈来解决
        Stack<Character>tempResult = new Stack<>();

        for(char c : S.toCharArray()){
            if(!tempResult.isEmpty()){
                if(c == tempResult.peek()){
                    tempResult.pop();
                }else{
                    tempResult.push(c);
                }
            }else{
                tempResult.push(c);
            }
        }

        String finalString = "";
        for(char temp : tempResult){
            finalString += temp;
        }
        return finalString;
    }
}
