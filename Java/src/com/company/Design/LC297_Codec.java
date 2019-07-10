package com.company.Design;

import java.util.*;

public class LC297_Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(sb, root);
        return sb.toString();
    }

    private void preOrder(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append("# ");
        }else{
            sb.append(root.val).append(" ");
            preOrder(sb, root.left);
            preOrder(sb, root.right);
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> input = new LinkedList<>(Arrays.asList(data.split(" ")));
        return build_tree(input);

    }

    private TreeNode build_tree(Queue<String> input){
        String val = input.poll();
        if(val.equals("#")) return null;
        else{
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = build_tree(input);
            node.right = build_tree(input);
            return node;
        }
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));