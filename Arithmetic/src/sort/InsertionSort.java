package sort;

public class InsertionSort extends Sorter {

	@Override
	public void sort(int[] array) {
		int arraySize = array.length;
		
		for(int i = 1; i < arraySize; ++i){
			int curNum = array[i];
			int preIdx;
			for(preIdx = i - 1; preIdx > -1 && array[preIdx] > curNum; --preIdx){
				array[preIdx + 1] = array[preIdx];
			}
			
			array[preIdx + 1] = curNum;
		}
	}

	@Override
	public String getName() {
		return "≤Â»Î≈≈–Ú";
	}
	
	

}
