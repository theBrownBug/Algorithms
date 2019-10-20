package Questions;

public class ArrayToBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Doubt - why nums.length - 1 is wrong ?
     *
     *
     * */
    public static TreeNode sortedArrayToBST(int[] nums){
        return createTree(nums , 0 , nums.length ) ;
    }

    public static TreeNode createTree(int[] array , int left , int right){
        if(left < right){
            int middle = (left + right)/2 ;
            TreeNode node = new TreeNode(array[middle]) ;
            node.left  = createTree(array, left , middle ) ;
            node.right = createTree(array ,middle +1 , right) ;
            return node ;
        }
        return null ;
    }

    public static void main(String args[]){
        int[] array = {-10 , -3 , 0 , 5, 9 } ;
        TreeNode node = ArrayToBST.sortedArrayToBST(array)  ;
        System.out.println(node.right.val);
    }
}
