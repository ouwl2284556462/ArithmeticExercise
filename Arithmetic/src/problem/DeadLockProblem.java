package problem;

public class DeadLockProblem {
	
	public static void main(String[] args){
		Object lockA = new Object();
		Object lockB = new Object();
		
		
		new Thread(()->{
			System.out.println("�߳�1��ʼ...");
			synchronized(lockA){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized(lockB){
					
				}
			}
			
			System.out.println("�߳�1����...");
		}).start();
		
		
		new Thread(()->{
			System.out.println("�߳�2��ʼ...");
			synchronized(lockB){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized(lockA){
					
				}
			}
			
			System.out.println("�߳�2����...");
		}).start();
	}
}
