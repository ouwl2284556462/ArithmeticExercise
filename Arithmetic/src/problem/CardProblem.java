package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CardProblem {
	public static void main(String[] args){
		int n = 10;
		
		List<Integer> result = getThrowCardNums(10);
		for(Integer num : result){
			System.out.print(num + " ");
		}
	}

	private static List<Integer> getThrowCardNums(int n) {
		LinkedList<Integer> cards = new LinkedList<Integer>();
		for(int i = 0; i < n; ++i){
			cards.addLast(i + 1);
		}
		
		List<Integer> result = new ArrayList<>();
		while(true){
			if(cards.size() <= 1){
				break;
			}
			
			result.add(cards.removeFirst());
			if(cards.size() <= 1){
				break;
			}
			
			cards.addLast(cards.removeFirst());
		}
		
		return result;
	}
}
