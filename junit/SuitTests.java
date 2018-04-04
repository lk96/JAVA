package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TaskTest1.class, TaskTest2.class })
public class SuitTests {
	/*
	 * 测试套件就是组织测试类一起运行的
	 */
}
