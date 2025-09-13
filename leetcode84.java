// Author: Garima Yadav
// Date:13 sep 2025
// Description:  Largest Rectangle in Histogram
// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram

import java.util.Stack;

public class leetcode84 {
    public static  int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] right=new int[n];
        int[] left=new int[n];
        int ans=0;
        // right nearest
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            right[i]=n;
            while(st.size()>0&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty())
            right[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
              left[i]=-1;
            while(st.size()>0&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty())
            left[i]=st.peek();
            st.push(i);
        }

        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            int currht=heights[i]*width;
            ans=Math.max(currht,ans);
        }
         return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
