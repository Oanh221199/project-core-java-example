package com.company.complexity;

/**
 * Mô phỏng thuật toán có độ phức tạp thời gian O(n log n).
 *
 * Thuật toán sử dụng Merge Sort để sắp xếp mảng.
 * Merge Sort chia mảng thành hai nửa, sau đó sắp xếp
 * từng nửa và trộn (merge) chúng lại.
 *
 * Độ phức tạp:
 * - Chia mảng: log n mức.
 * - Mỗi mức xử lý toàn bộ n phần tử.
 *
 * => Tổng thời gian: O(n log n).
 */
public class LinearithmicTime {

    public static void execute(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}