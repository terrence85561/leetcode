package com.company.Trie;

public class LC208_Trie {
    private class TrieNode{
        public TrieNode(){
            children = new TrieNode[26];
            is_word = false;
        }
        public TrieNode[] children;
        public boolean is_word;
    }
    /** Initialize your data structure here. */
    private TrieNode root;

    public LC208_Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode cur_node = root;
        char[] wArr = word.toCharArray();
        for(char c : wArr){
            if(cur_node.children[c - 'a'] == null){
                cur_node.children[c - 'a'] = new TrieNode();
            }
            cur_node = cur_node.children[c - 'a'];
        }
        cur_node.is_word = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur_node = root;
        char[] wArr = word.toCharArray();
        for(char c : wArr){
            if(cur_node.children[c - 'a'] == null) return false;
            cur_node = cur_node.children[c - 'a'];
        }
        return cur_node.is_word;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur_node = root;
        char[] pArr = prefix.toCharArray();
        for(char c : pArr){
            if(cur_node.children[c - 'a'] == null) return false;
            cur_node = cur_node.children[c - 'a'];
        }
        return true;

    }
}
