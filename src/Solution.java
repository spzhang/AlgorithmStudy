import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

	List<Interval> result = new ArrayList<Interval>();
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals==null || newInterval==null) return intervals;
		
		for(Interval itvl: intervals ){
			if(itvl.start < newInterval.start && itvl.end<newInterval.start)
				result.add(itvl);
			else if(itvl.start > newInterval.end && itvl.end > newInterval.end)
				result.add(itvl);
			else{
				newInterval.start = itvl.start < newInterval.start?itvl.start:newInterval.start;
				newInterval.end = itvl.end > newInterval.end? itvl.end: newInterval.end;
				if(itvl.end >= newInterval.end) result.add(itvl);
			}
			
		}
		
		return result;

	}
}
