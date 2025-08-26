Selection Sort là thuật toán sắp xếp hoạt động bằng cách liên tục tìm phần tử nhỏ nhất (hoặc lớn nhất) trong phần chưa được sắp xếp của mảng và đưa nó về đúng vị trí.
Nguyên lý hoạt động
Thuật toán chia mảng thành hai phần:

Phần đã sắp xếp: ở đầu mảng (ban đầu rỗng)
Phần chưa sắp xếp: phần còn lại (ban đầu là toàn bộ mảng)

Trong mỗi bước, thuật toán "chọn" (select) phần tử nhỏ nhất từ phần chưa sắp xếp và di chuyển nó vào cuối phần đã sắp xếp.
Các bước thực hiện chi tiết

Bắt đầu từ vị trí đầu tiên (index = 0)
Tìm phần tử nhỏ nhất trong phần chưa sắp xếp (từ vị trí hiện tại đến cuối mảng)
Hoán đổi phần tử nhỏ nhất vừa tìm được với phần tử ở vị trí hiện tại
Chuyển sang vị trí tiếp theo và lặp lại cho đến hết mảng

Ví dụ minh họa
Sắp xếp mảng [64, 25, 12, 22, 11] theo thứ tự tăng dần:
Bước 1: Vị trí 0

Tìm min trong [64, 25, 12, 22, 11] → min = 11 (tại index 4)
Hoán đổi 64 ↔ 11 → [11, 25, 12, 22, 64]
Phần đã sắp xếp: [11]

Bước 2: Vị trí 1

Tìm min trong [25, 12, 22, 64] → min = 12 (tại index 2)
Hoán đổi 25 ↔ 12 → [11, 12, 25, 22, 64]
Phần đã sắp xếp: [11, 12]

Bước 3: Vị trí 2

Tìm min trong [25, 22, 64] → min = 22 (tại index 3)
Hoán đổi 25 ↔ 22 → [11, 12, 22, 25, 64]
Phần đã sắp xếp: [11, 12, 22]

Bước 4: Vị trí 3

Tìm min trong [25, 64] → min = 25 (tại index 3)
Không cần hoán đổi → [11, 12, 22, 25, 64]
Phần đã sắp xếp: [11, 12, 22, 25]

Kết quả: [11, 12, 22, 25, 64]