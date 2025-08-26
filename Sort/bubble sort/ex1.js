"use strict";
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.swap = swap;
var a = 5;
var b = 1;
function swap(a, b) {
    var valSmallest = a;
    var valGreater = b;
    if (valSmallest > valGreater) {
        return {
            valGreater: valGreater,
            valSmallest: valSmallest,
        };
    }
    return {
        valSmallest: valSmallest,
        valGreater: valGreater,
    };
}
var res = swap(a, b);
console.log(res);
function bubbleSort(arr) {
    var _a;
    for (var i = 0; i < arr.length; i++) {
        for (var j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                _a = [arr[j + 1], arr[j]], arr[j] = _a[0], arr[j + 1] = _a[1];
            }
        }
    }
    return arr;
}
// Tạo mảng 50 phần tử ngẫu nhiên
function generateRandomArray(size, min, max) {
    if (min === void 0) { min = 1; }
    if (max === void 0) { max = 100; }
    var arr = [];
    for (var i = 0; i < size; i++) {
        arr.push(Math.floor(Math.random() * (max - min + 1)) + min);
    }
    return arr;
}
// Test bubble sort với mảng 50 phần tử
console.log("\n=== TEST BUBBLE SORT ===");
var testArray = generateRandomArray(50);
console.log("Mảng ban đầu:", testArray);
var startTime = performance.now();
var sortedArray = bubbleSort(__spreadArray([], testArray, true)); // Copy mảng để không thay đổi mảng gốc
var endTime = performance.now();
console.log("Mảng sau khi sắp xếp:", sortedArray);
console.log("Th\u1EDDi gian s\u1EAFp x\u1EBFp: ".concat((endTime - startTime).toFixed(4), "ms"));
// Kiểm tra kết quả có đúng không
var isCorrectlySorted = sortedArray.every(function (val, index) {
    if (index === 0)
        return true;
    return val >= sortedArray[index - 1];
});
console.log("✅ Kết quả sắp xếp:", isCorrectlySorted ? "ĐÚNG" : "SAI");
// Hiển thị một số thống kê
console.log("\n\uD83D\uDCCA Th\u1ED1ng k\u00EA:");
console.log("- S\u1ED1 ph\u1EA7n t\u1EED: ".concat(sortedArray.length));
console.log("- Gi\u00E1 tr\u1ECB nh\u1ECF nh\u1EA5t: ".concat(sortedArray[0]));
console.log("- Gi\u00E1 tr\u1ECB l\u1EDBn nh\u1EA5t: ".concat(sortedArray[sortedArray.length - 1]));
console.log("- Gi\u00E1 tr\u1ECB trung b\u00ECnh: ".concat((sortedArray.reduce(function (sum, val) { return sum + val; }, 0) / sortedArray.length).toFixed(2)));
