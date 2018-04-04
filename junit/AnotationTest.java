package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {
	/*
	 * @Test:将一个普通的方法修饰成为一个测试方法
	 * 		@Test(expected=ArithmeticException.class)将异常捕获
	 * 		@Test(timeout=毫秒)
	 * @BeforeClass：它会在所有方法运行前被执行，static修饰
	 * 	@AfterClass：它会在所有方法运行结束后被执行，static修饰
	 * @Before：会在每一个测试方法被运行前执行一次
	 * @After：会在每一个测试方法被运行后执行一次
	 * @Ignore：所修饰的测试方法会被运行器忽略
	 * @RunWith:可以更改测试运行器 org.junit.runer.Runer
	 */
	@Test(expected=ArithmeticException.class)
	public void testDivide(){
		assertEquals(3, new Calculate().divide(6, 0));
	}
	@Ignore("...")
	@Test(timeout=2000)
	public void testWhile(){
		while (true) {
			System.out.println("run forever...");
		}
	}
	@Test(timeout=3000)
	public void testReadFile(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
