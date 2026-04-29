public class Problems {
    // on ratated sorted arrays
    static int minIdx(int[] arr){
        int st = 0, end = arr.length - 1;
        int ans = -1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(arr[mid] <= arr[end]){
                ans = mid;
                end = mid - 1;
            } else st = mid+1;
        }
        return ans;
    }
    static int indexOf(int[] arr, int x){
        int st = 0, end = arr.length-1;
        int ans = -1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(arr[mid] == x) return mid;
            if(arr[mid] < arr[end]) {
                if (x > arr[mid]) st = mid + 1;
                else end = mid - 1;
            }
            else {
                if(x > arr[st]) end = mid -1;
                else st = mid+1;
            }
        }
        return ans;
    }
    static int existsInRotatedArrayOfRepeatedElements(int [] arr, int x){
        int st = 0, end = arr.length-1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(arr[mid] == x) return mid;
            else if(arr[st] == arr[mid] && arr[mid] == arr[end]){
                st++; end--;
            }
            else if(arr[mid] <= arr[end]) {
                if (x > arr[mid] && x <= arr[end]) st = mid + 1;
                else end = mid - 1;
            }
            else {
                if(x > arr[st] && x < arr[mid]) end = mid -1;
                else st = mid+1;
            }

        }
        return -1;
    }
    static boolean isDivPossible(int[] a, int m, int maxChocAllowed){
        int students = 1;
        int choc = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > maxChocAllowed) return false;
            if(choc + a[i] <= maxChocAllowed) choc += a[i];
            else {
                students++; choc = a[i];
            }
        }
        return students <= m;
    }
    static int distributeChocolates(int[] a, int m){
        if(a.length < m) return -1;
        int ans = 0, st = 1, end = (int)1e9;
        while(st <= end){
            int mid = st + (end - st)/2;
            if(isDivPossible(a,m,mid)){
                ans = mid;
                end = mid - 1;
            } else {
                st = mid+1;
            }
        }
        return ans;
    }

    static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10,1,2,3,4};
        int[] arr1 = {1,1,1,2,2,3,1,1,1,1};
        System.out.println(existsInRotatedArrayOfRepeatedElements(arr1, 3));
    }
}
