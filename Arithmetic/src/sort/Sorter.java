package sort;

public abstract class Sorter {
	public abstract void sort(int[] array);
	
	public abstract String getName();
	
	protected void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
