
public class SearchResult {
	
	PageEntry p;
	public Float r;
	
	public SearchResult(PageEntry p,float r)
	{
		this.p = p;
		this.r=r;
	}
	public PageEntry getPageEntry()
	{
		return this.p;
	}
	public float getRelevance()
	{
		return r;
	}
	public int compareTo(float f2)
	{
		if(this.r < f2)
		{
			return 1;
		}
		if(this.r>f2)
		{
			return -1;
		}
		else
			return 0;
		
	}

	
	

}
