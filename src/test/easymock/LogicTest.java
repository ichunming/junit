package test.easymock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import mock.LogicEx;
import mock.ServiceI;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LogicTest {

	// target
	private LogicEx target = new LogicEx();

	// service
	private ServiceI mockService;
	
	@BeforeClass    
    public static void beforeClass() {        
    };

    @AfterClass    
    public static void afterClass() { 
    }; 
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(ServiceI.class);
		target.setService(mockService);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogicEx() {
		try{
			EasyMock.reset(mockService);
			EasyMock.expect(mockService.selDate()).andReturn("Mock Date");
			//EasyMock.expect(mockService.selDate()).andReturn("Mock Date").times(1);
			//EasyMock.expect(mockService.selDate()).andReturn("Mock Date").times(1, 5);
			EasyMock.replay(mockService);
			assertEquals("Mock Date", target.getDate());
			EasyMock.verify(mockService);
		}catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testLogicEx_Exception() {
		Exception exception = new Exception();
		try{
			EasyMock.expect(mockService.selDate()).andThrow(exception);
			EasyMock.replay(mockService);
			target.getDate();
			fail();
		}catch(Exception e) {
			assertEquals(e, exception);
		}
	}
}
