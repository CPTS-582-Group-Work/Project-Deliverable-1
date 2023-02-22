package Project_1.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.verification.VerificationMode;

import junit.framework.Assert;
import junit.framework.TestCase;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Project_1.Owner;
import Project_1.Address;
//import Project_1.Owner.Address;

import static org.mockito.Mockito.*;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;


public class Test1{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	} 
	
	@Mock
    private Owner owner = new Owner();
	
	@Mock
	private Address address = new Address();
    
	//PASS TEST
	@Test
	public void testGetFullAddressPass() {		   
   
		//Address address = Mockito.spy(new Address());
		//Owner owner = Mockito.spy(new Owner());
		
		Address address = mock(Address.class);
		Owner owner = mock(Owner.class);        

		
		String out = Owner.GetFullAddress();
        System.out.print(out);
        
        //PASS TEST
        assert(out).equals("350 Main St. Seattle WA 97125 306");

		
		//Mockito.verify((owner), atLeast(10)).GetFullAddress();
		//Mockito.verify((address), atLeast(100)).StreetAddress();
	
	

}
	//FAIL TEST
	@Test
	public void testGetFullAddressFail() {		   
		
		Address address = mock(Address.class);
		Owner owner = mock(Owner.class);        

		
		String out = Owner.GetFullAddress();
        System.out.print(out);
        
      //FAILED TEST
        assert(out).equals("50 Main St. Seattle WA 97125 306");
	

}


}






