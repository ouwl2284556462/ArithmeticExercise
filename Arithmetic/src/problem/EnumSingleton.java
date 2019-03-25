package problem;

import java.util.HashMap;
import java.util.Map;

public class EnumSingleton {

	public static void main(String[] args) {
		System.out.println("还没使用单例前");
		
		System.out.println(MySingletonClass.getInst());
		MySingleTonEnum.INSTANCE.setValue("A", "1");
		MySingleTonEnum.INSTANCE.setValue("B", "2");
		
		System.out.println(MySingleTonEnum.INSTANCE.getValue("A"));
		System.out.println(MySingleTonEnum.INSTANCE.getValue("B"));
		System.out.println(MySingleTonEnum.INSTANCE.getValue("C"));
	}
	
	public static enum MySingleTonEnum{
		INSTANCE;
		private Map<String, String> data;
		
		private MySingleTonEnum(){
			System.out.println("初始化");
			data = new HashMap<String, String>();
		}
		
		public void setValue(String key, String value){
			data.put(key, value);
		}
		
		public String getValue(String key){
			return data.get(key);
		}
		
	}
	
	
	public static class MySingletonClass{
		private static MySingletonClass INSTANCE = new MySingletonClass();
		
		private MySingletonClass(){
			System.out.println("MySingletonClass 初始化");
		}
		
		
		public static MySingletonClass getInst(){
			return INSTANCE;
		}
	}

}
