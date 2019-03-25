package problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TowerProblem {

	public static void main(String[] args) {
		// ��������
		// ����
		String towerInfo = "5\n";
		// ÿ��߶�
		towerInfo += "1\n";
		towerInfo += "2\n";
		towerInfo += "5\n";
		towerInfo += "3\n";
		towerInfo += "4\n";

		System.out.println("��Ҫ�����ʱ��: " + getShortestTime(towerInfo));
	}

	private static int getShortestTime(String towerInfo) {
		String[] infos = towerInfo.split("\n");
		// ����
		int levelCount = Integer.parseInt(infos[0]);
		// ÿ�θ߶�
		int[] heights = new int[levelCount];
		for (int i = 0; i < levelCount; ++i) {
			heights[i] = Integer.parseInt(infos[i + 1]);
		}

		Map<Integer, String> result = new HashMap<Integer, String>();
		getShortestTime(result, heights, -1, 0, -1, "");
		
		int shoestime = Integer.MAX_VALUE;
		String shoestPath = "";
		for(Entry<Integer, String> pathInfo : result.entrySet()){
			int useTime = pathInfo.getKey();
			String path = pathInfo.getValue();
			
			if(shoestime > useTime){
				shoestime = useTime;
				shoestPath = path;
			}
			
			System.out.println("ʹ��ʱ��:" + useTime + ",\n·��:\n" + path);
		}
		
		return shoestime;
	}

	private static void getShortestTime(Map<Integer, String> result, int[] heights, int curLevel,
			int useTime, int jumpCount, String pathInfo) {
		if(jumpCount <= 0 && curLevel > -1){
			//jumpCount С�ڵ���0������Ծ�У�������ʱ�䡣 ��Ծ�в�����ʱ��
			useTime  += heights[curLevel];
		}
		
		int nextLevel = curLevel + 1;
		//jumpCount С��0ʱ��ħ����������Ծ
		//jumpCount ����0ʱû��ħ������������
		//jumpCount ����0ʱ��ʾ��Ծ��
		if(jumpCount >= 0){
			--jumpCount;
		}
		
		for(int time : result.keySet()){
			if(useTime >= time){
				//�Ѿ�������Сʱ�䣬��������
				return;
			}
		}
		
		if(nextLevel >= heights.length){
			result.clear();
			result.put(useTime, pathInfo);
			return;
		}
		
		//���л�����Ծ��
		getShortestTime(result, heights, nextLevel, useTime, jumpCount, pathInfo + getGoInfo(jumpCount, nextLevel, 0));
		
		//jumpCount С��0����ħ������ѡ����Ծ
		if(jumpCount < 0){
			//ѡ����Ծ1��
			getShortestTime(result, heights, nextLevel, useTime, 1, pathInfo + getGoInfo(jumpCount, nextLevel, 1));
			//ѡ����Ծ2��
			getShortestTime(result, heights, nextLevel, useTime, 2, pathInfo + getGoInfo(jumpCount, nextLevel, 2));
		}
	}

	private static String getGoInfo(int jumpCount, int nextLevel, int nextSelectJumpCnt) {
		if(jumpCount == 0){
			return "��" + nextLevel + "�㣬û��ħ��������Ծ������.\n";
		}
		
		
		if(jumpCount < 0){
			if(nextSelectJumpCnt <= 0){
				return "��" + nextLevel + "�㣬����.\n";
			}
			
			
			return "��" + nextLevel + "�㣬��Ծ" + nextSelectJumpCnt + "��.\n";
		}
		
		//��Ծ��
		return "";
	}

}
