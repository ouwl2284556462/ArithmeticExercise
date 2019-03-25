package sort.test;

import sort.Sorter;

public class InsertionSort extends Sorter {

	@Override
	public void sort(int[] array) {
		
		for(int i = 1; i < array.length; ++i){
			int curVal = array[i];
			int curIndex = i;
			while(--curIndex > -1 && array[curIndex] > curVal){
				array[curIndex + 1] = array[curIndex];
			}
			
			array[curIndex + 1] = curVal;
		}
	}

	@Override
	public String getName() {
		return "≤Â»Î≈≈–Ú";
	}

}
