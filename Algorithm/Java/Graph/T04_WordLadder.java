package Algorithm.Graph;

import java.util.*;

/*
# Question04. Word Ladder(BFS, Queue, level)
    Eng:
    Kor:

    input:
        beginWord = "hit",
        endWord="cog,
        wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
    output: 5
        "hit" -> "hot" -> "dot" -> "dog" -> "cof"
 */
public class T04_WordLadder {

    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","log","cog"};
//		String[] words = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
        T04_WordLadder a = new T04_WordLadder();
        System.out.println(a.ladderLength_neighbor("hit","cog", wordList));
    }

    public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord))
                    return level;
                for (String neighbor : neighbors(str, dict)) { //1 호출시 set으로 호출
                    System.out.println("neighbor "+neighbor);
                    queue.offer(neighbor);
                }
            }
            level++;
        }

        return 0;
    }

    public List<String> neighbors(String s, Set<String> dict) {//2

        List<String> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;// ait~zit
                String word = new String(chars);
                if (dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }

}
