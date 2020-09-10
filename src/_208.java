/**
 * 类别：前缀树
 *
 * 要点：注意这里的思路就是将单词中的每一个字母都当成是树里的一层
 * 即是一个26叉树，links表示当前层的下一层节点以及下一层节点与本层的哪个字母链接
 * */
public class _208 {

    class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;
        public TrieNode(){
            links = new TrieNode[R];
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }
        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public boolean isEnd(){
            return isEnd;
        }

        public void setEnd(){
            isEnd = true;
        }
    }
    class Trie {

        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char currentChar = word.charAt(i);
                if(!cur.containsKey(currentChar)){
                    cur.put(currentChar, new TrieNode());
                }
                cur =  cur.get(currentChar);
            }
            cur.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i = 0 ; i < word.length(); i++){
                char currentChar = word.charAt(i);
                if(!cur.containsKey(currentChar))
                    return false;
                cur  = cur.get(currentChar);
            }
            return cur.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0 ; i < prefix.length(); i++){
                char currentChar = prefix.charAt(i);
                if(!cur.containsKey(currentChar))
                    return false;
                cur  = cur.get(currentChar);
            }
            return true;
        }
    }
}
