/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(n²).
 *
 * Thuật toán sử dụng 2 vòng lặp lồng nhau để duyệt qua tất cả
 * các cặp phần tử trong mảng.
 *
 * Với mỗi phần tử i, duyệt toàn bộ mảng với j.
 * Do đó tổng số lần lặp là:
 *
 *      n × n = n²
 *
 * Ví dụ:
 * n = 10     -> 100 lần lặp
 * n = 1.000  -> 1.000.000 lần lặp
 */
package com.company.complexity;

public class QuadraticTime {

    public static long countPairs(int[] arr) {

        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                count++;
            }
        }

        return count;
    }
}