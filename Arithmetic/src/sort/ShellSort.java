package sort;

public class ShellSort extends Sorter {

	@Override
	public void sort(int[] array) {
		int h = 1;
		int len = array.length;
		int lenof3 = len / 3;
		while( h < lenof3){
			h = 3 * h + 1;
		}
		
		while( h >= 1){
			for (int i = h; i < len; ++i) {
				int curVal = array[i];
				int preIndex;
				for(preIndex = i - h; preIndex > -1 && array[preIndex] > curVal; preIndex -= h){
					array[preIndex + h] = array[preIndex];
				}
				array[preIndex + h] = curVal;
			}
			
			h = (h - 1) / 3;
		}
	}

	@Override
	public String getName() {
		return "Ï£¶ûÅÅÐò";
	}

}
