package sort.test;

import sort.Sorter;

public class SelectSort extends Sorter {

	@Override
	public void sort(int[] array) {
		for(int i = array.length; i > 0; --i){
			int maxIndex = 0;
			int maxVal = array[0];
			for(int j = 1; j < i; ++j){
				if(array[j] > maxVal){
					maxIndex = j;
					maxVal = array[j];
				}
			}
			swap(array, maxIndex, i - 1);
		}
	}

	@Override
	public String getName() {
		return "—°‘Ò≈≈–Ú";
	}

}
