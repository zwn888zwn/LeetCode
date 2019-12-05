
public class Trie {
    private class TrieStru{
        private boolean isEnd;
        private TrieStru[] content=new TrieStru[26];

        public void setEnd(){
            this.isEnd=true;
        }
        public boolean getEnd(){
            return isEnd;
        }
        public TrieStru getTrie(char c){
            return content[c-'a'];
        }
        public TrieStru setTrie(char c){
            return content[c-'a']=new TrieStru();
        }

    }

    TrieStru root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieStru();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieStru p=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(p.getTrie(word.charAt(i))==null){
                p=p.setTrie(c);
            }else
                p=p.getTrie(c);
            if (i==word.length()-1){
                p.setEnd();
            }

        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieStru p=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            p=p.getTrie(c);
            if (p==null)
                return false;
        }
        if (p.getEnd())
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieStru p=root;
        for (int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            p=p.getTrie(c);
            if (p==null)
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */