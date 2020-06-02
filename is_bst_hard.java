import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
          // Implement correct algorithm here
          if(nodes==0)
            return true;
          if(nodes==1)
            return true;
          if(isBST(tree,0,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return true;
        return false;
        }
        boolean isBST(Node[] tree, int root, int min, int max)  
        {  
            // Base condition  
            if (root==-1)  
                return true;  
        
            /* false if this node violates the min/max constraints */
            if (tree[root].key < min || tree[root].key >= max) 
                return false; 
    
            /* otherwise check the subtrees recursively 
            tightening the min/max constraints */
            // Allow only distinct values 
            return (isBST(tree,tree[root].left, min, tree[root].key) && isBST(tree,tree[root].right, tree[root].key, max));
        }  
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
