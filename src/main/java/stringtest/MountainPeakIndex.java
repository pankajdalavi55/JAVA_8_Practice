package stringtest;

public class MountainPeakIndex {

    public static void main(String[] args) {

        int[] arr = {9,12,6,5,3,2,1,0,-1};
        int index = mountainPeakIndexInBitonicArray(arr);

        System.out.println("mountainPeakIndexInBitonicArray : "+ arr[index]);

    }

    public static int mountainPeakIndexInBitonicArray(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while(low != high){
            int mid = low + ((high-low)/2);
            // Condition 1 when arr[mid] > arr[mid+1]
            // that means output is mid or is in left sub-array
            if(arr[mid] > arr[mid+1]){
                high = mid;
            }else{
                // condition2 : when arr[mid] < arr[mid+1]
                // that means output can be is in right subarray
                low = mid+1;
            }
        }
        return low;
    }
}
