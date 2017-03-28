
import java.util.*;

//Simple linked list implementation
public class MyLinkedList<x> {
	
	private static class node<x>{
		private x data;
		private node <x> next;
		
		public node(x data,node next)
		{
			this.data = data;
			this.next = next;
		}
		
		
	}
	private node head;
	private int size =0;
	
	
	public x get(int i){
		node<x> temp;
		temp=head;
		for(int j=1;j<i && temp.next!=null;j++ )
		{
			temp=temp.next;
			//System.out.println(temp.next);
		}
		return temp.data;
	}
		
	public int size()
	{
		return size;
	}
	
	
	//adds in front of the list
	public void addFirst(x item)
	   {
	      head = new node<x>(item, head);
	      size++;
	   }
	
	
	//adds item to the last of list
	
	//inserts a node at last
	public void addLast(x item)
	{
	   if( head == null)
	      addFirst(item);
	   else
	   {
	      node<x> tmp = head;
	      while(tmp.next != null) tmp = tmp.next;
	      tmp.next = new node<x>(item, null);
	      size++;
	   }
	  
	}
	
	//tells if the list is empty or not
		public boolean IsEmpty()
		{
			return head==null;
		}
		
		
	
	
	//tells if the linklist contains a object of type x
		
	public boolean contains(x xn)
		   {
			node tmp = this.head;
		      while(tmp.next!=null)
		         {if(tmp.data.equals(xn)) return true;
		      		tmp = tmp.next;
		      		//System.out.println(tmp.data);
		         }
		      return false;
		   }
	
	
	

	
		
	}
	
	
	
	
	
	
	

