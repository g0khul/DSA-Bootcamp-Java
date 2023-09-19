// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
package Tree;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    public static TreeNode createTree(int[] arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createTree(arr, start, mid - 1);
        node.right = createTree(arr, mid + 1, end);

        return node;
    }   

    public static void main(String[] args) {
        // int[] arr = {0,1,2,3,4,5};
        // TreeNode tree = sortedArrayToBST(arr);
        // tree.prettyDisplay(tree);
    }
}
