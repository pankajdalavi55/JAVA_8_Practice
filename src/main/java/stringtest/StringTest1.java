package stringtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest1 {

    public static void main(String[] args) {

//        String str1 = "literal";
//        String str2 = new String("literal");
//        String str3 = "literal";
//
//        System.out.println("str1.equals(str2) :"+str1.equals(str2));
//        System.out.println("str1 == str2 :" +str1 == str2);
//        System.out.println("str1 == str3 :" +str1 == str3);
//
//
//        System.out.println("roman to integer");
//        String roman = "XIV";
//        int number = romanToInteger(roman);
//        System.out.println("romanToInteger for "+ roman+ " :"+number);
//
//        System.out.println("Integer To Roman");
//        String rom =  integerToRoman(3548);


        // possible permutation of Strings
        possiblePermutationOfString("qwertyuhjkllkjhuioklkjhg");




    }

    private static void possiblePermutationOfString(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        List<String> stringList = new ArrayList<>();

        for(int i = 0; i< n; i++){
            for (int j = 0; j<i; j++){
                stringList.add(str.substring(j,i));
            }
        }
        System.out.println(stringList);
        int high = 0;
        String longestPalindrome = "";
        for(String st : stringList){
            if(isPalindropmeString(st)){
                if(high<st.length()){
                    high = st.length();
                    longestPalindrome = st;
                }
            }
        }

        System.out.println("Longest Palindrome :"+ longestPalindrome);
    }

    private static boolean isPalindropmeString(String st) {
        if(st.isBlank() || st.isBlank() || st.length() ==1){
            return true;
        }
        String reverse = reverseString(st);
        return st.equals(reverse);
    }

    private static String reverseString(String st) {
        StringBuilder sb = new StringBuilder(st);
        return sb.reverse().toString();
    }

    private static String integerToRoman(int i) {
        if(i==0 || i<0) return "";

        StringBuilder sb = new StringBuilder();

        while(i != 0){
            int rem;
            if(i>1000){
               rem = i/1000;
               sb.append(getRepetationCharacter('M',rem));
               i = i%1000;
            } else if (i>500) {
                if(i>900){
                    sb.append("");
                    i -= 900;
                }else {
                    rem = i / 500;
                    sb.append(getRepetationCharacter('D', rem));
                    i = i % 500;
                }
            } else if (i>100) {
                rem = i/100;
                sb.append(getRepetationCharacter('C',rem));
                i = i%100;
            } else if (i>50) {

            } else if (i>10) {

            } else if (i>5) {

            } else if (i>1) {

            }
        }

        return sb.toString();
    }

    public static String getRepetationCharacter(Character ch, int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static Map<Character, Integer> getRomanValueMap(){
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        return romanMap;
    }
    private static int romanToInteger(String str) {
        Map<Character, Integer> romanMap = getRomanValueMap();

        if(str == null || str.isEmpty() || str.isBlank()){
            return -1;
        }
        int result = 0;
        for (int i= 0; i<str.length(); i++){
            int s1 = romanMap.get(str.charAt(i));

            if(i+1 < str.length()){
                int s2 = romanMap.get(str.charAt(i+1));
                if(s1<s2){
                    i++;
                    result = result+ (s2-s1);
                }else {
                    result = result+ s1;
                }
            }else {
                result = result+ s1;
            }
        }

        return result;

    }
}
