
public class Resident {
	private static Address address1;
	private static Address address2;
	
    public static String[] getFullAddress() {
        address1 = new Address("John", "350 Main St.", "Seattle", "WA", 98002, 306);
		address2 = new Address("Peter", "4200 Broadway Ave.", "Portland", "OR", 97125, 4100);
		
		String ad1 = address1.personName + " " + address1.streetAddress + " " + address1.cityName + " " + address1.stateName + " " + address1.postalCode             + " " + address1.apptNo; 
		String ad2 = address2.personName + " " + address2.streetAddress + " " + address2.cityName + " " + address2.stateName + " " + address2.postalCode             + " " + address2.apptNo;
		String[] Adresses = {ad1, ad2};
		
        return Adresses;
    } 
    public static void test() {
        address1 = new Address("John", "350 Main St.", "Seattle", "WA", 98002, 306);
		address2 = new Address("Peter", "4200 Broadway Ave.", "Portland", "OR", 97125, 4100);
        if (Math.abs(address1.postalCode - address2.postalCode) >50)
		System.out.println(address1.personName + " and " + address2.personName + " do not live in same city");	
    }

}
