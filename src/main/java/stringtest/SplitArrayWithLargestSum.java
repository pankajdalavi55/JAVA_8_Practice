package stringtest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SplitArrayWithLargestSum {
    public static void main(String[] args) {
//        int[] arr = {7,2,5,10,8};
//        int m = 2;
//
//        // divide the array  in m parts and whatever the min sum that we have to print
//
//        int smallestSum = splitArrayWithLargestSum(arr, m);
//        System.out.println("splitArrayWithLargestSum :"+ smallestSum);


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");

        System.out.println(map.containsValue("oned"));

        PriorityQueue<String> nn = new PriorityQueue<>();
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
    }

    private static int splitArrayWithLargestSum(int[] arr, int m) {

        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        while (start < end){

            int mid = (start+end)/2;
            int sum = 0;

            // count is called as part of arr
            int arrPieces = 1; // as starting we will consider that we have made one piece
            for (int numb :arr) {
                if(sum + numb > mid){
                    arrPieces++;
                    sum = numb;
                }else {
                    sum += numb;
                }
            }

            // arrPieces
            if(arrPieces > m){
                end =mid;
            }else {
                start = mid+1;
            }
        }

        return end;
    }
}
