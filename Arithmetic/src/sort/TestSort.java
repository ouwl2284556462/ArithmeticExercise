package sort;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestSort {
	private Random random =new Random();

	//��ӡ����ʱ������ӡ�����ݵ����ޡ� ��������ʡ�Ժ���ʾ�� 
	private static final int PRINT_DATA_MAX_NUM_COUNT = 40;
	//����������ֵ
	private static final int RANDOM_NUM_MAX_VAL = 101;
	
	//ÿ�������������
	private static final int TEST_DATA_COUNT = 1000;
	
	//���Դ���
	private static final int TEST_COUNT = 10;
	
	@Before
	public void printInfo(){
		println("�������:" + TEST_COUNT + ", ÿ������������:" + TEST_DATA_COUNT);
		println("========================================================");
	}
	
	@Test
	public void testSort() {
		testSort(new sort.test.HeapSort());
	}
	
	
//	
//	@Test
//	public void testHeapSort() {
//		testSort(new HeapSort());
//	}
//	
//	@Test
//	public void testShellSort() {
//		testSort(new ShellSort());
//	}
//	
//	@Test
//	public void testMergeSort() {
//		testSort(new MergeSort());
//	}
//	
//	@Test
//	public void testSelectionSort() {
//		testSort(new SelectionSort());
//	}
//	
//	@Test
//	public void testQuickSort() {
//		testSort(new QuickSort());
//	}
//	
//	@Test
//	public void testBubbleSort() {
//		testSort(new BubbleSort());
//	}
//	
//	
//	@Test
//	public void testInserctionSort() {
//		testSort(new InsertionSort());
//	}
	
	
	private void testSort(Sorter sorter){
		println(sorter.getName() + ":");
		
		//���Բ�ͬ������ʱ�۲���û�д�
		for(int i = 0; i < 20; ++i){
			Map<Integer, Integer> dataStatic = new HashMap<Integer, Integer>();
			int[] datas = generateDatas(i);
			collectionDataInfo(dataStatic, datas);
			sorter.sort(datas);
			//������Ƿ���ȷ
			testSortRight(datas, dataStatic);	
			
			//����˳���
			dataStatic.clear();
			datas = generateOrderDatas(i, true);
			collectionDataInfo(dataStatic, datas);
			sorter.sort(datas);
			//������Ƿ���ȷ
			testSortRight(datas, dataStatic);	
			
			//���Ե����
			dataStatic.clear();
			datas = generateOrderDatas(i, true);
			collectionDataInfo(dataStatic, datas);
			sorter.sort(datas);
			//������Ƿ���ȷ
			testSortRight(datas, dataStatic);
		}
		
		double useTime = 0;
		for(int i = 0; i < TEST_COUNT; ++i){
			Map<Integer, Integer> dataStatic = new HashMap<Integer, Integer>();
			int[] datas = generateDatas(TEST_DATA_COUNT);
			collectionDataInfo(dataStatic, datas);
			
			long begin = System.currentTimeMillis();
			sorter.sort(datas);
			useTime += System.currentTimeMillis() - begin;
			
			//������Ƿ���ȷ
			testSortRight(datas, dataStatic);
		}
		
		double averageTime = useTime / TEST_COUNT;
		println("ƽ������ʱ��:" + averageTime);
		println("===============================================\n\n");
	}
	
	private int[] generateOrderDatas(int count, boolean asc) {
		int[] result = new int[count];
		
		if(asc){
			for(int i = 0; i < count; ++i){
				result[i] = i; 
			}
		}else{
			for(int i = count; i > 0; --i){
				result[i] = i; 
			}	
		}
		
		return result;
	}

	/**
	 * ���������û�иı䣬�ı������
	 * @param datas
	 * @param dataStatic
	 */
	private void testDataNoChg(int[] datas, Map<Integer, Integer> dataStatic) {
		for(int num : datas){
			Integer cnt = dataStatic.get(num);
			assertNotNull("��������:" + num, cnt);
			assertTrue("��������:" + num, cnt > 0);
			dataStatic.put(num, --cnt);
		}
		
		for(int cnt : dataStatic.values()){
			assertTrue("��������", cnt == 0);
		}
	}


	private void collectionDataInfo(Map<Integer, Integer> dataStatic, int[] datas) {
		for(int num : datas){
			Integer cnt = dataStatic.get(num);
			if(null == cnt){
				cnt = 0;
			}
			
			++cnt;
			dataStatic.put(num, cnt);
		}
	}


	private void testSortRight(int[] datas, Map<Integer, Integer> dataStatic) {
		//��������Ƿ�һ��
		testDataNoChg(datas, dataStatic);
		//����Ƿ�С����
		checkSort(datas);
	}


	private void checkSort(int[] data){
		if(data.length < 2){
			return;
		}
		
		for(int i = 1; i < data.length; ++i){
			assertTrue("�������:" + Arrays.toString(data), data[i] >= data[i - 1]);
		}
	}
	
	
	private int[] generateDatas(int count){
		int[] result = new int[count];
		for(int i = 0; i < count; ++i){
			result[i] = random.nextInt(RANDOM_NUM_MAX_VAL); 
		}
		return result;
	}
	
	private void print(Object o){
		System.out.print(o);
	}
	
	private void println(Object o){
		System.out.println(o);
	}
	
	private void printDatas(int[] datas){
		int totalSize = datas.length;
		if(totalSize <=  PRINT_DATA_MAX_NUM_COUNT){
			printDatas(datas, 0, totalSize);
			return;
		}
		
		int showCount = PRINT_DATA_MAX_NUM_COUNT / 2;
		int firstSectionEndIndex = showCount;
		int secondSectionStartIndex = totalSize - showCount;
		
		//��һ��
		printDatas(datas, 0, firstSectionEndIndex);
		//��ӡʡ�Ժ�
		print("... ");
		//�ڶ���
		printDatas(datas, secondSectionStartIndex, totalSize);
	}
	
	private void printDatas(int[] datas, int startIndex, int endIndex){
		for(int i = startIndex; i < endIndex; ++i){
			print(datas[i] + " ");
		}
	}
	
}
