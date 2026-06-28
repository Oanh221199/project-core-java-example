package com.company.complexity;

/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(log n).
 *
 * Thuật toán sử dụng Binary Search (tìm kiếm nhị phân)
 * trên một mảng đã được sắp xếp.
 *
 * Mỗi lần lặp, không gian tìm kiếm bị chia đôi,
 * nên số bước giảm theo log2(n).
 *
 * Ví dụ:
 * n = 16  -> tối đa 4 bước
 * n = 1.000 -> ~10 bước
 * n = 1.000.000 -> ~20 bước
 */
public class LogarithmicTime {

    public static int execute(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}