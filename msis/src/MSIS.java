import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MSIS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Result result = maxSumIncreasingSubsequence(arr);

        System.out.println("Maximum Sum: " + result.maxSum);
        System.out.println("Subsequence: " + result.subsequence);
    }

    static class Result {
        int maxSum;
        List<Integer> subsequence;

        Result(int maxSum, List<Integer> subsequence) {
            this.maxSum = maxSum;
            this.subsequence = subsequence;
        }
    }

    public static Result maxSumIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] msis = new int[n];
        int[] previous = new int[n];

        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
            previous[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                    previous[i] = j;
                }
            }
        }

        int maxSum = msis[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (msis[i] > maxSum) {
                maxSum = msis[i];
                maxIndex = i;
            }
        }

        List<Integer> subsequence = new ArrayList<>();
        int currentIndex = maxIndex;
        while (previous[currentIndex] != currentIndex) {
            subsequence.add(arr[currentIndex]);
            currentIndex = previous[currentIndex];
        }
        subsequence.add(arr[currentIndex]);
        Collections.reverse(subsequence);

        return new Result(maxSum, subsequence);
    }
}
