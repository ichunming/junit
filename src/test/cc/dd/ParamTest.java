package test.cc.dd;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//参数化测试
@RunWith(Parameterized.class)
public class ParamTest {
	private int param;
	private int param2;
	private int result;

	@Parameters public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{ { 2, 4, 6 }, { 0, 0, 0 }, { -3, 9, 6 } });
	}
	
	// 构造函数，对变量进行初始化
	public ParamTest(int param, int param2, int result) {
		this.param = param;
		this.param2 = param2;
		this.result = result;
	}

	@Test public void run() {
		int expected = param + param2;
		assertEquals(expected, result);
	}

}
