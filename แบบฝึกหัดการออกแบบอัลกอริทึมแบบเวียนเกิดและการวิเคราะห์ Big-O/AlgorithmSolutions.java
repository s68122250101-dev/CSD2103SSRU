import java.util.Arrays;

public class AlgorithmSolutions {

    
    // ข้อ 1: การกลับลำดับสตริง
    
    public static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseRecursive(s.substring(0, s.length() - 1));
    }

    public static String reverseIterative(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    
    // ข้อ 2: การตรวจสอบ Palindrome
    
    public static String cleanString(String s) {
        if (s == null) return "";
        return s.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    public static boolean isPalindromeByReverse(String s) {
        String cleaned = cleanString(s);
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public static boolean isPalindromeRecursive(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static boolean isPalindromeRecursiveWrapper(String s) {
        String cleaned = cleanString(s);
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }

    
    // ข้อ 3: การเปรียบเทียบจำนวนสระและพยัญชนะ
    
    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    private static boolean isConsonant(char ch) {
        return ch >= 'a' && ch <= 'z' && !isVowel(ch);
    }

    public static boolean hasMoreVowelsRecursive(String s) {
        if (s == null) return false;
        return countRecursive(s.toLowerCase(), 0, 0, 0);
    }

    private static boolean countRecursive(String s, int index, int vowels, int consonants) {
        if (index == s.length()) {
            return vowels > consonants;
        }
        char ch = s.charAt(index);
        if (isVowel(ch)) vowels++;
        else if (isConsonant(ch)) consonants++;
        return countRecursive(s, index + 1, vowels, consonants);
    }

    public static boolean hasMoreVowelsIterative(String s) {
        if (s == null) return false;
        String lower = s.toLowerCase();
        int vowels = 0, consonants = 0;
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (isVowel(ch)) vowels++;
            else if (isConsonant(ch)) consonants++;
        }
        return vowels > consonants;
    }

    
    // ข้อ 4: การจัดกลุ่มจำนวนคู่และจำนวนคี่
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void rearrangeRecursive(int[] a, int left, int right) {
        if (left >= right) return;
        if (a[left] % 2 == 0) {
            rearrangeRecursive(a, left + 1, right);
        } else if (a[right] % 2 != 0) {
            rearrangeRecursive(a, left, right - 1);
        } else {
            swap(a, left, right);
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    public static void rearrangeTwoPointer(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] % 2 == 0) left++;
            while (left < right && a[right] % 2 != 0) right--;
            if (left < right) {
                swap(a, left, right);
                left++;
                right--;
            }
        }
    }

    public static int[] rearrangeExtraArray(int[] a) {
        int[] result = new int[a.length];
        int idx = 0;
        for (int num : a) {
            if (num % 2 == 0) result[idx++] = num;
        }
        for (int num : a) {
            if (num % 2 != 0) result[idx++] = num;
        }
        return result;
    }

    
    // ข้อ 5: การแบ่งอาร์เรย์ตามค่า k
    
    public static void partitionRecursive(int[] a, int k, int left, int right) {
        if (left >= right) return;
        if (a[left] <= k) {
            partitionRecursive(a, k, left + 1, right);
        } else if (a[right] > k) {
            partitionRecursive(a, k, left, right - 1);
        } else {
            swap(a, left, right);
            partitionRecursive(a, k, left + 1, right - 1);
        }
    }

    public static void partitionIterative(int[] a, int k) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] <= k) {
                swap(a, i, j);
                i++;
            }
        }
    }

    public static void partitionBySorting(int[] a, int k) {
        Arrays.sort(a);
    }

    
    // ข้อ 6: การค้นหาคู่จำนวนที่มีผลรวมเท่ากับ k
    
    public static boolean findPairBruteForce(int[] a, int k) {
        if (a == null || a.length < 2) return false;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println("Pair found: " + a[i] + " and " + a[j]);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findPairRecursive(int[] a, int k, int left, int right) {
        if (a == null || left >= right) return false;
        int sum = a[left] + a[right];
        if (sum == k) {
            System.out.println("Pair found: " + a[left] + " and " + a[right]);
            return true;
        }
        if (sum < k) return findPairRecursive(a, k, left + 1, right);
        else return findPairRecursive(a, k, left, right - 1);
    }

    public static boolean findPairBinarySearch(int[] a, int k) {
        if (a == null || a.length < 2) return false;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int complement = k - a[i];
            int index = binarySearchHelper(a, i + 1, n - 1, complement);
            if (index != -1) {
                System.out.println("Pair found: " + a[i] + " and " + a[index]);
                return true;
            }
        }
        return false;
    }

    private static int binarySearchHelper(int[] a, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (a[mid] == target) return mid;
        else if (a[mid] < target) return binarySearchHelper(a, mid + 1, high, target);
        else return binarySearchHelper(a, low, mid - 1);
    }
}