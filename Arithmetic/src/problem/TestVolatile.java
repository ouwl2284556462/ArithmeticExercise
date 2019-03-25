package problem;

public class TestVolatile {
	private static boolean bChanged;

	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			@Override
			public void run() {
				System.out.println("222");
				for (;;) {
					//System.out.println(bChanged);
					if (bChanged == !bChanged) {
						System.out.println("!=");
						System.exit(0);
					}
				}
			}
		}.start();
		Thread.sleep(1000);
		new Thread() {

			@Override
			public void run() {
				System.out.println("111");
				for (;;) {
					bChanged = !bChanged;
				}
			}
		}.start();
	}

}