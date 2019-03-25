package sort;

public class HeapSort extends Sorter {

	@Override
	public void sort(int[] array) {
		if(array.length == 0){
			return;
		}
		
		
		for(int i = array.length / 2; i > -1; --i){
			trickleDown(array, i, array.length);
		}
		
		for(int i = array.length - 1; i > 0; --i){
			swap(array, 0, i);
			trickleDown(array, 0, i);
		}
	}

	private void trickleDown(int[] array, int parentIdx, int length) {
		int leftChildIdx;
		int rightChildIdx;
		int curVal = array[parentIdx];
		while((leftChildIdx = parentIdx * 2 + 1) < length){
			rightChildIdx = leftChildIdx + 1;
			
			int bigChildIndex;
			if(rightChildIdx < length && array[rightChildIdx] >= array[leftChildIdx]){
				bigChildIndex = rightChildIdx;
			}else{
				bigChildIndex = leftChildIdx;
			}
			
			if(curVal >= array[bigChildIndex]){
				break;
			}
			
			array[parentIdx] = array[bigChildIndex];
			parentIdx = bigChildIndex;
		}
		
		array[parentIdx] = curVal;
	}


	@Override
	public String getName() {
		return "∂—≈≈–Ú";
	}

}
