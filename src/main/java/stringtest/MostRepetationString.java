package stringtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostRepetationString {

    public static void main(String[] args) {
        String str = mostused("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(str);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        String[] arr = paragraph.split(" ");

        List<String> ls = new ArrayList<>(Arrays.asList(banned));
        String out = "";
        int fin = 0;
        for(int i = 0; i<arr.length; i++){
            String word = arr[i].replaceAll("\\p{Punct}", "");
            int count =0;
            for(int j= 0; j<arr.length; j++){
                String key = arr[j].replaceAll("\\p{Punct}", "");
                if(word.equalsIgnoreCase(key)){
                    count++;
                }
            }
            if(!ls.contains(word) && count>fin){
                out = word;
                fin = count;
            }
        }

        return out;
    }

    static String mostused(String paragraph, String[] banned){

        List<String> ls = new ArrayList<>(Arrays.asList(banned));
        String out = "";
        int fin = 0;
        String[] arr = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");

        for(int i = 0; i<arr.length; i++){
            int count =0;
            for(int j= 0; j<arr.length; j++){
                if(arr[i].equalsIgnoreCase(arr[j])){
                    count++;
                }
            }
            if(!ls.contains(arr[i]) && count>fin){
                out = arr[i];
                fin = count;
            }
        }
        return out;
    }
}
