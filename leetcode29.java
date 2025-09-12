// Author: Garima Yadav
// Date:12 sep 2025
// Description: Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.



public class leetcode29 {
    public static  int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        boolean sign=true;
        if(dividend>=0&&divisor<0) sign=false;
        if(dividend<0&&divisor>0) sign=false;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        long ans=0;
        while(n>=d){
            int cnt=0;
            while(n>=(d<<(cnt+1))) cnt++;
            ans+=(1L<<cnt);
            n=n-(d<<cnt);
        }
        if(ans>=(1L<<31)&& sign==true){
            return Integer.MAX_VALUE;
        }
        if(ans>=(1L<<31)&& sign==false){
            return Integer.MIN_VALUE;
        }
        if(sign==true){
            return (int)ans;
        }
        return (int) -ans;

     }
public static void main(String[] args) {
    System.out.println(divide(22, 3));
}

}
