class Solution {
    public int[] plusOne(int[] digits) {
    //     int n = digits.length;
    //     int newdig=0;
    //     if(digits[n-1]==9){
            
    //     }
    //     else{
    //         newdig=digits[n-1]+1;
    //     }
    // }
    // return plusOne;
    for (int i = digits.length - 1; i >= 0; i--) {
\tif (digits[i] < 9) {
\t\tdigits[i]++;
\t\treturn digits;
\t}
\tdigits[i] = 0;
}

digits = new int[digits.length + 1];
digits[0] = 1;
return digits;
}
}