package sort.test;

import sort.Sorter;

public class MergeSort extends Sorter {

	@Override
	public void sort(int[] array) {
		if(array.length <= 1){
			return;
		}
		
		doMergeSort(array, new int[array.length], 0, array.length - 1);
	}

	private void doMergeSort(int[] array, int[] workspace, int startIdx, int endIdx) {
		if(endIdx <= startIdx){
			return;
		}
		
		int mediumIdx = (endIdx + startIdx) / 2;
		doMergeSort(array, workspace, startIdx, mediumIdx);
		doMergeSort(array, workspace, mediumIdx + 1, endIdx);
		
		int leftIdx = startIdx;
		int rightIdx = mediumIdx + 1;
		int curIdex = startIdx;
		while(leftIdx <= mediumIdx && rightIdx <= endIdx){
			if(array[leftIdx] <= array[rightIdx]){
				workspace[curIdex++] = array[leftIdx++];
			}else{
				workspace[curIdex++] = array[rightIdx++];
			}
		}
		
		while(leftIdx <= mediumIdx){
			workspace[curIdex++] = array[leftIdx++];
		}
		
		while(rightIdx <= endIdx){
			workspace[curIdex++] = array[rightIdx++];
		}
		
		
		System.arraycopy(workspace, startIdx, array, startIdx, endIdx - startIdx + 1);
		
	}

	@Override
	public String getName() {
		return "¹é²¢ÅÅÐò";
	}

}
