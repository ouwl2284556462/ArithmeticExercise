package sort.test;

import sort.Sorter;

public class HeapSort extends Sorter {

	@Override
	public void sort(int[] array) {
		int len = array.length;
		if(len < 2){
			return;
		}
		
		
		//建立大顶堆结构
		for(int i = len / 2; i > -1; --i){
			trickledown(array, i, len);
		}
		
		
		for(int i = len - 1; i > 0; --i){
			swap(array, 0, i);
			trickledown(array, 0, i);
		}
	}

	private void trickledown(int[] array, int parentIdx, int length) {
		int leftChildIdx;
		int rightChildIdx;
		int curVal = array[parentIdx];
		
		while((leftChildIdx = parentIdx * 2 + 1) < length){
			rightChildIdx = leftChildIdx + 1;
			
			int bigChildIdx;
			if(rightChildIdx < length && array[rightChildIdx] > array[leftChildIdx]){
				bigChildIdx = rightChildIdx;
			}else{
				bigChildIdx = leftChildIdx;
			}
			
			if(curVal >= array[bigChildIdx]){
				break;
			}
			
			array[parentIdx] = array[bigChildIdx];
			parentIdx = bigChildIdx;
		}
		
		array[parentIdx] = curVal;
		
	}

	@Override
	public String getName() {
		return "堆排序";
	}

}
