package org.lanqiao.algo.elementary._02searchAndSort;

public class 旋转数组的最小值_带重复 {
	public static int minArray(int[] numbers) {
        int begin=0;
        int end=numbers.length -1;
        if(numbers[begin]<numbers[end])
        return numbers[begin];
        while(begin+1<end){
            int mid=begin+((end-begin)>>1);
           if(numbers[mid]==numbers[end]){
               while(numbers[begin]==numbers[mid]&&begin<mid){
                   begin++;
               }
               if(begin!=mid){
                end=mid;
               }
               mid=begin+((end-begin)>>1);
               continue;
           }
            if(numbers[mid]>=numbers[begin]){
                begin=mid;
            }else{
                end=mid;
            }
        }
return Math.min(numbers[begin], numbers[end]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] num= {10,10,10,10,10,1,10,10,10};
System.out.println(minArray(num));
	}

}
