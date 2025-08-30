package MergeSort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 5, 6, 3, 60, 1, 3, 12 };
        printArr(a);
        System.out.println(a.length - 1);
        mergeSort(a, 0, a.length - 1);
        printArr(a);
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (right - left) / 2 + left;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }

    }

    public static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] arrLeft = new int[n1];
        int[] arrRight = new int[n2];
        for (int i = 0; i < n1; i++) {
            arrLeft[i] = a[left + i];
        }
        for (int i = 0; i < n2; i++) {
            arrRight[i] = a[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (arrLeft[i] <= arrRight[j]) {
                a[k] = arrLeft[i];
                i++;
            } else {
                a[k] = arrRight[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k++] = arrLeft[i++];
        }
        while (j < n2) {
            a[k++] = arrRight[j++];
        }
    }

    public static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}