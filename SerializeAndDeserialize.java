//The approach here is to use level order traversal to perform serialize and use similar approach for deserialize as well
//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("#");
            }
            sb.append(" ");
            
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(" ");
        if(strArr.length == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        if(strArr[i].equals("#")) return null;
        int rootVal = Integer.parseInt(strArr[i]);
        i++;
        TreeNode root = new TreeNode(rootVal);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            //make the left baby
            if(!strArr[i].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);
            }
            i++;
            if(!strArr[i].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
