package com.company.String;

public class LC468_validIPAddress {

    private boolean isIPv4(String IP){

        String[] ip = IP.split("\\.", -1);
        if(ip.length != 4) return false;
        for(String s : ip){
            if(s.length() > 3 || s.length() == 0) return false;
            int pos = 0;
            if(s.charAt(pos) == '0' && s.length() != 1) return false;
            int number = 0;
            while(pos < s.length() && s.charAt(pos) >= '0' && s.charAt(pos) <= '9'){
                number = 10*number + (s.charAt(pos) - '0');
                if(number > 255) return false;
                pos++;
            }
            if(pos != s.length()) return false;

        }

        return true;
    }

    private boolean isIPv6(String IP){

        String[] ip = IP.split(":", -1);
        if(ip.length != 8) return false;

        for(String s : ip){
            if(s.length() > 4 || s.length() == 0 ) return false;
            int pos = 0;
            while(pos < s.length() && ((s.charAt(pos) >= '0' && s.charAt(pos) <= '9') || (s.charAt(pos) >= 'a' && s.charAt(pos) <= 'f') || (s.charAt(pos) >= 'A' && s.charAt(pos) <= 'F'))){
                pos++;
            }
            if(pos != s.length()) return false;
        }
        return true;


    }


    public String validIPAddress(String IP) {
        if(isIPv4(IP)) return "IPv4";
        if(isIPv6(IP)) return "IPv6";
        return "Neither";
    }

    public static void main(String[] args) {
        LC468_validIPAddress L = new LC468_validIPAddress();
        String IP = "172.16.254.1";
        System.out.println(L.validIPAddress(IP));
    }
}
