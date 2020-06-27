import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 Scanner s=new Scanner(System.in);
	 int testcases=s.nextInt();
	 for(int test=0;test<testcases;test++)
	  {
        //code here	
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=s.nextInt();
            Tree t=new Tree();
            Node node=t.arraytobst(arr,0,n-1);
            t.preorder(node);
            System.out.println();
	  }
	 }
}
class Node { 
      
    int data; 
    Node left, right; 
      
    Node(int d) { 
        data = d; 
        left = right = null; 
        } 
}
class Tree
{
     
    Node arraytobst(int[] arr,int start,int end)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        root.left=arraytobst(arr,start,mid-1);
        root.right=arraytobst(arr,mid+1,end);
        return root;
    }
    static void preorder(Node node)
    {
        if (node == null)
            return; 
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
}
