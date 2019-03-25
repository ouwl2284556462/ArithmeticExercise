package sort.test;

import sort.Sorter;

public class BubbleSort extends Sorter {

	@Override
	public void sort(int[] array) {
		for (int i = array.length - 1; i > 0; --i) {
			int chgPos = 0;
			for(int j = 0; j < i; ++j){
				if(array[j] > array[j + 1]){
					swap(array, j, j + 1);
					chgPos = j;
				}
			}
			
			i = chgPos + 1;
		}
	}

	@Override
	public String getName() {
		return "ц╟ещеепР";
	}

}
