package Project_1;

public class Owner {
	//private static Address address = new Address();
   
	  public static String GetFullAddress()
	    {
		  
		  return (Address.StreetAddress() +" "+ Address.CityName()+ " " + Address.StateName() + " "+ 
		          Address.PostalCode() + " " + Address.ApptNo());

//	        return ("Street: "  + Address.StreetAddress() + "\n" + 
//	                "City: "    + Address.CityName() + "\n" + 
//	        		"State: "   + Address.StateName() + "\n"+ 
//	                "ZipCode: " +  Address.PostalCode() + "\n"+ 
//	        		"Apt. "     +  Address.ApptNo()) ;
	    }
	

}

	




