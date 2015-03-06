package leetcode;

import java.util.HashMap;

public class MaxPointsOnALine {
	
	public static void main(String[] args) {
		MaxPointsOnALine s = new MaxPointsOnALine();
		Point point1 = new Point(2,3);
		Point point2 = new Point(3,3);
		Point point3 = new Point(-5,3);
		Point[] points = {point1, point2, point3};
		System.out.println(s.maxPoints(points));
	}

	public int maxPoints(Point[] points) {

		if (points.length < 2)
			return points.length;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int maxNum = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int duplicate = 1;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicate++;
					continue;
				}
				double key = (points[i].x - points[j].x) == 0 ? Integer.MAX_VALUE
						: (double) (points[i].y - points[j].y)
								/ (points[i].x - points[j].x);
				if(key==-0.0) key =0.0; //java have -0.0 and 0.0, wtf!!! 
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}

			if (map.isEmpty()) {
				maxNum = Math.max(maxNum, duplicate);
			} else {
				for (int v : map.values()) {
					maxNum = Math.max(maxNum, v + duplicate);
				}
			}
		}

		return maxNum;
	}
}
