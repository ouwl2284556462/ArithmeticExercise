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
		
		System.out.println("��̾���:" + getShortestDistance(input));
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
		
		//������
		Arrays.sort(xn);
		
		Map<Integer, Set<Integer>> result = new HashMap<Integer, Set<Integer>>();
		getShortestDistance(result, new LinkedHashSet<Integer>(), xn, n, a, -1, 0, 0);
		
		return result.keySet().iterator().next();
	}

	private static void getShortestDistance(Map<Integer, Set<Integer>> result, LinkedHashSet<Integer> hasGoneIdxs, int[] xn, int n, int curPos, int toGoIdx, int curCnt, int curDistance) {
		//��ʼ��ʱΪ-1����Ҫ�ҵ���ǰλ��������������������
		if(toGoIdx < 0){
			int leftIdx = -1;
			for(int i = xn.length - 1; i > -1 ; --i ){
				if(curPos >= xn[i]){
					leftIdx = i;
					break;
				}
			}
			
			//������
			getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, curPos, leftIdx, curCnt, curDistance);
			
			//������
			int rightIdx = leftIdx + 1;
			if(rightIdx < xn.length){
				getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, curPos, rightIdx, curCnt, curDistance);
			}
		}else{
			//������߹�
			hasGoneIdxs.add(toGoIdx);
			int nextPos = xn[toGoIdx];
			curDistance += Math.abs(curPos - nextPos);
			
			
			for(Integer distance : result.keySet()){
				//�Ѿ������ٵĴ󣬲�������
				if(curDistance >= distance){
					return;
				}
			}
			
			
			++curCnt;
			if(curCnt >= n - 1){
				//ɾ����������̾��룬����������ͬ����̾����·��
				result.clear();
				result.put(curDistance, hasGoneIdxs);
				return;
			}
			
			
			
			
			//������
			for(int nextIdx = toGoIdx - 1; nextIdx > -1; --nextIdx){
				if(!hasGoneIdxs.contains(nextIdx)){
					getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, nextPos, nextIdx, curCnt, curDistance);
					break;
				}
			}
			
			//������
			for(int nextIdx = toGoIdx + 1; nextIdx < xn.length; ++nextIdx){
				if(!hasGoneIdxs.contains(nextIdx)){
					getShortestDistance(result, new LinkedHashSet<Integer>(hasGoneIdxs), xn, n, nextPos, nextIdx, curCnt, curDistance);
					break;
				}
			}
		}
	}

}
