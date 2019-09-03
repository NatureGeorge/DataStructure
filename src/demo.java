/**
 * @Date:   2019-09-03T12:15:07+08:00
 * @Email:  1730416009@stu.suda.edu.cn
 * @Filename: demo.java
 * @Last modified time: 2019-09-03T12:20:17+08:00
 */
public static void Bubble_sort(int[] a, int n) {
  int temp, flag = 1;
  for (int i = 1; i < n&&flag; i++){
    flag = 0;
    for (int j = 0; j< n-i; j++){
      if (a[j]>a[j+1]){
        flag = 1;
        temp=a[j];
        a[j]=a[j+1];
        a[j+1]=temp;
      }
    }
  }
}
