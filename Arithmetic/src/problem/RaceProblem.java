package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RaceProblem {

	public static void main(String[] args) {
		String input = "5 1\n";
		input += "-4 -3 2 3 8";
		
		System.out.println("最短距离:" + getShortestDistance(input));
	}

	private static int getShortestDistance(String input) {
		String[] info = input.split("\n");
		String[] row1 = info[0].split(" ");
		String[] row2 = info[1].split(" ");
		
		int n = Integer.parseInt(row1[0]);
		int a = Integer.parseInt(row1[1]);
		int[] xn = new int[n];
		for(int i = 0; i < n; ++i){
			xn[i] = Integer.parseInt(row2[i]);
		}
		
		//先排序
		Arrays.sort(xn);
		
		Map<Integer, Set<Integer>> result = new HashMap<Integer, Set<Integer>>();
		getShortestDistance(result, new LinkedHashSet<Integer>(), xn, n, a, -1, 0, 0);
		
		return result.keySet().iterator().next();
	}

	private static void getShortestDistance(Map<Integer, Set<Integer>> result, LinkedHashSet<Integer> hasGoneIdxs, int[] xn, int n, int curPos, int toGoIdx, int curCnt, int curDistance) {
		//初始化时为-1，需要找到当前位置最近的两个检查点的索引
		if(toGoIdx < 0){
			int leftIdx = -1;
			for(int i = xn.length - 1; i > -1 ; --i ){
				if(curPos >= xn[i]){
					leftIdx = i;
					break;
				}
			}
			
			//往左走
			getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, curPos, leftIdx, curCnt, curDistance);
			
			//往右走
			int rightIdx = leftIdx + 1;
			if(rightIdx < xn.length){
				getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, curPos, rightIdx, curCnt, curDistance);
			}
		}else{
			//标记已走过
			hasGoneIdxs.add(toGoIdx);
			int nextPos = xn[toGoIdx];
			curDistance += Math.abs(curPos - nextPos);
			
			
			for(Integer distance : result.keySet()){
				//已经比最少的大，不再搜索
				if(curDistance >= distance){
					return;
				}
			}
			
			
			++curCnt;
			if(curCnt >= n - 1){
				//删除其他非最短距离，保留其他相同的最短距离的路径
				result.clear();
				result.put(curDistance, hasGoneIdxs);
				return;
			}
			
			
			
			
			//往左走
			for(int nextIdx = toGoIdx - 1; nextIdx > -1; --nextIdx){
				if(!hasGoneIdxs.contains(nextIdx)){
					getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, nextPos, nextIdx, curCnt, curDistance);
					break;
				}
			}
			
			//往右走
			for(int nextIdx = toGoIdx + 1; nextIdx < xn.length; ++nextIdx){
				if(!hasGoneIdxs.contains(nextIdx)){
					getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, nextPos, nextIdx, curCnt, curDistance);
					break;
				}
			}
		}
	}

}
