# Java Projects

Dự án này chứa các bài tập và thuật toán Java được tổ chức theo chủ đề.

## Cấu trúc dự án

- `Java Core/` - Các bài tập Java cơ bản
- `Java OOP/` - Lập trình hướng đối tượng
- `Sort/` - Các thuật toán sắp xếp
- `String/` - Xử lý chuỗi
- `Graph/` - Thuật toán đồ thị
- `Search/` - Thuật toán tìm kiếm

## Cài đặt và chạy với VSCode

### 1. Cài đặt Extension
Cài đặt **Extension Pack for Java** trong VSCode:
- Mở VSCode
- Nhấn `Ctrl+Shift+X`
- Tìm "Extension Pack for Java"
- Cài đặt extension của Microsoft

### 2. Cài đặt Java Development Kit (JDK)
- Tải và cài đặt JDK 8 trở lên
- Đảm bảo biến môi trường `JAVA_HOME` được cấu hình

### 3. Cách chạy file Java

#### Cách 1: Sử dụng F5
1. Mở file Java (ví dụ: `Sort/bubble sort/ex1.java`)
2. Nhấn `F5` để chạy file hiện tại

#### Cách 2: Sử dụng Command Palette
1. Nhấn `Ctrl+Shift+P`
2. Gõ "Java: Run" và chọn

#### Cách 3: Sử dụng Tasks
1. Nhấn `Ctrl+Shift+P`
2. Gõ "Tasks: Run Task"
3. Chọn task phù hợp:
   - "Run Current Java File" - Chạy file hiện tại
   - "Run Ex1" - Chạy file ex1.java

#### Cách 4: Click chuột phải
1. Click chuột phải vào file Java
2. Chọn "Run Java"

### 4. Debug
- Nhấn `F5` để debug
- Đặt breakpoint bằng cách click vào lề trái của dòng code

## Ví dụ chạy Bubble Sort

File `Sort/bubble sort/ex1.java` chứa thuật toán bubble sort:

```java
public class Ex1 {
  public static void main(String[] args) {
    int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
    
    System.out.println("Mảng ban đầu:");
    printArray(arr);
    
    bubbleSort(arr);
    
    System.out.println("Mảng sau khi sắp xếp:");
    printArray(arr);
  }
  // ... rest of the code
}
```

Kết quả chạy:
```
Mảng ban đầu:
64 34 25 12 22 11 90 
Mảng sau khi sắp xếp:
11 12 22 25 34 64 90 
```

## Lưu ý

- Đảm bảo Java đã được cài đặt và cấu hình đúng
- Extension Pack for Java sẽ tự động tạo file `.class` khi compile
- Có thể sử dụng `Ctrl+Shift+P` và gõ "Java: Clean Workspace" để xóa các file `.class` 