//The approach here is to maintain a column value corresponding to every node so that we know which column each node belongs to.
//We perform level-order traversal and as we traverse, we put all the nodes corresponding to a column number in a hashmap
//Then, we iterate through the hashmap using the column key values and put it in the result
//Time Complexity: O(n) where n is the number of nodes
//Space Complexity: O(n) 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class Solution{
    public List<List<Integer>> verticalOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int max = 0; int min = 0;
        q.add(root);
        colQ.add(0);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int col = colQ.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
                int coll = col-1;
                colQ.add(coll);
                min = Math.min(min, coll);
            }
            if(curr.right != null){
                q.add(curr.right);
                int colr = col+1;
                colQ.add(colr);
                max = Math.max(max, colr);
            }
        }

        for(int i = min; i<=max; i++){
            List<Integer> li = map.get(i);
            result.add(li);
        }
        return result;
    }
}