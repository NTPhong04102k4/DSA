# Insertion Sort

## Giới thiệu
**Insertion Sort** là thuật toán sắp xếp hoạt động tương tự như cách chúng ta sắp xếp bài trên tay:
Lấy từng lá bài và chèn nó vào đúng vị trí trong phần đã được sắp xếp.

---

## Nguyên lý hoạt động
Thuật toán chia mảng thành hai phần:

- **Phần đã sắp xếp**: nằm bên trái (ban đầu chỉ có phần tử đầu tiên).
- **Phần chưa sắp xếp**: nằm bên phải (các phần tử còn lại).

Trong mỗi bước:
1. Lấy phần tử đầu tiên từ phần chưa sắp xếp.
2. So sánh và tìm đúng vị trí trong phần đã sắp xếp.
3. Dịch chuyển các phần tử lớn hơn sang phải.
4. Chèn phần tử vào vị trí chính xác.

---

## Các bước chi tiết
1. Bắt đầu từ phần tử thứ **2** (index = 1), coi phần tử đầu tiên đã được sắp xếp.
2. Lưu giá trị của phần tử hiện tại vào **key**.
3. So sánh ngược với các phần tử trong mảng đã sắp xếp.
4. Dịch chuyển các phần tử lớn hơn `key` sang phải.
5. Chèn `key` vào đúng vị trí.
6. Lặp lại cho đến khi duyệt hết mảng.

---

## Ví dụ minh họa
Sắp xếp mảng **[5, 2, 4, 6, 1, 3]** theo thứ tự tăng dần:

### Trạng thái ban đầu
### Bước 1: i = 1, key = 2
- Phần đã sắp xếp: [5]
- So sánh: 2 < 5 → dịch 5 sang phải
- Chèn 2 vào đầu
- Kết quả: `[2, 5, 4, 6, 1, 3]`

### Bước 2: i = 2, key = 4
- Phần đã sắp xếp: [2, 5]
- So sánh: 4 < 5 → dịch 5 sang phải
- So sánh: 4 > 2 → chèn vào giữa 2 và 5
- Kết quả: `[2, 4, 5, 6, 1, 3]`

### Bước 3: i = 3, key = 6
- Phần đã sắp xếp: [2, 4, 5]
- So sánh: 6 > 5 → không cần dịch chuyển
- Kết quả: `[2, 4, 5, 6, 1, 3]`

### Bước 4: i = 4, key = 1
- Phần đã sắp xếp: [2, 4, 5, 6]
- So sánh: 1 < 6 → dịch 6 sang phải
- So sánh: 1 < 5 → dịch 5 sang phải
- So sánh: 1 < 4 → dịch 4 sang phải
- So sánh: 1 < 2 → dịch 2 sang phải
- Chèn 1 vào đầu
- Kết quả: `[1, 2, 4, 5, 6, 3]`

### Bước 5: i = 5, key = 3
- Phần đã sắp xếp: [1, 2, 4, 5, 6]
- So sánh: 3 < 6 → dịch 6 sang phải
- So sánh: 3 < 5 → dịch 5 sang phải
- So sánh: 3 < 4 → dịch 4 sang phải
- So sánh: 3 > 2 → chèn vào giữa 2 và 4
- Kết quả: `[1, 2, 3, 4, 5, 6]`

---

## Độ phức tạp
- **Thời gian trung bình & xấu nhất**: O(n²)
- **Thời gian tốt nhất**: O(n) (khi mảng đã sắp xếp sẵn)
- **Bộ nhớ phụ**: O(1) (thuật toán tại chỗ - in-place)

---