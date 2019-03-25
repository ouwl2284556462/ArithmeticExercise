package problem;

import java.util.Arrays;

public class KeyboardProblem {
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	
	
	public static void main(String[] args){
		String input = "1\n";
		input += "4 4\n";
		input += "1 3 2 4\n";
		input += "1 1 1 1\n";
		
		
		getResult(input);
	}

	private static void getResult(String input) {
		String[] lineArray = input.split("\n");
		int questCnt = Integer.parseInt(lineArray[0]);
		
		for(int i = 0; i < questCnt; ++i){
			int cursor = 3 * i;
			String sizeInfo = lineArray[cursor + 1];
			String whitePosInfo = lineArray[cursor + 2];
			String blackPosInfo = lineArray[cursor + 3];
			
			boolean[][] keyBoardInfo = getKeyBoardInfo(sizeInfo);
			//根据坐标涂白色
			fillColor(keyBoardInfo, whitePosInfo, WHITE);
			//根据坐标涂黑色
			fillColor(keyBoardInfo, blackPosInfo, BLACK);	
			
			
			int whiteCount = 0;
			int blackCount = 0;
			for(boolean[] line : keyBoardInfo){
				for(boolean cell : line){
					if(cell){
						++whiteCount;
					}else{
						++blackCount;
					}
				}
			}
			System.out.println("白色:" + whiteCount + ",黑色:" + blackCount);
		}
		
	}

	private static void fillColor(boolean[][] keyBoardInfo, String posInfo, boolean color) {
		String[] posInfoStrs = posInfo.split(" ");
		int x0 = Integer.parseInt(posInfoStrs[0]);
		int y0 = Integer.parseInt(posInfoStrs[1]);
		int x1 = Integer.parseInt(posInfoStrs[2]);
		int y1 = Integer.parseInt(posInfoStrs[3]);
		
		for(int i = y0 - 1; i < y1; ++i){
			for(int j = x0 - 1; j < x1; ++j){
				keyBoardInfo[i][j] = color;
			}
		}
		
	}

	private static boolean[][] getKeyBoardInfo(String sizeInfo) {
		String[] temp = sizeInfo.split(" ");
		int row = Integer.parseInt(temp[0]);
		int col = Integer.parseInt(temp[1]);
		
		boolean[][] result = new boolean[row][col];
		//true是白色
		boolean rowStartColor = WHITE;
		for(int i = 0; i < row; ++i){
			boolean colColor = rowStartColor;
			for(int j = 0; j < col; ++j){
				result[i][j] = colColor;
				colColor = !colColor;
			}
			
			rowStartColor = !rowStartColor;
		}
		
		return result;
	}
}
