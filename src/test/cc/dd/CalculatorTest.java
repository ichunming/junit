package test.cc.dd;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cc.dd.Calculator;

public class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	//所有方法执行一次
	@BeforeClass    
    public static void beforeClass() {     
        System.out.println("@BeforeClass ... 昂贵资源的分配");     
    };
    
    //所有方法执行一次
    @AfterClass    
    public static void afterClass() {     
        System.out.println("@AfterClass ... 昂贵资源的释放");     
    }; 
	
	//每个测试方法执行之前都要执行一次。
	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}
	
	//@Before和@After标示的方法只能各有一个
	
	//每个测试方法执行之后要执行一次。
	@After
	public void tearDown() throws Exception {
		calculator.tearDown();
	}

	@Test
	public void testAdd() {
		calculator.add(2);
		assertEquals(2,calculator.getResult());
	}

	@Test
	public void testSubstract() {
		calculator.add(10);
		calculator.substract(6);
		assertEquals(4,calculator.getResult());
	}

	@Ignore("Multiply() Not yet implemented")
	@Test
	public void testMultiply() {
		calculator.add(1);
		calculator.multiply(10);
		assertEquals(10,calculator.getResult());
	}

	@Test
	public void testDivide() {
		calculator.add(8);
		calculator.divide(2);
		assertEquals(4,calculator.getResult());
	}
	
	@Test(timeout = 1000)
	public void testsquareRoot() {
		calculator.squareRoot();
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		calculator.divide(0);
	}
}
