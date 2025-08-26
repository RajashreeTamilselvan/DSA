package Sorting;
import java.util.*;
//Question
//Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.
// Example:
// Input:
// 2
// 5
// 5 5 4 6 4
// 5
// 9 9 9 2 5

// Output:
// 4 4 5 5 6
// 9 9 9 2 5  

//  Quick Summary:
// Input Reading – Get test cases, array size, and elements.

// Frequency Counting – Use HashMap to count how often each number appears.

// Custom Sorting – Use Collections.sort() with logic:

// More frequent numbers first.

// If equal frequency, smaller number first.

// Output – Print the sorted list for each test case.

public class RearrangeArray {

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int T = sc.nextInt();

        // Process each test case
        while (T-- > 0) {
            // Read the size of the array
            int N = sc.nextInt();
            int[] arr = new int[N];

            // Read the array elements
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // Step 1: Count the frequency of each element
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Step 2: Copy array elements to a list for custom sorting
            List<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }

            // Step 3: Sort the list with a custom comparator
            // - Sort by descending frequency
            // - If frequency is the same, sort by ascending number
            Collections.sort(list, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    int freqA = freqMap.get(a);
                    int freqB = freqMap.get(b);
                    
                    // If frequencies differ, sort by higher frequency first
                    if (freqA != freqB) {
                        return freqB - freqA;
                    } else {
                        // If frequencies are the same, sort by the smaller number
                        return a - b;
                    }
                }
            });

            // Step 4: Print the sorted elements
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println(); // Move to next line after each test case
        }

        // Close the scanner to avoid memory leaks
        sc.close();
    }
}

}
