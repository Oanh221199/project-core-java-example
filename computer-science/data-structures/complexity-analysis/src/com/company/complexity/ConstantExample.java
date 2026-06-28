package com.company.complexity;
/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(1) (Constant Time).
 *
 * Thuật toán chỉ truy cập trực tiếp một phần tử trong mảng,
 * không phụ thuộc vào kích thước của mảng.
 *
 * Dù mảng có 10 phần tử hay 10 triệu phần tử,
 * thời gian thực thi vẫn không thay đổi.
 *
 * Ví dụ:
 * arr = [5, 10, 15, ...]
 * luôn trả về arr[0]
 */
public class ConstantExample {

    public static int getElement(int[] arr) {

        return arr[0];
    }

}
