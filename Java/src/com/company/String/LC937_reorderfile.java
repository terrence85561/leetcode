package com.company.String;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC937_reorderfile {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp == 0) return split1[0].compareTo(split2[0]);
                return cmp;
            }else if(isDigit1 && isDigit2){
                return 0;
            }else if(isDigit1 && !isDigit2){
                return 1;
            }else{
                return -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        LC937_reorderfile L = new LC937_reorderfile();
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(L.reorderLogFiles(logs)));
    }


}
