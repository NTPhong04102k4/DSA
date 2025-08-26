package SelectionSort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 11, 22, 11, 90 };

        System.out.println("Array before sorting:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Array after sorting:");
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        if (n == 0 || arr == null) {
            System.out.println("Arr must to have element");
            return;
        }
        for (int i = 0; i < n; i++) {
            int indexMin = i;
            for (int idx = i; idx < n; idx++) {
                if (arr[indexMin] > arr[idx]) {
                    indexMin = idx;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
