package InsertSort;

public class InsertSort {

    public static void main(String[] args) {
        int[] a = { 10, 50, 20, 5, 5, 1, 0 };
        System.out.println("arr before sorting:::");
        printArray(a);
        InsertSorfMethod(a);
        System.out.println("arr after sorting:::");
        printArray(a);
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void InsertSorfMethod(int[] a) {
        for (int idx = 1; idx < a.length; idx++) {
            int key = a[idx];

            // Dịch chuyển các phần tử lớn hơn key sang phải
            for (int i = idx - 1; i >= 0 && a[i] > key; i--) {
                a[i + 1] = a[i];
                a[i] = key; // Đặt key vào vị trí hiện tại
            }
        }
    }
}
