
import java.util.*;  
import java.util.Collections;
import java.util.Comparator;

public class MySort {//implements Comparator<SearchResult>

	
	
		ArrayList<SearchResult> ss= new ArrayList<SearchResult>();
		
	 ArrayList<SearchResult> sortThisList( ArrayList<SearchResult> list ){
		
		for(int i =0;i<list.size();i++)
		{
			ss.add(list.get(i));
		}
		
		Collections.sort(ss,new Comparator<SearchResult>(){
	
	
	
	@Override
	public int compare(SearchResult o1, SearchResult o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2.r);
	}
		});
		
	
		return ss;
}
}
