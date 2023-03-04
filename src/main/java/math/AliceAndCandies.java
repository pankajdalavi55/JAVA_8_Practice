package math;

public class AliceAndCandies {

    public static void main(String[] args) {

        int n = 45;
        int[] arr = new int[(n+1)/2];
        int i = 1;
        arr[0] = 1;
        int j = 1;
        while(i<n){
            arr[j++] = i+2;
            i+=2;
        }

        int x= 0;
        int z = 1;
        int sum = arr[0];
        int count = 0;
        while(x<arr.length){
            if(sum<n){
                sum += arr[z];
                z++;
            }else if(sum>45){
                sum -= arr[x];
                x++;
            }else{
                count++;
                sum -= arr[x];
            }
        }
        System.out.println("Count :"+count);
    }

}
