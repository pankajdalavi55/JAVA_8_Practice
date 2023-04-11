package practice;

public class SquareRoot {

    public static void main(String[] args) {
//        int x= 4;
//        int root = squareroot(x);
//        System.out.println(root);

        int d = mySqrt(6);
        System.out.println(d);
    }

    // we cant use this approach because
    // for higher value it throws Integer overflow exception
    private static int squareroot(int x) {
        if(x==0) return 0;
        if(x==1 || x==2) return 1;
        int i=0;
        for(i = 1; i<x; i++){
            if((i*i)==x){
                i = i;
                break;
            }else if(x<(i*i)){
                i= i-1;
                break;
            }
        }
        return i;
    }

    static int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1 || x==2) return 1;
        int low =1, high = x, ans=0;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(x/mid == mid) return mid;
            else if(x/mid < mid) high = mid-1;
            else{
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }

}

