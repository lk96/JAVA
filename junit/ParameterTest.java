package junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	/*
	 * 1.����Ĭ�ϵĲ���������Ϊ@RunWith(Parameterized.class)
	 * 2.�������������Ԥ��ֵ�ͽ��ֵ
	 * 3.����һ������ֵΪCollection�Ĺ�����̬��������ʹ��@Parameters��������
	 * 4.Ϊ����������һ���в����Ĺ������캯������������Ϊ֮����������ֵ
	 */
	int expected = 0;
	int intput1 = 0;
	int intput2 = 0;

	@Parameters
	public static Collection<Object[]> t() {
		return Arrays.asList(new Object[][] { { 3, 1, 2 }, { 4, 2, 2 } });
	}

	public ParameterTest(int excepted, int input1, int input2) {
		this.expected = excepted;
		this.intput1 = input1;
		this.intput2 = input2;
	}

	@Test
	public void testAdd() {
		assertEquals(expected, new Calculate().add(intput1, intput2));
	}
}
