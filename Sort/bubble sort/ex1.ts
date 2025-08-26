const a = 5;
const b = 1;

function bubbleSort(arr: number[]): number[] {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
      }
    }
  }
  return arr;
}

// Tạo mảng 50 phần tử ngẫu nhiên
function generateRandomArray(
  size: number,
  min: number = 1,
  max: number = 100
): number[] {
  const arr: number[] = [];
  for (let i = 0; i < size; i++) {
    arr.push(Math.floor(Math.random() * (max - min + 1)) + min);
  }
  return arr;
}

// Test bubble sort với mảng 50 phần tử
console.log("\n=== TEST BUBBLE SORT ===");

const testArray = generateRandomArray(50);
console.log("Mảng ban đầu:", testArray);

const startTime = performance.now();
const sortedArray = bubbleSort([...testArray]); // Copy mảng để không thay đổi mảng gốc
const endTime = performance.now();

console.log("Mảng sau khi sắp xếp:", sortedArray);
console.log(`Thời gian sắp xếp: ${(endTime - startTime).toFixed(4)}ms`);

// Kiểm tra kết quả có đúng không
const isCorrectlySorted = sortedArray.every((val, index) => {
  if (index === 0) return true;
  return val >= sortedArray[index - 1];
});

console.log("✅ Kết quả sắp xếp:", isCorrectlySorted ? "ĐÚNG" : "SAI");

// Hiển thị một số thống kê
console.log(`\n📊 Thống kê:`);
console.log(`- Số phần tử: ${sortedArray.length}`);
console.log(`- Giá trị nhỏ nhất: ${sortedArray[0]}`);
console.log(`- Giá trị lớn nhất: ${sortedArray[sortedArray.length - 1]}`);
console.log(
  `- Giá trị trung bình: ${(
    sortedArray.reduce((sum, val) => sum + val, 0) / sortedArray.length
  ).toFixed(2)}`
);
