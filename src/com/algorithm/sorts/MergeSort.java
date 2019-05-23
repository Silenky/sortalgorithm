package com.algorithm.sorts;


/**
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * �鲢���� O(NlogN)  �ռ� O(N) �ȶ�
 * �鲢�������ǲ��õݹ�ȥʵ�֣�Ҳ�ɲ��õ����ķ�ʽȥʵ�֣����ֽ׶ο������Ϊ���ǵݹ��������еĹ��̣��ݹ����Ϊlog2n��
 * ��(conquer)�Ľ׶��򽫷ֵĽ׶εõ��ĸ���"�޲�"��һ�𣬼��ֶ���֮)��
 */
public class MergeSort {
   public static void main(String[] args) {

      int[] data = {4,6,1,3,1};

      System.out.println("����֮ǰ��\n" + java.util.Arrays.toString(data));

      mergeSort(data);

      System.out.println("����֮��\n" + java.util.Arrays.toString(data));
   }

   public static void mergeSort(int[] data) {
      // �鲢����
      sort(data, 0, data.length - 1);
   }

   // ��������left��right��Χ������Ԫ�ؽ��й鲢����
   private static void sort(int[] data, int left, int right) {
      if(left < right){

         //�ҳ��м�����
         int center = (left + right)/2;
         sort(data,left,center);
         sort(data,center+1,right);

         //�ϲ�
         merge(data,left,center,right);
      }
   }

   // ������������й鲢���鲢ǰ���������Ѿ����򣬹鲢����Ȼ����
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
