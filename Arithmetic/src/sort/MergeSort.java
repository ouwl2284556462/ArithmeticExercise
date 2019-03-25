package sort;

public class MergeSort extends Sorter {

	@Override
	public void sort(int[] array) {
		merge(array, new int[array.length], 0, array.length - 1);
	}
	
	private void merge(int[] array, int[] workSpace, int start, int end){
		if(start >= end){
			return;
		}
		
		int medium = (start + end) / 2;
		merge(array, workSpace, start, medium);
		merge(array, workSpace, medium + 1, end);
		
		int curIndex = start;
		int leftIndex = start;
		int rightIndex = medium + 1;
		
		while(leftIndex <= medium && rightIndex <= end){
			int leftVal = array[leftIndex];
			int rightVal = array[rightIndex];
			int smallerVal;
			if(leftVal <= rightVal){
				smallerVal = leftVal;
				++leftIndex;
			}else{
				smallerVal = rightVal;
				++rightIndex;
			}
			
			workSpace[curIndex++] = smallerVal;
		}
		
		while(leftIndex <= medium){
			workSpace[curIndex++] = array[leftIndex++];
		}
		
		while(rightIndex <= end){
			workSpace[curIndex++] = array[rightIndex++];
		}
		
		System.arraycopy(workSpace, start, array, start, end - start + 1);
	}

	@Override
	public String getName() {
		return "¹é²¢ÅÅÐò";
	}

}
