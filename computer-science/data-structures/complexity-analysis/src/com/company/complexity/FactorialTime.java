package com.company.complexity;

/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(n!).
 * Thuật toán sinh ra tất cả các hoán vị của một mảng có n phần tử.
 * Tổng số hoán vị là:
 *
 *      n! = n × (n - 1) × (n - 2) × ... × 2 × 1
 *
 * Do phải duyệt qua toàn bộ các hoán vị nên thời gian thực thi
 * tăng theo cấp số giai thừa và rất nhanh khi n tăng.
 *
 * Ví dụ:
 * n = 3  -> 6 hoán vị
 * n = 5  -> 120 hoán vị
 * n = 10 -> 3.628.800 hoán vị
 */
public class FactorialTime {

    public static void execute(int[] arr) {
        permute(arr, 0);
    }

    private static void permute(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}