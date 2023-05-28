class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    public void addTreeElement(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        first.left = second;
        first.right = third;
        second.left = fourth;
        third.left = fifth;

    }
}