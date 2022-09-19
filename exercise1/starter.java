class Solution {
    public static int[] func(int[] arr) {
        int[] zero = {0};
        if(arr.length <=1) {
            return zero;
        }
        int[] arr2 = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            arr2[i] = 1;
        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                arr2[i] *= (j!=i) ? arr[j] : 1;
            }
        }
        return arr2;
    }
    public static int[] fasterfunc(int[] arr) {
        int[] arr2 = new int[arr.length];
        // if an array is of length 0 then there are no other elements to be multiplied(or could be null?)
        int[] zeroarr = {0};
        if(arr.length <=1) {
            return zeroarr;
        }

        // product can be divided by an element to receive the product of all other elements
        int product = 1;
        int zerocount = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=0) {
                product*=arr[i];
            }
            // when a zero(or multiple zeroes) are present in the array, division can be replaced by setting element to 0
            else {
                // zerocount will be later decremented when a zero is found, and the zero will be set to the first product
                // as long as there are no other zeroes
                zerocount++;
            }
        }

        // initialize arr2
        for(int i=0;i<arr.length;i++) {
            arr2[i] = 1;
        }

        // setting new array, temporarily decrements zerocount if current element is zero
        boolean currentZero = false;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==0) {
                zerocount--;
                currentZero = true;
            }
            // nonzero with no zeroes
            if((arr[i]!=0)&&(zerocount==0)) {
                arr2[i] *= (int)product/arr[i];
            }
            // nonzero with zeroes
            else if((arr[i]!=0)&&(zerocount>0)) {
                arr2[i] = 0;
            }
            // zero with other zeroes
            else if(zerocount>0) {
                arr2[i] = 0;
            }
            // zero with no other zeroes
            else {
                arr2[i] = product;
            }
            if(currentZero) {
                zerocount++;
            }
        }
        return arr2;
    }
    public static void print(int[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("}");
    }
}

public class starter {
    public static void main(String[] args) {
        int[] testarr = {1,2,3,4,0,5};
        int[] result = new int[testarr.length];
        result = Solution.fasterfunc(testarr);
        Solution.print(result);
    }
}
