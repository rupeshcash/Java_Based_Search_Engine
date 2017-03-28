


//this class makes a webpage object which contains a linked list of words
public class PageIndex {
	
	MyLinkedList<WordEntry> a = new  MyLinkedList<WordEntry>();
	//String h;
	
	
	
	public boolean contains (WordEntry aa)
	{
		//System.out.println(a.size());
	
		for(int i=0;i<a.size();i++)
		{
			//System.out.println(a.get(i+1));
			if(aa.word.equals (a.get(i+1).word))
			{
			
				return true;
				}
				}
			return false;
	}
	
	
	public WordEntry returnword (WordEntry aa)
	{
	
		
		for(int i=0;i<a.size();i++)
		{
			if(aa.word.equals( a.get(i+1).word))
			{
				return a.get(i+1);
				}
				}
			return null;
	}
	
	
	
	public void addPositionForWord(String str, Position p)
	{
		
		WordEntry w = new WordEntry(str);
		
		if(!contains(w))
		{
			a.addFirst(w);
			w.addPosition(p);
		}
		else
		{
			returnword(w).addPosition(p);
		}
	}
	
	public MyLinkedList<WordEntry> getWordEntries()
	{
		 		 return a;
	}
}
