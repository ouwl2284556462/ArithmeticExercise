package problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TowerProblem {

	public static void main(String[] args) {
		// 测试数据
		// 层数
		String towerInfo = "5\n";
		// 每层高度
		towerInfo += "1\n";
		towerInfo += "2\n";
		towerInfo += "5\n";
		towerInfo += "3\n";
		towerInfo += "4\n";

		System.out.println("需要的最短时间: " + getShortestTime(towerInfo));
	}

	private static int getShortestTime(String towerInfo) {
		String[] infos = towerInfo.split("\n");
		// 层数
		int levelCount = Integer.parseInt(infos[0]);
		// 每次高度
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
			
			System.out.println("使用时间:" + useTime + ",\n路径:\n" + path);
		}
		
		return shoestime;
	}

	private static void getShortestTime(Map<Integer, String> result, int[] heights, int curLevel,
			int useTime, int jumpCount, String pathInfo) {
		if(jumpCount <= 0 && curLevel > -1){
			//jumpCount 小于等于0则不是跳跃中，则增加时间。 跳跃中不增加时间
			useTime  += heights[curLevel];
		}
		
		int nextLevel = curLevel + 1;
		//jumpCount 小于0时有魔法，可以跳跃
		//jumpCount 等于0时没有魔法，必须爬行
		//jumpCount 大于0时表示跳跃中
		if(jumpCount >= 0){
			--jumpCount;
		}
		
		for(int time : result.keySet()){
			if(useTime >= time){
				//已经大于最小时间，不再搜索
				return;
			}
		}
		
		if(nextLevel >= heights.length){
			result.clear();
			result.put(useTime, pathInfo);
			return;
		}
		
		//爬行或者跳跃中
		getShortestTime(result, heights, nextLevel, useTime, jumpCount, pathInfo + getGoInfo(jumpCount, nextLevel, 0));
		
		//jumpCount 小于0后，有魔法可以选择跳跃
		if(jumpCount < 0){
			//选择跳跃1层
			getShortestTime(result, heights, nextLevel, useTime, 1, pathInfo + getGoInfo(jumpCount, nextLevel, 1));
			//选择跳跃2层
			getShortestTime(result, heights, nextLevel, useTime, 2, pathInfo + getGoInfo(jumpCount, nextLevel, 2));
		}
	}

	private static String getGoInfo(int jumpCount, int nextLevel, int nextSelectJumpCnt) {
		if(jumpCount == 0){
			return "第" + nextLevel + "层，没有魔法不能跳跃，爬行.\n";
		}
		
		
		if(jumpCount < 0){
			if(nextSelectJumpCnt <= 0){
				return "第" + nextLevel + "层，爬行.\n";
			}
			
			
			return "第" + nextLevel + "层，跳跃" + nextSelectJumpCnt + "层.\n";
		}
		
		//跳跃中
		return "";
	}

}
