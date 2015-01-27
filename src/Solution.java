import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
        List<List<String>> pre = new ArrayList<List<String>>();
        List<List<String>> cur = new ArrayList<List<String>>();
        for(List<String> list: pre){
        	list.add("hello");
        	cur.add(list);
        }

        System.out.println(cur);
	}


}
