# Thuật toán Bubble Sort (Sắp xếp nổi bọt)

## Mô tả thuật toán

Bubble Sort là một thuật toán sắp xếp đơn giản, hoạt động bằng cách lặp lại việc duyệt qua danh sách cần sắp xếp, so sánh từng cặp phần tử liền kề và hoán đổi chúng nếu chúng không đúng thứ tự.

### Nguyên lý hoạt động

Thuật toán được đặt tên "Bubble" (bong bóng) vì các phần tử lớn sẽ "nổi" lên đầu mảng giống như bong bóng khí nổi lên mặt nước. Sau mỗi lượt duyệt, phần tử lớn nhất sẽ được đưa về đúng vị trí cuối cùng.

### Các bước thực hiện

1. **Bước 1**: Duyệt qua mảng từ đầu đến cuối
2. **Bước 2**: So sánh từng cặp phần tử liền kề (a[i] và a[i+1])
3. **Bước 3**: Nếu phần tử trước lớn hơn phần tử sau (với sắp xếp tăng dần), hoán đổi vị trí của chúng
4. **Bước 4**: Sau mỗi lượt duyệt, phần tử lớn nhất sẽ "nổi" về cuối mảng
5. **Bước 5**: Lặp lại quá trình cho đến khi không còn hoán đổi nào xảy ra (mảng đã được sắp xếp)

### Ví dụ minh họa

Sắp xếp mảng `[64, 34, 25, 12, 22, 11, 90]` theo thứ tự tăng dần:

#### Lượt 1:
- `64 > 34` → hoán đổi → `[34, 64, 25, 12, 22, 11, 90]`
- `64 > 25` → hoán đổi → `[34, 25, 64, 12, 22, 11, 90]`
- `64 > 12` → hoán đổi → `[34, 25, 12, 64, 22, 11, 90]`
- `64 > 22` → hoán đổi → `[34, 25, 12, 22, 64, 11, 90]`
- `64 > 11` → hoán đổi → `[34, 25, 12, 22, 11, 64, 90]`
- `64 < 90` → không đổi → `[34, 25, 12, 22, 11, 64, 90]`

**Kết quả sau lượt 1**: `90` đã ở đúng vị trí cuối cùng

#### Lượt 2:
- `34 > 25` → hoán đổi → `[25, 34, 12, 22, 11, 64, 90]`
- `34 > 12` → hoán đổi → `[25, 12, 34, 22, 11, 64, 90]`
- `34 > 22` → hoán đổi → `[25, 12, 22, 34, 11, 64, 90]`
- `34 > 11` → hoán đổi → `[25, 12, 22, 11, 34, 64, 90]`
- `34 < 64` → không đổi → `[25, 12, 22, 11, 34, 64, 90]`

**Kết quả sau lượt 2**: `64` và `90` đã ở đúng vị trí

#### Tiếp tục các lượt:
- Lượt 3: `34` được đưa về vị trí đúng
- Lượt 4: `25` được đưa về vị trí đúng
- Lượt 5: `22` được đưa về vị trí đúng
- Lượt 6: `12` và `11` được sắp xếp

**Kết quả cuối cùng**: `[11, 12, 22, 25, 34, 64, 90]`

## Độ phức tạp

### Thời gian:
- **Trường hợp xấu nhất**: O(n²) - khi mảng được sắp xếp ngược
- **Trường hợp tốt nhất**: O(n) - khi mảng đã được sắp xếp
- **Trường hợp trung bình**: O(n²)

### Không gian:
- **Không gian phụ**: O(1) - chỉ cần thêm vài biến phụ để hoán đổi

## Ưu và nhược điểm

### Ưu điểm:
- ✅ **Đơn giản**: Dễ hiểu và cài đặt
- ✅ **Sắp xếp tại chỗ**: Không cần thêm bộ nhớ phụ
- ✅ **Ổn định**: Không thay đổi thứ tự các phần tử bằng nhau
- ✅ **Phát hiện mảng đã sắp xếp**: Có thể dừng sớm nếu không có hoán đổi

### Nhược điểm:
- ❌ **Hiệu suất kém**: Chậm với dữ liệu lớn do độ phức tạp O(n²)
- ❌ **Không hiệu quả**: Chậm hơn nhiều so với các thuật toán khác như Quick Sort, Merge Sort
- ❌ **Số lần so sánh lớn**: Ngay cả khi mảng đã gần như được sắp xếp

## Ứng dụng

Bubble Sort thường được sử dụng cho:
- **Giáo dục**: Dạy học về thuật toán sắp xếp
- **Dữ liệu nhỏ**: Mảng có ít phần tử (< 50)
- **Mảng gần như đã sắp xếp**: Khi chỉ cần sửa một vài vị trí
- **Hiểu biết cơ bản**: Làm nền tảng để học các thuật toán phức tạp hơn

## Tối ưu hóa

### Phiên bản cải tiến:
1. **Dừng sớm**: Nếu không có hoán đổi nào trong một lượt, mảng đã được sắp xếp
2. **Ghi nhớ vị trí cuối**: Sau mỗi lượt, phần tử cuối đã đúng vị trí nên không cần so sánh nữa
3. **Sắp xếp hai chiều**: Kết hợp sắp xếp từ trái sang phải và từ phải sang trái

## Kết luận

Bubble Sort là một thuật toán sắp xếp cơ bản, dễ hiểu nhưng không hiệu quả cho dữ liệu lớn. Nó phù hợp cho mục đích học tập và hiểu biết về thuật toán sắp xếp, nhưng trong thực tế nên sử dụng các thuật toán hiệu quả hơn như Quick Sort, Merge Sort, hoặc Heap Sort.