



public class InvertedPageIndex {
	
	MyHashTable mh = new MyHashTable(1000);
	MyLinkedList<String> pp = new MyLinkedList<String>();
	int nopage=0;
	
	
	public void addPage(PageEntry p)
	{
		nopage++;
	
		for(int u= 1 ; u <=p.pi.a.size(); u++)
		{
		
			mh.addPositionsForWord(p.pi.a.get(u));
			
		}
		pp.addFirst(p.name);
	}
	
	
	
	Myset<PageEntry> getPagesWhichContainWord(String str)
	{
		Myset<PageEntry> pe = new Myset<PageEntry>();
		
		WordEntry wr = new WordEntry(str);
		
		
		
		if(mh.contain(wr))
		{
		
		
		for(int i=1; i<= mh.ret(wr).pos.size();i++)
		{
			if(pe.size==0)
			pe.addElement(mh.ret(wr).pos.get(i).getPageEntry());
			else
			{
				int yy=0;
				for(int u =1;u<=pe.size;u++)
				{
					if(mh.ret(wr).pos.get(i).getPageEntry().name ==pe.returnnode(u).name)
					{
						yy++;
						break;
					}
				}
			if(yy==0)
			{
				pe.addElement(mh.ret(wr).pos.get(i).getPageEntry());
			}
			}
		}
		
	}
		
		
		return pe;
		
		
	}
	
	//Find Positions Of Word In APage
	void thefun( WordEntry ui ,String names)
	{
		
		if(mh.contain(ui))
		{
		
			MyLinkedList<Position> p =mh.ret(ui).getAllPositionsForThisWord();
			if(pp.contains(names))
			{for(int o=0;o<p.size();o++)
			{
			
				if(p.get(p.size()-o).getPageEntry().name.equals(names))
			{
					
				System.out.print(p.get(p.size()-o).getWordindex() + "    ");
			}
			}
			System.out.println();
			System.out.println(" ");
			System.out.println(" ");
			}
		
			else
				System.out.println("no such page present");
		
		}
		
		else
			System.out.println("not such word is present in such a given page");
	}
	

	MyLinkedList<PageEntry>getPagesWhichContainPhrase(String str[])
	{
		WordEntry d[] = new WordEntry[str.length];
		d[0]=new WordEntry(str[0]);
		MyLinkedList<PageEntry> dd = new MyLinkedList<PageEntry>();
		if(this.mh.contain(d[0]))
		{
			//System.out.println(" b");
			for(int i=0;i<this.mh.ret(d[0]).pos.size();i++)
			{
			
				
				if(this.mh.ret(d[0]).pos.get(i).getPageEntry().isPhrase(str) )
				{
					
					int X=0;
					if(dd.size()!=0)
					for(int y= 1;y<=dd.size();y++)
					{	
						if( dd.get(y).name.equals(this.mh.ret(d[0]).pos.get(i).getPageEntry().name))
						{
							
							X=X+1;
						   break;
						}
						
					
				}
					if(X==0)
					{
						
						dd.addFirst(this.mh.ret(d[0]).pos.get(i).getPageEntry());
						
					}
					
				
				}
			}
			
		
		}
		return dd;
	}
	
	
	
	
}
