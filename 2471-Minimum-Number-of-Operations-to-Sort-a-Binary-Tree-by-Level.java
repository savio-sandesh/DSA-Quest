/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int countMinSwapsToSort(List<Integer> vec) {
        int swaps = 0;
        List<Integer> sortedVec = new ArrayList<>(vec);
        Collections.sort(sortedVec);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < vec.size(); i++) {
            indexMap.put(vec.get(i), i);
        }

        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).equals(sortedVec.get(i))) {
                continue; // No swap required
            }

            int currIdx = indexMap.get(sortedVec.get(i));
            indexMap.put(vec.get(i), currIdx);
            indexMap.put(vec.get(currIdx), i);
            Collections.swap(vec, currIdx, i);
            swaps++;
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;

        while (!queue.isEmpty()) {
            int n = queue.size(); // Total nodes in the current level
            List<Integer> vec = new ArrayList<>();

            for (int i = 0; n > i; i++) {
                TreeNode temp = queue.poll();
                vec.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            result += countMinSwapsToSort(vec);
        }

        return result;
    }
}
