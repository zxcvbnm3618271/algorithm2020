package org.lanqiao.algo.elementary._08_dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class 打家劫舍 {
//    记录选中该节点时的最大值
    Map<TreeNode,Integer> f=new HashMap<>();
//    记录不选择该节点时的最大值
    Map<TreeNode,Integer> g=new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }
    public void dfs(TreeNode node){
        if (node==null)
            return;
        dfs(node.left);
        dfs(node.right);
//        记录若选中该节点时的最大和
        f.put(node,node.val+g.getOrDefault(node.left,0)+g.getOrDefault(node.right,0));
//        记录若不选中该节点时的最大和
        g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0))+Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
    }
}
