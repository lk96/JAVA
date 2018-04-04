package junit;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitFlowTest {
/*
 * 1��@BeforeClass���εķ����������з���������֮ǰ��ִ�У�
 * ���Ҹ÷����Ǿ�̬�ģ����Ե������౻���غ���žͻ�������
 * �������ڴ�����ֻ�����һ��ʵ�������Ƚ��ʺϼ��������ļ�
 * 2.@AfterClass�����εķ���ͨ���Ƕ���Դ��������ر����ݿ�����
 * 3.@Before	@After����ÿ�����Է�����ǰ���ִ��һ��
 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is beforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is afterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is after");
	}
	@Test
	public void test(){
		System.out.println("this is test");
	}
	@Test
	public void test1(){
		System.out.println("this is test1");
	}
	

}
