package com.company.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC589_preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> buffer = new Stack<>();
        Node cur = root;
        buffer.push(cur);
        while(!buffer.isEmpty()){
            cur = buffer.pop();
            res.add(cur.val);
            for(int i = cur.children.size()-1; i >= 0; i--){
                buffer.push(cur.children.get(i));
            }
        }
        return res;
    }
}
