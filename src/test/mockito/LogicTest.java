package test.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import mock.LogicEx;
import mock.ServiceI;

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
		mockService = mock(ServiceI.class);
		target.setService(mockService);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogicEx() {
		try{
			when(mockService.selDate()).thenReturn("Mock Date");
			assertEquals("Mock Date",target.getDate());
			verify(mockService).selDate();
//			verify(mockService, times(1)).selDate();
//			verify(mockService, atLeast(1)).selDate();
//			verify(mockService, atMost(5)).selDate();
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testLogicEx_Exception() {
		Exception exception = new Exception();
		try{
			when(mockService.selDate()).thenThrow(exception);
			target.getDate();
			fail();
		}catch(Exception e) {
			assertEquals(e, exception);
		}

	}
}
