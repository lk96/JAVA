package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {
	/*
	 * @Test:��һ����ͨ�ķ������γ�Ϊһ�����Է���
	 * 		@Test(expected=ArithmeticException.class)���쳣����
	 * 		@Test(timeout=����)
	 * @BeforeClass�����������з�������ǰ��ִ�У�static����
	 * 	@AfterClass�����������з������н�����ִ�У�static����
	 * @Before������ÿһ�����Է���������ǰִ��һ��
	 * @After������ÿһ�����Է��������к�ִ��һ��
	 * @Ignore�������εĲ��Է����ᱻ����������
	 * @RunWith:���Ը��Ĳ��������� org.junit.runer.Runer
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
