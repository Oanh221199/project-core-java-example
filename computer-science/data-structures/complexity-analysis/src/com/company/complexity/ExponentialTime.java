package com.company.complexity;

/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(2^n) (Exponential Time).
 *
 * Thuật toán sử dụng đệ quy để tính Fibonacci.
 *
 * Với mỗi lần gọi fibonacci(n), nó lại gọi:
 *      fibonacci(n - 1)
 *      fibonacci(n - 2)
 *
 * => Tạo ra cây đệ quy với số lượng lời gọi tăng theo cấp số nhân.
 *
 * Độ phức tạp:
 *      O(2^n)
 *
 * Ví dụ:
 * n = 5  -> 15 calls (xấp xỉ)
 * n = 10 -> 177 calls (xấp xỉ)
 * n = 20 -> rất lớn, tăng cực nhanh
 */
public class ExponentialTime {

    public static long fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}