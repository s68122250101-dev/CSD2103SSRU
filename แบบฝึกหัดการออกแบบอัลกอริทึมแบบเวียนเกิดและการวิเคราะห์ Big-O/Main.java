import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: String Reversal ===");
        String str1 = "pots&pans";
        System.out.println("Recursive: " + AlgorithmSolutions.reverseRecursive(str1));
        System.out.println("Iterative: " + AlgorithmSolutions.reverseIterative(str1));

        System.out.println("\n=== Problem 2: Palindrome Check ===");
        String str2 = "A man, a plan, a canal: Panama";
        System.out.println("By Reverse: " + AlgorithmSolutions.isPalindromeByReverse(str2));
        System.out.println("Recursive: " + AlgorithmSolutions.isPalindromeRecursiveWrapper(str2));

        System.out.println("\n=== Problem 3: Vowels vs Consonants ===");
        String str3 = "education";
        System.out.println("Recursive: " + AlgorithmSolutions.hasMoreVowelsRecursive(str3));
        System.out.println("Iterative: " + AlgorithmSolutions.hasMoreVowelsIterative(str3));

        System.out.println("\n=== Problem 4: Even-Odd Rearrange ===");
        int[] arr4 = {7, 2, 9, 4, 1, 6, 3, 8};
        int[] arr4_copy = arr4.clone();
        AlgorithmSolutions.rearrangeTwoPointer(arr4_copy);
        System.out.println("Two-Pointer: " + Arrays.toString(arr4_copy));
        System.out.println("Extra Array: " + Arrays.toString(AlgorithmSolutions.rearrangeExtraArray(arr4)));

        System.out.println("\n=== Problem 5: Array Partition by k ===");
        int[] arr5 = {12, 4, 7, 15, 3, 10, 8};
        int k5 = 8;
        AlgorithmSolutions.partitionIterative(arr5, k5);
        System.out.println("Partitioned: " + Arrays.toString(arr5));

        System.out.println("\n=== Problem 6: Two Sum Target ===");
        int[] arr6 = {2, 4, 7, 11, 15, 20};
        int k6 = 18;
        AlgorithmSolutions.findPairRecursive(arr6, k6, 0, arr6.length - 1);
    }
}