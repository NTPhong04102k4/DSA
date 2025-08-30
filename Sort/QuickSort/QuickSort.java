package QuickSort;

public class QuickSort {
    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivotIdx = pagination(a, left, right);
            quickSort(a, left, pivotIdx - 1);
            quickSort(a, pivotIdx + 1, right);
        }
    }

    public static int pagination(int[] a, int left, int right) {
        int pivot = a[right];
        int idxOfPivot = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] <= pivot) {
                idxOfPivot++;
                int temp = a[idxOfPivot];
                a[idxOfPivot] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[idxOfPivot + 1];
        a[idxOfPivot + 1] = a[right];
        a[right] = temp;
        return idxOfPivot + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 50, 5, 9, 1, 7, 12 };
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}