package MergeSort;

public class MergeSort {
    private static int depth = 0; // Để theo dõi độ sâu đệ quy

    // Method to sort an array using merge sort
    public void sort(int[] array) {
        // KIỂM TRA ĐIỀU KIỆN BIÊN
        if (array == null || array.length < 2) {
            return;
        }

        System.out.println("=== BẮT ĐẦU MERGE SORT ===");
        System.out.print("Mảng ban đầu: ");
        printArray(array);
        System.out.println();

        // Reset depth counter
        depth = 0;

        // Gọi hàm đệ quy với toàn bộ mảng
        mergeSort(array, 0, array.length - 1);

        System.out.println("\n=== KẾT THÚC MERGE SORT ===");
        System.out.print("Mảng cuối cùng: ");
        printArray(array);
    }

    // HÀM ĐỆ QUY CHÍNH - Thực hiện chia mảng
    private void mergeSort(int[] array, int left, int right) {
        // Tăng độ sâu khi vào hàm đệ quy
        depth++;

        // In thông tin chia mảng
        printIndent();
        System.out.println("📂 CHIA: Xử lý đoạn [" + left + ".." + right + "] - ");
        printIndent();
        System.out.print("   Nội dung: ");
        printSubArray(array, left, right);

        // ĐIỀU KIỆN DỪNG ĐỆ QUY
        if (left < right) {
            // TÍNH ĐIỂM GIỮA
            int mid = left + (right - left) / 2;

            printIndent();
            System.out.println("   ➤ Điểm giữa: " + mid);

            // BƯỚC CHIA - Divide
            printIndent();
            System.out.println("   🔀 Chia thành 2 nửa:");
            printIndent();
            System.out.println("      ← Nửa trái [" + left + ".." + mid + "]");
            printIndent();
            System.out.println("      → Nửa phải [" + (mid + 1) + ".." + right + "]");
            System.out.println();

            mergeSort(array, left, mid); // Sắp xếp nửa trái
            mergeSort(array, mid + 1, right); // Sắp xếp nửa phải

            // BƯỚC TRỘN - Conquer
            printIndent();
            System.out.println("🔄 TRỘN: Kết hợp [" + left + ".." + mid + "] và [" + (mid + 1) + ".." + right + "]");
            merge(array, left, mid, right);
        } else {
            // Trường hợp base case (1 phần tử)
            printIndent();
            System.out.println("   ✓ Base case: Chỉ 1 phần tử, đã sắp xếp");
        }

        // Giảm độ sâu khi thoát khỏi hàm đệ quy
        depth--;
    }

    // HÀM TRỘN - Core của thuật toán Merge Sort
    private void merge(int[] array, int left, int mid, int right) {
        // TÍNH KÍCH THƯỚC CÁC MẢNG CON
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // TẠO MẢNG TẠM
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // SAO CHÉP DỮ LIỆU VÀO MẢNG TẠM
        for (int i = 0; i < n1; i++)
            leftArr[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = array[mid + 1 + j];

        printIndent();
        System.out.print("   📋 Mảng trái: ");
        printArray(leftArr);
        printIndent();
        System.out.print("   📋 Mảng phải: ");
        printArray(rightArr);

        // QUÁ TRÌNH TRỘN CHÍNH
        int i = 0, j = 0, k = left;

        printIndent();
        System.out.println("   🔄 Bắt đầu trộn:");

        // TRỘN KHI CẢ 2 MẢNG CHƯA HẾT
        while (i < n1 && j < n2) {
            printIndent();
            System.out.print("      So sánh: " + leftArr[i] + " vs " + rightArr[j]);

            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                System.out.println(" → Chọn " + leftArr[i] + " (từ trái)");
                i++;
            } else {
                array[k] = rightArr[j];
                System.out.println(" → Chọn " + rightArr[j] + " (từ phải)");
                j++;
            }
            k++;
        }

        // XỬ LÝ PHẦN TỬ CÒN LẠI
        while (i < n1) {
            printIndent();
            System.out.println("      Thêm phần tử còn lại từ trái: " + leftArr[i]);
            array[k++] = leftArr[i++];
        }

        while (j < n2) {
            printIndent();
            System.out.println("      Thêm phần tử còn lại từ phải: " + rightArr[j]);
            array[k++] = rightArr[j++];
        }

        // Hiển thị kết quả sau khi trộn
        printIndent();
        System.out.print("   ✅ Kết quả trộn [" + left + ".." + right + "]: ");
        printSubArray(array, left, right);
        System.out.println();
    }

    // Helper method để in thụt lề theo độ sâu đệ quy
    private void printIndent() {
        for (int i = 0; i < depth - 1; i++) {
            System.out.print("    ");
        }
    }

    // Helper method để in mảng
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Helper method để in một đoạn của mảng
    private void printSubArray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // DEMO VỚI TRACE CHI TIẾT
    public static void main(String[] args) {

        // Test với mảng lớn hơn
        int[] arr2 = { 10, 50, 5, 5, 8, 11, 1 };
        System.out.println("🧪 TEST 2: Mảng lớn hơn");
        MergeSort ms2 = new MergeSort();
        ms2.sort(arr2);
    }
}

/*
 * 📚 PHÂN TÍCH TRACE:
 *
 * 1. MỖI LẦN CHIA:
 * - Hiển thị đoạn đang xử lý [left..right]
 * - Tính điểm giữa (mid)
 * - Chia thành 2 nửa
 *
 * 2. MỖI LẦN TRỘN:
 * - Hiển thị 2 mảng con đã sắp xếp
 * - Theo dõi từng bước so sánh
 * - Hiển thị lựa chọn phần tử
 * - Kết quả sau khi trộn
 *
 * 3. CẤU TRÚC CÂY ĐỆ QUY:
 * - Sử dụng thụt lề để thể hiện độ sâu
 * - Dễ dàng theo dõi quá trình chia và trộn
 *
 * 📊 ĐỘ PHỨC TẠP:
 * - Thời gian: O(n log n) - ổn định
 * - Không gian: O(n) - do mảng tạm
 * - Stable: Giữ nguyên thứ tự các phần tử bằng nhau
 */