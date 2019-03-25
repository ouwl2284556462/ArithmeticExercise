package sort.test;

import sort.Sorter;

public class QuickSort extends Sorter {

	@Override
	public void sort(int[] array) {
		doQuickSort(array, 0, array.length - 1);
	}

	private void doQuickSort(int[] array, int startIndex, int endIndex) {
		if(endIndex - startIndex <= 0){
			return;
		}
		
		int mediumIdx = partition(array, startIndex, endIndex);
		doQuickSort(array, startIndex, mediumIdx - 1);
		doQuickSort(array, mediumIdx + 1, endIndex);
	}

	private int partition(int[] array, int startIndex, int endIndex) {
		int mediumVal = array[startIndex];
		int leftIdx = startIndex;
		int rightIdx = endIndex + 1;
		
		while(true){
			
			while(++leftIdx < rightIdx && array[leftIdx] <= mediumVal);
			
			while(array[--rightIdx] > mediumVal);
			
			if(leftIdx >= rightIdx){
				break;
			}
			
			
			swap(array, leftIdx, rightIdx);
		}
		
		swap(array, startIndex, rightIdx);
		return rightIdx;
	}

	@Override
	public String getName() {
		return "øÏÀŸ≈≈–Ú";
	}

}
