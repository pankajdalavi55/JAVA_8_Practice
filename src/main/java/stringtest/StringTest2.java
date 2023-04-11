package stringtest;

import java.util.Arrays;

public class StringTest2 {

    public static void main(String[] args) {

        int[] arr = new int[]{5,7,9,15,24,43,46};
        int target = 48;

        // ceiling number
        Integer ceilingNumb = ceilingOfNumberInArray(arr, target);
        System.out.println("ceiling of number : "+ ceilingNumb);

        // floor number
        Integer floorNumb = floorOfNumberInArray(arr, target);
        System.out.println("ceiling of number : "+ floorNumb);

        // smallest letter greater than target
        char[] charArr = new char[] {'c','f','j','l','n','q','t'};
        char greaterChar = smallestLetterGreaterThanTarget(charArr, 'v');
        System.out.println("smallest letter greater than target :"+ greaterChar);

        // find the start and end index of target element

        int[] indArr = {5,7,7,7,7,8,9};
        int[] targetFirstLastPos = findFirstAndLastPosition(indArr, 6);
        System.out.println("target first and last position :"+ Arrays.toString(targetFirstLastPos));
    }

    private static int[] findFirstAndLastPosition(int[] indArr, int target) {
        int first = findPosition(indArr, target, true);
        int last = findPosition(indArr, target, false);
        return new int[]{first, last};
    }

    private static int findPosition(int[] arr, int target, boolean findingFirst) {
        int low = 0;
        int high = arr.length -1;
        int ans = -1;

        while (low <= high){
            int mid = low +((high-low)/2);
            if (target == arr[mid]){
                ans = mid;
                if (findingFirst){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else if (target > arr[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return ans;
    }

    private static char smallestLetterGreaterThanTarget(char[] charArr, char target) {
        if(target == 'z' || target == 'a') return charArr[0];

        int low = 0;
        int high = charArr.length -1;
        while(low <= high){
            int mid = low +((high-low)/2);
            if(target > charArr[mid]) low = mid+1;
            else high = mid-1;
        }
        if (low > charArr.length-1) return charArr[0];
        else return charArr[low];
    }

    private static Integer floorOfNumberInArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while(low<= high){
            int mid = low +((high-low)/2);
            if(target == arr[mid]) return arr[mid];
            if(target > arr[mid]) low = mid+1;
            else high=mid-1;
        }
        if(low-1<0) return -1;
        else return arr[low-1];
    }

    private static int ceilingOfNumberInArray(int[] arr, int target) {

        int low = 0;
        int high = arr.length -1;

        while (low <= high){
            int mid = low +((high-low)/2);
            if(target == arr[mid]) return arr[mid];
            if(target > arr[mid]) low = mid+1;
            else high = mid-1;
        }
        if(low>arr.length-1) return -1;
        else return arr[low];
    }


}
