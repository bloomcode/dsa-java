import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Chapter 17: Tries for prefix search.
 * Each node marks the end of a word with a boolean field, which in Java is clearer than a sentinel child.
 */
public class Ch17Tries {

    // ==== EX 17.1 | Trie node and insertion | Core
    // PROMPT: Create `static class TrieNode` with a `LinkedHashMap<Character, TrieNode> children` and a `boolean end`, and `static class Trie` with a `root`. Write `void insert(String word)` that walks or creates one child per character, then marks the last node as the end of a word.
    // EXAMPLE: insert "cat", "cab" -> root has one child `'c'`, whose `'a'` child has children `'t'` and `'b'`
    // BIGO: O(K) for a K-character word, regardless of how many words are stored.
    // NOTE: The `boolean end` flag marks where a word ends. `LinkedHashMap` keeps children in insertion order so results are predictable.
    static class TrieNode {
        final Map<Character, TrieNode> children = new LinkedHashMap<>();
        boolean end;
        int popularity;
    }

    static class Trie {
        final TrieNode root = new TrieNode();

        void insert(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.2 | Search a prefix | Core | class=Trie
        // PROMPT: Add `TrieNode search(String prefix)` returning the node where the prefix ends, or `null` if it is not in the trie.
        // EXAMPLE: After "cat" -> `search("ca")` is a node; `search("co")` is `null`
        // BIGO: O(K).
        TrieNode search(String prefix) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.3 | Is it a whole word? | Core | class=Trie
        // PROMPT: Add `boolean containsWord(String word)`: the prefix must exist and its node must be marked as an end.
        // EXAMPLE: After "cat" -> `containsWord("cat")` is `true`, `containsWord("ca")` is `false`
        // BIGO: O(K).
        boolean containsWord(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.4 | Collect every word | Core | class=Trie
        // PROMPT: Add `List<String> collectAllWords(TrieNode node)` that recursively gathers every word below `node`, building each word in a `StringBuilder` that you append to and trim back.
        // EXAMPLE: After "cat", "cab", "dog" -> `collectAllWords(root)` is `[cat, cab, dog]`
        // BIGO: O(M) nodes beneath the starting node (plus the length of the words copied out).
        List<String> collectAllWords(TrieNode node) {
            throw new UnsupportedOperationException();
        }

        private void collect(TrieNode node, StringBuilder word, List<String> words) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.5 | Autocomplete | Core | class=Trie
        // PROMPT: Add `List<String> autocomplete(String prefix)`: search to the prefix's node, collect the words below it and prepend the prefix.
        // EXAMPLE: Words "cat", "catnip", "cab", "dog" -> `autocomplete("cat")` -> `[cat, catnip]`
        // BIGO: O(K + M): reach the prefix, then visit only the matching subtree.
        List<String> autocomplete(String prefix) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.6 | Print every key | Practice | class=Trie
        // PROMPT: Add `List<Character> allKeys()` returning every character stored in the trie, depth first.
        // EXAMPLE: After "can", "cat" -> `[c, a, n, t]`
        // BIGO: O(M) nodes.
        List<Character> allKeys() {
            throw new UnsupportedOperationException();
        }

        private void keys(TrieNode node, List<Character> keys) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.7 | Autocorrect | Practice | class=Trie
        // PROMPT: Add `String autocorrect(String word)`: return the word if it exists; otherwise follow the longest prefix that does exist and return the first word that completes it.
        // EXAMPLE: Words "cat", "catnap", "catnip" -> `autocorrect("catnar")` -> `"catnap"`; `autocorrect("cat")` -> `"cat"`
        // BIGO: O(K + M).
        String autocorrect(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 17.9 | Delete a word | Stretch | class=Trie
        // PROMPT: Add `boolean delete(String word)` that clears the end flag and prunes nodes that no longer lead to any word. Return `true` if the word was present.
        // EXAMPLE: Words "cat", "catnip" -> delete "catnip" -> "cat" still found, the n-i-p nodes are gone
        // BIGO: O(K).
        boolean delete(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 17.8 | Tries with values: ranked autocomplete | Practice
    // PROMPT: Build `static class RankedTrie extends Trie` whose `insert(String word, int popularity)` stores the popularity on the end node. Add `List<String> autocomplete(String prefix, int limit)` returning the most popular completions first.
    // EXAMPLE: (catnip, 9), (cat, 5), (catalog, 7) -> `autocomplete("cat", 2)` -> `[catnip, catalog]`
    // BIGO: O(K + M + R log R) to collect and sort R matches.
    static class RankedTrie extends Trie {
        void insert(String word, int popularity) {
            throw new UnsupportedOperationException();
        }

        List<String> autocomplete(String prefix, int limit) {
            throw new UnsupportedOperationException();
        }

        private void rank(TrieNode node, StringBuilder word, List<Map.Entry<String, Integer>> out) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END
}
