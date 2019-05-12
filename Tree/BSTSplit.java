class BSTSplit{
    public BST bstSmaller, bstGreater;
    public BSTNode store_small_tree, store_large_tree;
    public BSTSplit(){
        bstSmaller = null;
        bstGreater = null;
    }
    public void append_small_tree(BSTNode node){
        if(store_small_tree == null) bstSmaller.root = node;
        else store_small_tree.right = node;
    }
    public void append_large_tree(BSTNode node){
        if(store_large_tree == null) bstGreater.root = node;
        else store_large_tree.left = node;
    }

    public void split(BST bstIn, int val){
        bstSmaller = new BST();
        bstGreater = new BST();
        BSTNode new_node;

        store_small_tree = null;
        store_large_tree = null;

        new_node = bstIn.root;
        while(new_node != null){
            if(new_node.key < val){
                append_small_tree(new_node);
                store_small_tree = new_node;
                new_node = new_node.right;
            }
            else if(new_node.key > val){
                append_large_tree(new_node);
                store_large_tree = new_node;
                new_node = new_node.left;
            }
            else{
                append_small_tree(new_node.left);
                append_large_tree(new_node.right);

                return;
            }
        }
        append_small_tree(null);
        append_large_tree(null);
    }
}