import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Trie {
    private class TrieStru{
        char var;
        boolean end;
        Queue<TrieStru> next=new LinkedList<>();
        public TrieStru(char var){
            this.var=var;
        }
    }

    TrieStru root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieStru('-');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieStru p=root;
        for(int i=0;i<word.length();i++){
            if (Collections.binarySearch(root.next,word))
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */