import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;

        // Count the occurrences of each character in the word
        while (i < word.length()) {
            if (hm.containsKey(word.charAt(i))) {
                hm.put(word.charAt(i), hm.get(word.charAt(i)) + 1);
            } else {
                hm.put(word.charAt(i), 1);
            }
            i++;
        }

        // Convert the counts to an array
        Integer[] arr = new Integer[hm.size()];
        int j = 0;
        for (int count : hm.values()) {
            arr[j] = count;
            j++;
        }

        // Sort the array in descending order
        Arrays.sort(arr, Collections.reverseOrder());

        int total = 0;
        int k = 1;
        int l = 0;

        // Calculate the total pushes
        while (arr.length - l >= 8) {
            for (int n = l; n < l + 8; n++) {
                total = total + (arr[n] * k);
            }
            k++;
            l = l + 8;
        }

        while (l < arr.length) {
            total = total + (arr[l] * k);
            l = l + 1;
        }

        return total;
    }

   
}
