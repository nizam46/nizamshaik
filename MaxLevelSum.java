import java.util.*;

public class MaxLevelSum {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter comma-separated values (use 'null' for missing nodes):");
        String[] parts = sc.nextLine().split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = parts[0].equals("null") ? null : new TreeNode(Integer.parseInt(parts[0].trim()));
        if (root != null) q.add(root);
        
        for (int i = 1; !q.isEmpty() && i < parts.length; ) {
            TreeNode node = q.poll();
            String leftVal = parts[i++].trim();
            if (!leftVal.equals("null") && !leftVal.isEmpty()) {
                node.left = new TreeNode(Integer.parseInt(leftVal));
                q.add(node.left);
            }
            if (i < parts.length) {
                String rightVal = parts[i++].trim();
                if (!rightVal.equals("null") && !rightVal.isEmpty()) {
                    node.right = new TreeNode(Integer.parseInt(rightVal));
                    q.add(node.right);
                }
            }
        }

        int maxLevel = 0, curLevel = 0;
        long maxSum = Long.MIN_VALUE;
        q.clear();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            curLevel++;
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = curLevel;
            }
        }
        System.out.println("Smallest level with maximum sum: " + maxLevel);
    }
}