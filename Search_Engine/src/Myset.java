

public class Myset<a> {
	
	private node<a> head = null;
	private node<a> tail = null;
	int size=0;
	
	private class node<a>
	{
		a c;
		node<a> next;
		public node(a x,node mm)
		{
			this.c = x;
			this.next=mm;
		}
	}
	
	
	public void Insert(a g)
	{
		this.head = new node<>(g,head);
		size++;
	}
	
	public void addElement(a x)
	{
		if(head==null)
		{
			Insert(x);
		}
		else
		{
			node<a> temp = head;
			while(temp.next!=null)
			{	temp=temp.next;}
			temp.next = new node<a>(x,null);
			size++;
		}
	}
	public a returnnode(int i)
	{
		node<a> temp=head;
		for(int h =1 ;h<i;h++)
		{
			temp = temp.next;
		}
		return temp.c;
	}
	
	
	
	
	//union: retrun type is a set 
	public Myset<a> union(Myset<a> b){
		node<a> temp3=b.head;
		if(this.head==null){
		while(temp3!=null)
		{
			this.addElement(temp3.c);
			temp3=temp3.next;
			//System.out.println("fgfgf");
		}
		}
		else{
		node<a> temp1=this.head;
		node<a> temp2=b.head;
		while(temp2!=null)
		{
			int x=0;
			while(temp1!=null){
				if(temp2.c==temp1.c)
					x++;
				temp1=temp1.next;
			}
			temp1=this.head;
			if(x==0){
				this.addElement(temp2.c);
			}
			temp2=temp2.next;
		}
		}
		return this;
	}




	public Myset<a> intersection(Myset<a> b)
	{
		Myset<a> c=new Myset<>();
		node<a> temp3=b.head;
		while(temp3!=null)
		{
			c.Insert(temp3.c);
			temp3=temp3.next;
		}
		node<a> temp1=c.head;
		node<a> temp2=this.head;
		while(temp2!=null)
		{
			while(temp1!=null){
				if(temp2.c==temp1.c)
				c.Insert(temp2.c);
				temp2=temp2.next;
			}
			temp1=temp1.next;
		}
		return c;
	}
}	
	

