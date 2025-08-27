package BubbleSort;

public class Ex1 {

  public static void main(String[] args) {
    int[] arr = { 64, 34, 25, 12,100, 11, 90 };

    System.out.println("Array before sorting:");
    printArray(arr);

    bubbleSort(arr);

    System.out.println("Array after sorting:");
      printArray(arr);
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length ; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length-1 ; i++) {
      boolean swapped=false;
      System.out.println("Pass "+(i+1)+":");
      for(int j=0;j<arr.length-1;j++){
        System.out.println("compare "+arr[j]+" and "+arr[j+1]);
        if(arr[j]>arr[j+1]){
        //   // giá trị tạm thời bằng giá trị arr[j+1]
        //   int temp=arr[j+1];
        // // gán giá trị a[j] = temp thì a[j] = a[j+1]
        //   arr[j]=temp;
        //   // vì hiện tại a[j]=a[j+1] nên nếu gán như dưới thì tức là gán a[j+1] lại bằng chính a[j+1] đã gán cho a[j]
        //   arr[j+1]=arr[j];

        // gán như vậy thì giá trị tạm thời là giá trị arr[j+1]
        int temp=arr[j+1];
        // gán giá trị tại vị trí j+1 thành giá trị tại vị trí j 
        arr[j+1]=arr[j];
        // vì a[j+1] đang có giá trị a[j] tức là giá trị lớn hơn , nên cần gán a[j] cho temp , nếu lại gán a[j+1] thì tức là gán a[j] bằng chính giá trị trước đó
        arr[j]=temp;
        swapped=true;
        }
      }
      printArray(arr);
      if(!swapped){
        break;
      }
    }
  
  }

}
