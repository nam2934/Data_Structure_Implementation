import jdk.internal.util.xml.impl.ReaderUTF16;
import sun.security.krb5.internal.crypto.crc32;

class BST{
    public BSTNode root;
    public BSTNode current;
    public BSTNode parent;
    public BST(){
        root.left = null;
        root.right = null;
    }
    public void insert(int key){
        int check_left_right = 0;
        BSTNode new_Node = new BSTNode();
        new_Node.key = key;
        if(root.left == null && root.right == null){
            root.key = key;
            current = root;
        }
        else{
            while(current != null){
                if(current.key > key ){
                    if(current.left != null){
                        current = current.left;
                    }
                    else{
                        check_left_right = 1;
                        break;
                    }
                }

                else if(current.key < key){
                    if(current.right != null){
                        current = current.right;
                    }
                    else{
                        check_left_right = 2;
                        break;
                    }
                }
            }
            if(check_left_right == 1){
                current.left = new_Node;
            }
            if(check_left_right == 2){
                current.right = new_Node;
            }
        }
    }
    public boolean search(int key){
        current = root;
        if(current == null) return false;
        else{
            while(1){
                if(current.key > key){
                    if(current.left == null) return false;
                    else{
                        if(current.left.key == key) return true;
                        else{
                            current = current.left;
                        }
                    }
                }
                if(current.key < key){
                    if(current.right == null) return flase;
                    else{
                        if(current.right.key == key) return false;
                        else{
                            if(current.right.key == key) return true;
                            else{
                                current = current.right;
                            }
                        }
                    }
                }
            }
        }
    }
    public boolean delete(int key){
        
    }
}