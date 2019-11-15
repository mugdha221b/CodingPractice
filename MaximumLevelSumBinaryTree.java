/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,Integer> levelMapping = new HashMap<TreeNode,Integer>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    HashMap<Integer,Integer> sums = new HashMap<Integer,Integer>();
    
    
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        
        bfs(root);
        
        int maxSum = Integer.MIN_VALUE;
        int levelValue = -1;
        for (Map.Entry<Integer,Integer> entry : sums.entrySet()) 
        {
            if(maxSum < entry.getValue())
            {
                maxSum = entry.getValue();
                levelValue = entry.getKey();
            }
        }
        return levelValue;
        
    }
    
    public void bfs(TreeNode root)
    {
        levelMapping.put(root,1);
        // sums.put(1,root.val);
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            
            //Pop the currentNode
            TreeNode curr = queue.poll();
            // System.out.println(curr.val);
            //Get the level of this node
            int currLevel = levelMapping.get(curr);
            
            //Add the val of this node to the sum of that level
            if(sums.containsKey(currLevel))
                sums.put(currLevel, sums.get(currLevel)+curr.val);
            else
                sums.put(currLevel, curr.val);
            
            //Get all the children nodes
            //Add these nodes to the queue
            if(curr.left != null)
               { queue.add(curr.left);
                levelMapping.put(curr.left, currLevel+1);}
            if(curr.right!=null)
            {
                queue.add(curr.right);
            
                levelMapping.put(curr.right, currLevel+1);
            
            }
            
        }
            
        
    }
}