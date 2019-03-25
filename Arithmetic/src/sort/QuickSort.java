package sort;

public class QuickSort extends Sorter {

	@Override
	public void sort(int[] array) {
		doSort(array, 0, array.length - 1);
	}
	
	private void doSort(int[] array, int start, int end){
		int count = end - start;
		if(count <= 1){
			if(count == 1 && array[start] > array[end]){
				swap(array, start, end);
			}
			
			return;
		}
		
		int medium = partition(array, start, end);
		doSort(array, start, medium - 1);
		doSort(array, medium + 1, end);
	}
	
	private int partition(int[] array, int start, int end){
		int leftIndex = start;
		int rightIndex = end + 1;
		int mediumVal = array[leftIndex];
		
		while(true){
			while(++leftIndex < rightIndex && array[leftIndex] <= mediumVal);
			
			while(array[--rightIndex] > mediumVal);
			
			if(leftIndex > rightIndex){
				break;
			}
			
			swap(array, leftIndex, rightIndex);
		}
		
		swap(array, rightIndex, start);
		return rightIndex;
	}
	

	@Override
	public String getName() {
		return "¿ìËÙÅÅĞò";
	}

}
