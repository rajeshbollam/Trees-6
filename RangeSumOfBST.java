//The approach here is to use DFS to traverse to each node and check if it lies within the given range and then add it to the sum and return it
//Time Complexity: O(n)
//Space Complexity: O(h) 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        helper(root, low, high);
        return sum;
    }

    private void helper(TreeNode root, int low, int high){
        //base
        if(root == null) return;
        //logic
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        if(root.val >= low){
            helper(root.left, low, high);
        }
        if(root.val <=high){
            helper(root.right, low, high);
        }   
    }
}
