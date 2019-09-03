package com.company.String;

public class LC14_longestCommonPrefix {
    public String longestCommonPrefix(String[] s) {
        /*
            O(nm)
         */
//        if(s.length == 0) return "";
//        if(s.length == 1) return s[0];
//        StringBuilder sb = new StringBuilder();
//        for(int i = 1; i < s.length; i++){
//            if(i == 1){
//                int idx = 0;
//                while(idx < Math.min(s[i].length(), s[i-1].length()) && s[i-1].charAt(idx) == s[i].charAt(idx)){
//                    sb.append(s[i].charAt(idx));
//                    idx++;
//                }
//            }else{
//                StringBuilder temp = new StringBuilder();
//                int idx = 0;
//                while(idx < Math.min(s[i].length(), sb.length()) && sb.charAt(idx) == s[i].charAt(idx)){
//                    temp.append(s[i].charAt(idx));
//                    idx++;
//                }
//                sb = temp;
//            }
//        }
//        return sb.toString();
        if(s.length == 0) return "";
        String prefix = s[0];
        for(int i = 0; i < s.length; i++){
            // m.indexOf(n) takes O(m+n)
            while(s[i].indexOf(prefix) != 0) prefix = prefix.substring(0, prefix.length()-1 );
        }
        return prefix;
    }
}
