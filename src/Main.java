public class Main {
    static boolean binarySearch(int[] arr, int target){ // works in sorted array
        int start = 0, end = arr.length-1;
        while (start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] == target) return true;
            else if(target < arr[mid]) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
    static boolean binarySearch2(int[] arr, int s, int e, int target){
        if(s < e) {
            int mid = s + (e - s)/2;
            if (target == arr[mid]) return true;
            else if (target < arr[mid]) return binarySearch2(arr, s, mid - 1, target);
            else return binarySearch2(arr, mid + 1, e, target);
        }
        return false;
    }
    static int firstOcc(int[] a, int x){ // first occurence
        int n = a.length;
        int st = 0, end = n-1;
        int fo = -1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(a[mid] == x){
                fo = mid;
                end = mid-1;
            } else if(x < a[mid]) end = mid -1;
            else st = mid+1;
        }
        return fo;
    }
    static int sqrt(int x){
        int ans = 0;
        for (int i = 0; i < x/2; i++) {
            if(i*i <= x) ans = i;
            if(i*i > x) break;
        }
        return ans;
    }
    static int sqrt2(int x){
        int st = 0, end = x;
        int ans = -1;
        while(st <= end){
            int mid = st + (end-st)/2;
            int val = mid*mid;
            if(val == x) return mid;
            else if(val < x){
                ans = mid; st = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }

    static void main(String[] args) {
//        int[] arr2 = {1,4,5,6,9,13,17,25,34};
//        int[] arr = {1,3,4,5,9};
//        int target = 0;
//        while(target != 10){
//            System.out.printf("%d exists in arr: %b \n", target, binarySearch(arr, target));
//           System.out.println();
//            target++;
//        }
        int a = sqrt(24);
        System.out.println(a);

    }
}