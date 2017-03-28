
import java.util.Collections;
import java.util.ArrayList;


//This java file basically answers the Queries by calling other classes.
public class SearchEngine {
	InvertedPageIndex ipi ;
	
	public SearchEngine()
	{
		ipi  = new InvertedPageIndex();
	}
	
	void performAction(String actionMessage)
	{
		
		String te[]=actionMessage.split(" ");
		//System.out.println(te[0]);
	
		if(te[0].equals ("addPage"))
		{
			//System.out.println(actionMessage);
			try
			{
				PageEntry pp = new PageEntry(te[1]);
				ipi.addPage(pp);
				System.out.println(" ");
				if(pp.rec==false)
					System.out.println("      - file not found ");
				
							}
			catch(Exception e){}
			
			
		}
		
		
		
		if(te[0].equals("queryFindPagesWhichContainWord"))
		{
			
			 ArrayList<SearchResult> v = new ArrayList<SearchResult>();

			 
			  MySort m= new MySort();
			  String a[]=new String[te.length-1];
			  WordEntry ds[]= new WordEntry[a.length];
			  for(int i=1;i<te.length;i++)
				 {
					
					 a[i-1]=te[i];
					 a[i-1]=a[i-1].toLowerCase();
					 ds[i-1]= new WordEntry(a[i-1]);
				 }
			  
			  
			
				  
				//System.out.println(this.ipi.pagee.get(u).name);
				 int us=0;
				 PageEntry mm=null ;
				for(int yu=1;yu<=ipi.nopage;yu++)
				{
					PageEntry tt= new PageEntry(this.ipi.pp.get(yu));
				
					for(int ui=0;ui<a.length;ui++)
				
				{
					
					
					if(tt.pi.contains(ds[ui]))
						{
						us++;
						mm = new PageEntry(tt.name);
						break;
						}
				}
				if(us!=0)
				{
					
					SearchResult se= new SearchResult(mm, mm.getRelevanceOfPage(a,false));
					
						if(v!=null)
						{	int uu=0;
							for(int i=0;i<v.size();i++)
							if(v.get(i).p.name.equals(se.p.name))
						{
								uu++;
						 break;
						}
							if(uu==0)
								v.add(se);
						}
						else
							v.add(se);
				
					}
				}
				
			 
			 m.sortThisList(v);
			 if(m.ss.size()==0)
				 System.out.println("not found");
			 
			for(int i=0;i<m.ss.size();i++)
			{
				
				System.out.print(  m.ss.get(i).p.name + "  , ");
			}
			System.out.println(" ");
			System.out.println(" ");
			
			
			  
			
			
		/*	Myset<PageEntry> rr ; 
					rr = ipi.getPagesWhichContainWord(te[1].toLowerCase());
					
				//	System.out.println(actionMessage);
			if(rr.size!=0)
			{
					{for(int i=1 ;i <=rr.size ;i++)
							
						 System.out.print(rr.returnnode(i).name + ",       ");
		}
					System.out.println(" ");
					System.out.println(" ");}
			else
					{
						System.out.println("not found");
					}
				
		*/	
		}
		
		
		
		
		  if(te[0].equals ("queryFindPositionsOfWordInAPage"))
		{
			  //System.out.println(actionMessage);
			  
			  //if(te.charAt[te.length-1]=='s')
			  
			  WordEntry g= new WordEntry(te[1].toLowerCase());
			  
			  
			  
			  ipi.thefun(g, te[2]);
			
			  
			 
			
			}
		  
		  if(te[0].equals ("queryFindPagesWhichContainAllWords"))
		  {
			  ArrayList<SearchResult> v = new ArrayList<SearchResult>();
			  MySort m= new MySort();
			  String a[]=new String[te.length-1];
			 
			  WordEntry ds[]= new WordEntry[a.length];
			  for(int i=1;i<te.length;i++)
				 {
					
					 a[i-1]=te[i];
					 a[i-1]=a[i-1].toLowerCase();
					 ds[i-1]= new WordEntry(a[i-1]);
				 }
			for(int u = 1 ; u <=this.ipi.nopage; u++)
			 {
				PageEntry tt = new PageEntry(this.ipi.pp.get(u));
				
				for(int uw = 1 ; uw <=this.ipi.nopage; uw++)
				 {
					if(tt.name.equals("stack_cprogramming"))
					 {
						WordEntry tr= new WordEntry("stack");
						//System.out.println(tt.pi.returnword(tr).pos.size());
					 }
				 }
				
				 int us=0;
				for(int ui=0;ui<a.length;ui++)
				{
					
					if(!tt.pi.contains(ds[ui]))
						{
						us++;
						break;
						}
				}
				if(us==0)
				{
					//System.out.println(this.ipi.pagee.get(u).name);
				
					SearchResult se= new SearchResult(tt,tt.getRelevanceOfPage(a,false));
					v.add(se);
				
					
				}
				
				
				
				
			 }
				m.sortThisList(v);
				
				if(m.ss.size()==0)
					System.out.println("!Not found");
				for(int i=0;i<m.ss.size();i++)
			{
					System.out.print(m.ss.get(i).p.name +"   , ");
					
				
			}
				System.out.println(" ");
				System.out.println(" ");
			
			
			
			}
		  
			
			  
		  
		  if(te[0].equals ("queryFindPagesWhichContainAnyOfTheseWords"))
		  {
			  ArrayList<SearchResult> v = new ArrayList<SearchResult>();

			 
			  MySort m= new MySort();
			  String a[]=new String[te.length-1];
			  WordEntry ds[]= new WordEntry[a.length];
			  for(int i=1;i<te.length;i++)
				 {
					
					 a[i-1]=te[i];
					 a[i-1]=a[i-1].toLowerCase();
					 ds[i-1]= new WordEntry(a[i-1]);
				 }
			  
			  
			
				  
				//System.out.println(this.ipi.pagee.get(u).name);
				 int us=0;
				 PageEntry mm=null ;
				for(int yu=1;yu<=ipi.nopage;yu++)
				{
					PageEntry tt= new PageEntry(this.ipi.pp.get(yu));
				
					for(int ui=0;ui<a.length;ui++)
				
				{
					
					
					if(tt.pi.contains(ds[ui]))
						{
						us++;
						mm = new PageEntry(tt.name);
						break;
						}
				}
				if(us!=0)
				{
					
					SearchResult se= new SearchResult(mm, mm.getRelevanceOfPage(a,false));
					
						if(v!=null)
						{	int uu=0;
							for(int i=0;i<v.size();i++)
							if(v.get(i).p.name.equals(se.p.name))
						{
								uu++;
						 break;
						}
							if(uu==0)
								v.add(se);
						}
						else
							v.add(se);
				
					}
				}
				
			 
			 m.sortThisList(v);
			 if(m.ss.size()==0)
					System.out.println("!Not found");
			for(int i=0;i<m.ss.size();i++)
			{
				
				System.out.print(  m.ss.get(i).p.name + "  , ");
			}
			System.out.println(" ");
			System.out.println(" ");
			
			
			  
			  
		  }
		  if(te[0].equals ("queryFindPagesWhichContainPhrase"))
		  {
			  
			  ArrayList<SearchResult> v = new ArrayList<SearchResult>();
			  MySort m= new MySort();
			  String a[]=new String[te.length-1];
				 for(int i=1;i<te.length;i++)
				 {
					 a[i-1]=te[i];
					 a[i-1]=a[i-1].toLowerCase();
				 }
				 MyLinkedList<PageEntry> ff = this.ipi.getPagesWhichContainPhrase(a);
			  if(ff!=null)
				    {
				  
				 // System.out.println(" b" + ff.size());
				  for(int i=1;i<=ff.size() ; i++)
				  {
					  //
					PageEntry tt=new PageEntry(ff.get(i).name);
					  SearchResult se= new SearchResult(tt,tt.getRelevanceOfPage(a,true));
					  v.add(se);
					
			  }}
			  m.sortThisList(v);
				if(m.ss.size()==0)
					System.out.println("!Not found");
			  for(int i=0;i<m.ss.size();i++)
				{
				
					System.out.print(m.ss.get(i).p.name +  ",    " );
				}
			  System.out.println(" ");
				System.out.println(" ");
			  
			  
		  }
		
	}

}
