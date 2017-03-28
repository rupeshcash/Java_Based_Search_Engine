

import java.util.*;

//hashtable implementaion for the page index

public class MyHashTable {
	
	
	private PageIndex[]  we ;
	private int size;
	
	
	public MyHashTable(int size)
	{
		this.size= size;
		we =new PageIndex[size];
		for (int i = 0; i < size; i++)
		      we[i] = new PageIndex(); 
	
	}
	
	
	
	
	
	
	private int getHashIndex(String s)
	{
		int h=0;
		for (int i=0; i<s.length( ); i++) 
		{ h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of the running sum
		h += (int) s.charAt(i); // add in next character
		}
		//System.out.println(h);
		if( h<0)
		return (-h)%this.size;
		else
			return h%this.size;
	}
	
	
	
	public void addPositionsForWord(WordEntry t)
	{
		int hash = getHashIndex(t.word);
		if(this.contain(t))
			{
			
			
			we[hash].returnword(t).addPositions(t.pos);
			
			}
		else
			{  
			 we[hash].a.addFirst(t);
			
			}
		
	
	}
	
	
	
	public boolean contain(WordEntry t)
	{
		
		//System.out.println(t.word);
		int hash = getHashIndex(t.word);
		
		//System.out.println(hash);
		if (we[hash].a.size()!=0 ) 
		{
	
			
			
			if(we[hash].contains(t))
			{
			
			return true;
			}
			
			else return false;
			}
		else
		return	false;
	}
	
	public WordEntry ret(WordEntry t)
	{
		int hash = getHashIndex(t.word);
		
		return  we[hash].returnword(t);
		
		
	}
	
	
	
	
	
	
}
