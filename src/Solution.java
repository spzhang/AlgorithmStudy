import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

	}

	List<Interval> result = new ArrayList<Interval>();

	public List<Interval> merge(List<Interval> intervals) {

		if(intervals ==null || intervals.size()==0) return result;
		Collections.sort(intervals, new IntervalComparator());
		Interval pre, cur, newI;
		pre = intervals.get(0);
		newI = new Interval();
		newI.start = pre.start;
		for(int i = 1; i< intervals.size(); i++){
			cur = intervals.get(i);
			if(cur.start > pre.end){
				newI.end = pre.end;
				result.add(newI);
				newI = new Interval();
				newI.start = cur.start;
			}
			pre = cur;
		}
		newI.end = pre.end;
		result.add(newI);
		
		return result;
	}
	
	class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start < o2.start) return -1;
			else if(o1.start == o2.start){
				if(o1.end < o2.end) return -1;
				else if(o1.end == o2.end) return 0;
				else return 1;
			}
			else return 1;
		}
		
		
	}

}
