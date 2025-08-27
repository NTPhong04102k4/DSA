Merge Sort là một thuật toán sắp xếp hiệu quả dựa trên chiến lược "chia để trị" (divide and conquer). Đây là một trong những thuật toán sắp xếp ổn định và có độ phức tạp thời gian O(n log n) trong mọi trường hợp.
Nguyên lý hoạt động
Merge Sort hoạt động theo 3 bước chính:

Chia (Divide): Chia mảng thành hai nửa bằng nhau
Trị (Conquer): Đệ quy sắp xếp từng nửa
Kết hợp (Combine): Trộn hai nửa đã sắp xếp thành một mảng hoàn chỉnh

Thuật toán chi tiết
MERGE-SORT(A, p, r)
1. if p < r
2.    q = ⌊(p + r)/2⌋
3.    MERGE-SORT(A, p, q)
4.    MERGE-SORT(A, q + 1, r)
5.    MERGE(A, p, q, r)
Hàm MERGE dùng để trộn hai mảng con đã sắp xếp:
MERGE(A, p, q, r)
1. Tạo hai mảng tạm L và R
2. Sao chép dữ liệu vào L và R
3. Trộn L và R trở lại vào A[p..r]
Ví dụ minh họa
Sắp xếp mảng [38, 27, 43, 3, 9, 82, 10]:
[38, 27, 43, 3, 9, 82, 10]
       /              \
[38, 27, 43, 3]    [9, 82, 10]
    /      \         /      \
[38, 27] [43, 3]  [9, 82]  [10]
  /   \    /  \    /   \      |
[38] [27] [43] [3] [9] [82]  [10]

Sau đó trộn ngược lại:
[27, 38] [3, 43]  [9, 82]  [10]
    \      /         \      /
[3, 27, 38, 43]   [9, 10, 82]
        \              /
    [3, 9, 10, 27, 38, 43, 82]
Đặc điểm
Ưu điểm:

Độ phức tạp thời gian ổn định O(n log n)
Thuật toán ổn định (stable sort)
Hiệu quả với dữ liệu lớn
Dễ song song hóa

Nhược điểm:

Cần thêm không gian lưu trữ O(n)
Không sắp xếp tại chỗ (not in-place)
Có thể chậm hơn Quick Sort trong thực tế với dữ liệu nhỏ

Độ phức tạp

Thời gian: O(n log n) trong mọi trường hợp
Không gian: O(n) cho mảng tạm

Merge Sort là lựa chọn tốt khi cần một thuật toán sắp xếp ổn định với hiệu suất đảm bảo, đặc biệt hữu ích trong các hệ thống cần độ tin cậy cao.