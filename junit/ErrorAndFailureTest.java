package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ErrorAndFailureTest {
	/*
	 * 1.Failureһ���ɵ�Ԫ����ʹ�õĶ��Է����ж�ʧ��������ģ����ʾ���Ե㷢�������⣬
	 * ����˵��������Ľ��������Ԥ�ڵĲ�һ��
	 * 2.error���ɴ����쳣����ģ������Բ����ڲ��Դ��뱾��Ĵ���Ҳ����ʹ�����Դ����е�һ������bug
	 * 3.����������������֤�����ǶԵģ���������֤����û�д�
	 */
	@Test
	public void testAdd(){
		assertEquals(5,new Calculate().add(3, 3));
	}
	@Test
	public void testDivide(){
		assertEquals(0, new Calculate().divide(6,0));
	}
}
