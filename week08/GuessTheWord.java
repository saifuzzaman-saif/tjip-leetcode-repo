/**
 * TC = O(n); where n is the length of words.
 * MC = O(n)
 * Problem link :  https://leetcode.com/problems/guess-the-word/description/
 */
 
class Solution {

    private Random rand = new Random();

    public void findSecretWord(String[] words, Master master) {
        while (words.length > 1) {
            int idx = rand.nextInt(words.length);
            int score = master.guess(words[idx]);
            words = prune(words, words[idx], score);
        }

        master.guess(words[0]);
    }

    private String[] prune(String[] words, String candidate, int score) {
        List<String> newWords = new ArrayList<>();

        for (String word : words) {
            if (customGuess(word, candidate) == score) {
                newWords.add(word);
            }
        }

        return newWords.toArray(new String[0]);
    }

    private int customGuess(String word1, String word2) {
        int score = 0;

        for (int i = 0; i < word1.length(); i++) {
            score += (word1.charAt(i) == word2.charAt(i)) ? 1 : 0;
        }

        return score;
    }
}
