package com.algorithm.sorts;


/**
  * silenky
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * 归并排序 O(NlogN)  空间 O(N) 稳定
 * 归并排序我们采用递归去实现（也可采用迭代的方式去实现）。分阶段可以理解为就是递归拆分子序列的过程，递归深度为log2n。
 * 治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * 先定义的动感
 */
public class MergeSort {
   public static void main(String[] args) {

      int[] data = {4,6,1,3,1};

      System.out.println("排序之前：\n" + java.util.Arrays.toString(data));

      mergeSort(data);

      System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
   }

   public static void mergeSort(int[] data) {
      // 归并排序
      sort(data, 0, data.length - 1);
   }

   // 将索引从left到right范围的数组元素进行归并排序
   private static void sort(int[] data, int left, int right) {
      if(left < right){

         //找出中间索引
         int center = (left + right)/2;
         sort(data,left,center);
         sort(data,center+1,right);

         //合并
         merge(data,left,center,right);
      }
   }

   // 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
   private static void merge(int[] data, int left, int center, int right) {

      int[] tempArr = new int[data.length];
      int mid = center + 1;
      int third = left;
      int temp = left;

      while (left <= center && mid <= right) {
         if (data[left] - data[mid] <= 0) {
            tempArr[third++] = data[left++];
         } else {
            tempArr[third++] = data[mid++];
         }
      }

      while (mid <= right) {
         tempArr[third++] = data[mid++];
      }

      while (left <= center) {
         tempArr[third++] = data[left++];
      }

      while (temp <= right) {
         data[temp] = tempArr[temp++];
      }
   }
}
