import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each lowercase letter 'a'-'z' to its row index (0, 1, or 2)
        int[] rows = {
            1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 
            2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2
        };

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = rows[lower.charAt(0) - 'a'];
            boolean isValid = true;

            for (int i = 1; i < lower.length(); i++) {
                if (rows[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}