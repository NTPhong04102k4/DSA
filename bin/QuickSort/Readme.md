# Thuật toán QuickSort trong Java

## Mô tả

QuickSort là một thuật toán sắp xếp hiệu quả dựa trên phương pháp chia để trị. Thuật toán chọn một phần tử gọi là pivot, sau đó phân chia mảng thành hai phần: các phần tử nhỏ hơn pivot nằm bên trái và các phần tử lớn hơn pivot nằm bên phải. Quá trình này được lặp lại đệ quy cho đến khi mảng được sắp xếp hoàn toàn.

## Hướng dẫn

1. **Định nghĩa hàm QuickSort**
    Tạo một phương thức nhận vào mảng, chỉ số bắt đầu và chỉ số kết thúc.

2. **Chọn pivot**
    Chọn một phần tử làm pivot (thường là phần tử cuối cùng của mảng).

3. **Phân vùng mảng**
    Sắp xếp lại các phần tử sao cho các phần tử nhỏ hơn pivot nằm bên trái, lớn hơn nằm bên phải.

4. **Đệ quy sắp xếp các mảng con**
    Áp dụng QuickSort cho các mảng con bên trái và bên phải pivot.

## Ví dụ triển khai

```java
public class QuickSort {
     public static void quickSort(int[] arr, int low, int high) {
          if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
          }
     }

     private static int partition(int[] arr, int low, int high) {
          int pivot = arr[high];
          int i = (low - 1);
          for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                     i++;
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                }
          }
          int temp = arr[i + 1];
          arr[i + 1] = arr[high];
          arr[high] = temp;
          return i + 1;
     }
}
```

## Cách sử dụng

```java
int[] arr = {10, 7, 8, 9, 1, 5};
QuickSort.quickSort(arr, 0, arr.length - 1);
```