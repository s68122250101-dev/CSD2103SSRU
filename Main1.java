import java.util.Arrays;
import java.util.LinkedList;

public class Main1 {

    public static void main(String[] args) {
        
        System.out.println("ข้อ 1: ค้นหา Index ของ 0 ด้วย Binary Search");
        
        testQuestion1();

        
        System.out.println("ข้อ 2: การ Merge Array 2 ตัวที่เรียงลำดับแล้ว");
        
        testQuestion2();

        
        System.out.println("ข้อ 3.1: Insertion Sort (แสดงทุกขั้นตอน)");
        
        testQuestion3_1();

        
        System.out.println("ข้อ 3.2: Quick Sort (Pivot = ตัวสุดท้าย)");
        
        testQuestion3_2();

        
        System.out.println("ข้อ 4: Hash Table แบบ Chaining (h(k) = k mod 9)");
        
        testQuestion4();
    }

    
    // ข้อ 1
    
    public static int findZeroIndex(int[] a1, int[] a2) {
        int left = 0;
        int right = a2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a2[mid] == 0) {
                return mid; // เจอ 0
            }

            // ถ้า mid เกินขอบเขต a1 หรือค่าไม่ตรงกัน แสดงว่า 0 อยู่ฝั่งซ้าย (รวม mid)
            if (mid >= a1.length || a1[mid] != a2[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void testQuestion1() {
        int[] a1 = {1, 3, 4, 6, 7, 8, 9, 20};
        int[] a2 = {1, 3, 0, 4, 6, 7, 8, 9, 20};

        int index = findZeroIndex(a1, a2);
        System.out.println("a1: " + Arrays.toString(a1));
        System.out.println("a2: " + Arrays.toString(a2));
        System.out.println("Index ของ 0 คือ: " + index + " (ตำแหน่งที่ " + (index + 1) + ")");
    }

    
    // ข้อ 2
    
    public static void merge(int[] values, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k++] = left[i++];
            } else {
                values[k++] = right[j++];
            }
        }

        while (i < left.length) {
            values[k++] = left[i++];
        }

        while (j < right.length) {
            values[k++] = right[j++];
        }
    }

    public static void testQuestion2() {
        int[] left = {1, 3, 6, 8};
        int[] right = {0, 4, 7, 9, 20};
        int[] values = new int[left.length + right.length];

        System.out.println("Left:  " + Arrays.toString(left));
        System.out.println("Right: " + Arrays.toString(right));

        merge(values, left, right);

        System.out.println("Merged Values: " + Arrays.toString(values));
    }

    
    // ข้อ 3.1 (Insertion Sort)
    
    public static void testQuestion3_1() {
        int[] A = {15, 3, 9, 31, 11, 17, 7, 23};
        System.out.println("เริ่มต้น: " + Arrays.toString(A));

        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
            System.out.println("ขั้นตอนที่ " + i + ": " + Arrays.toString(A));
        }
    }

    
    // ข้อ 3.2 (Quick Sort)
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("หลัง Partition (Pivot = " + arr[pi] + "): " + Arrays.toString(arr));

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot คือตัวสุดท้าย
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void testQuestion3_2() {
        int[] A = {15, 3, 9, 31, 11, 17, 7, 23};
        System.out.println("เริ่มต้น: " + Arrays.toString(A));
        quickSort(A, 0, A.length - 1);
    }

    
    // ข้อ 4 (Hash Table Chaining)
    
    public static void testQuestion4() {
        int tableSize = 9;
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] hashTable = new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }

        int[] data = {5, 28, 19, 15, 20, 33, 12, 17, 10};

        for (int key : data) {
            int hashIndex = key % tableSize; // h(k) = k mod 9
            hashTable[hashIndex].add(key);
        }

        for (int i = 0; i < tableSize; i++) {
            System.out.print("Index " + i + " -> ");
            for (int val : hashTable[i]) {
                System.out.print("[" + val + "] -> ");
            }
            System.out.println("null");
        }
    }
}