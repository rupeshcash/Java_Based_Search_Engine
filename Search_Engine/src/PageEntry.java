

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class PageEntry {
	String name;
	PageIndex pi=new PageIndex();
	BufferedReader br = null;
	private int i=0;
	//MyLinkedList<String> sr =new MyLinkedList<String>();
	boolean rec = true;
	
	public PageEntry(String pageName)
	{
		this.name= pageName;
		try {
			
			String aw=null;
			br = new BufferedReader(new FileReader(pageName));
			//int uu=0;
			while ((aw = br.readLine()) != null) {
				aw=aw.toLowerCase();
				aw=aw.trim();
				aw=aw.replace('"', ' ');
				String ra[]=aw.split("[,-<>=:().,;'?#!\\s]+");	
				
				//System.out.println(aw );
				
				for(int u = 0 ;u<ra.length;u++)
				{
					if( ra[u].equals("a") || ra[u].equals("an")  || ra[u].equals("the") || ra[u].equals("they") || ra[u].equals("these") || ra[u].equals("this") || ra[u].equals("for") || ra[u].equals("is") || ra[u].equals("are") || ra[u].equals("was") || ra[u].equals("of") || ra[u].equals("of") || ra[u].equals("or") || ra[u].equals("and") || ra[u].equals("does") || ra[u].equals("will") || ra[u].equals("whose"))
					{
						i=i+1;
					}
					else
						{
						
						if(ra[u].equals("structures") || ra[u].equals("applications") || ra[u].equals("stacks"))
						{
						
									ra[u] = ra[u].substring(0, ra[u].length()-1);
							
						}
						
					
						{		
							i=i+1;
							//System.out.println(i);
							WordEntry we =new WordEntry (ra[u]);
							Position x = new Position(this ,i);
							
							if(pi.contains(we))
							{
							
								//System.out.println(ra[u] + " ");
									
							pi.returnword(we).addPosition(x);
							//pi.returnword(we).avl.insert(x);
							
							}
							else
							{
								
								pi.a.addFirst(we);
								//pi.returnword(we).avl.insert(x);
								pi.returnword(we).addPosition(x);
								
								
							}
							
					
			}
				
						
						
						}
					}
		}
			
			
} 
		
		
		
		catch (IOException e) {
			this.rec=false;
			//System.out.println(pageName+ "       -file not found");
		} 
		
		
		
		finally {
			try {
				if (br != null)br.close();
				
			} catch (IOException ex) {
				//System.out.println("file not found");
				ex.printStackTrace();
			}}
		
		
	}
	
	
	PageIndex getPageIndex()
	{
		return pi;
	}
	
	
	float getRelevanceOfPage(String str[], boolean doTheseWordsRepresentAPhrase)
	{
		
		
		float relev=0;
		if(doTheseWordsRepresentAPhrase == false)
		{
				
			
			WordEntry d[]= new WordEntry[str.length];
			
			for(int i=0;i<str.length;i++)
			{
				
				 d[i]=new WordEntry(str[i]);
				 float rel=0;
				
			if(this.pi.contains(d[i]))
			{
				
				
			for(int x =1;x<=this.pi.returnword(d[i]).pos.size();x++)
				{
				
				float e = this.pi.returnword(d[i]).pos.get(x).getWordindex();
				
				rel = rel+(1/(e*e));
				}
		relev= relev +rel;	
			
		}}
			return relev;
			}
		
		else
		{
			
				WordEntry d[]= new WordEntry[str.length];
				for(int y=0;y<str.length;y++)
				{
					d[y]=new WordEntry(str[y]);
				}
				
				float rel=0;
					
					for(int u=0;u<str.length-1;u++)
					{	
					this.pi.returnword(d[u]).avl.inorder();
					
						for(int m = 1; m<= this.pi.returnword(d[u]).avl.xc.size;m++)
					{
							//System.out.println( this.pi.returnword(d[u]).avl.xc.returnnode(m) + "    "+ this.pi.returnword(d[u+1]).avl.search(this.pi.returnword(d[u]).avl.xc.returnnode(m)+1)+"  " + this.pi.returnword(d[u]).word +"   " + this.name);
							int ug = this.pi.returnword(d[u]).avl.xc.returnnode(m)+1;
					
						if(this.pi.returnword(d[u+1]).avl.search(ug))
						{
							
							float r = this.pi.returnword(d[u]).avl.xc.returnnode(m);
							rel= rel+ (1/(r*r));
							break;
						}
					
						}
						
				
				}
				
					
					
					
					
				/*for(int x =0;x<this.pi.returnword(d[0]).pos.size();x++)
					{
					
					
					float e = this.pi.returnword(d[0]).pos.get(x).getWordindex();
					
					rel = rel+1/(e*e);
					}*/
			relev= relev +rel;	
				
				}
				return relev;
				
		
	
		}
	
	
	
	boolean isPhrase(String str[])
	{
		WordEntry d[] = new WordEntry[str.length];
		for(int y=0;y<str.length;y++)
		{
			d[y]=new WordEntry(str[y]);
			
			if (! this.pi.contains(d[y]))
			{
				return false;
			}	
		}
		
	
	
		
		
					for(int u=0;u<str.length-1;u++)
						{	
						///System.out.println(this.pi.returnword(d[u]).avl.xc.size);
						this.pi.returnword(d[u]).avl.inorder();
						//System.out.println(this.pi.returnword(d[u]).avl.xc.size);
						//System.out.println(" mm");
						
							for(int m = 1; m<= this.pi.returnword(d[u]).avl.xc.size;m++)
						{
								//System.out.println( this.pi.returnword(d[u]).avl.xc.returnnode(m) + "    "+ this.pi.returnword(d[u+1]).avl.search(this.pi.returnword(d[u]).avl.xc.returnnode(m)+1)+"  " + this.pi.returnword(d[u]).word +"   " + this.name);
								int ug = this.pi.returnword(d[u]).avl.xc.returnnode(m)+1;
						
							if(this.pi.returnword(d[u+1]).avl.search(ug))
							{
								
								return true;
								
							}
						
							}
							
					
					}
					return false;
					
					//System.out.println(" mm");
					//	return true;
				
		
		
	}
	boolean isand(String str[])
	{
		for(int i=0;i<str.length;i++)
		{
			WordEntry oi = new WordEntry(str[i]);
			if(!this.pi.contains(oi))
			{
				return false;
			}
		}
		return true;
	}


	
	
	
}


