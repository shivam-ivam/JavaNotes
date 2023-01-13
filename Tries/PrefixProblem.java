package Tries;
// prefix problem : find shortest unique prefix for every word in a given list.assume no word is prefix of another.

public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfNode = false;
        int count;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.count = 0;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.count++;
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfNode = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            System.out.println("count: " + curr.children[idx].count);
            if (curr.children[idx] != null) {
                curr = curr.children[idx];
            } else {
                return false;
            }
        }
        return true;
    }

    // prefix problem
    public static String prefix(String word) {
        String pre = "";
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];
            pre += word.charAt(i);
            if (curr.count <= 1) {
                break;
            }
        }
        return pre;
    }

    // unique substring

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    ////// longest word with all prefixes
    public static boolean isValid(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';
            curr = curr.children[idx];
            if (curr == null) {
                return false;
            }
            if (!curr.endOfNode) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // String words[] = {"zebra", "dog", "duck", "dove"};
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }
        // for (int i = 0; i < words.length; i++) {
        // System.out.println(prefix(words[i]));
        // }

        // unique substring
        // String str = "ababa";
        // for (int i = 0; i < str.length(); i++) {
        // String suffix = str.substring(i);
        // insert(suffix);
        // }
        // System.out.println(countNodes(root));

        // longest word with all prefixes
        String arr[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        String word = "";
        for (int i = 0; i < arr.length; i++) {
            if (isValid(arr[i])) {
                if (word.length() < arr[i].length()) {
                    word = arr[i];
                } else if (word.length() == arr[i].length()) {
                    if (word.compareToIgnoreCase(arr[i]) > 0) {
                        word = arr[i];
                    }
                }
            }
        }
        System.out.println(word);

    }
}
