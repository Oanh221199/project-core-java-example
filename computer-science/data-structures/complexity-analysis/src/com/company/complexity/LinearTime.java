/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(n).
 *
 * Thuật toán duyệt toàn bộ mảng một lần để tính tổng
 * tất cả các phần tử.
 *
 * Số phép xử lý tăng tuyến tính theo kích thước mảng.
 *
 * Ví dụ:
 * n = 10      -> 10 phép cộng
 * n = 1.000   -> 1.000 phép cộng
 * n = 1.000.000 -> 1.000.000 phép cộng
 */
package com.company.complexity;
public class LinearTime {

    public static long sum(int[] arr) {

        long sum = 0;

        for (int value : arr) {
            sum += value;
        }

        return sum;
    }
}