package sort.test;

import sort.Sorter;

public class ShellSort extends Sorter {

	@Override
	public void sort(int[] array) {
		int h = 1;
		int lenOf3 = array.length / 3;
		while(h < lenOf3){
			h = 3 * h + 1;
		}
		
		while(h > 0){
			for(int i = h; i < array.length; ++i){
				int curVal = array[i];
				int j;
				for(j = i - h; j > -1 && array[j] > curVal; j = j - h){
					array[j + h] = array[j];
				}
				
				array[j + h] = curVal;
			}
			
			h = (h - 1) / 3;
		}
	}

	@Override
	public String getName() {
		return "Ï£¶ûÅÅÐò";
	}

}
