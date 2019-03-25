package sort;

public class SelectionSort extends Sorter {

	@Override
	public void sort(int[] array) {
		for(int i = array.length; i > 0; --i ){
			int maxIndex = 0;
			int maxVal = array[maxIndex];
			for(int j = 1; j < i; ++j){
				if(array[j] > maxVal){
					maxIndex = j;
					maxVal = array[maxIndex];
				}
			}
			
			swap(array, maxIndex, i - 1);
			//≤ªŒ»∂®≈≈–Ú
			//3   3    1   2
			//2   3    1   3
			//2   1    3   3
		}
	}

	@Override
	public String getName() {
		return "—°‘Ò≈≈–Ú";
	}

}
