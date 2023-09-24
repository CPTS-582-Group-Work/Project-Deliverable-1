
public class Address {

    String personName;
	String streetAddress;
    String cityName;
    String stateName;
    int postalCode;
    int apptNo;
	
    public Address(String personName, String streetAddress, String cityName, String stateName, int postalCode, int apptNo) {
        this.personName = personName;
		this.streetAddress = streetAddress;
        this.cityName = cityName;
        this.stateName = stateName;
        this.postalCode = postalCode;
        this.apptNo = apptNo;
    }
	
    public String getPersonName() {
        return personName;
    }
	public String getStreetAddress() {
        return streetAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getApptNo() {
        return apptNo;
    }
	
}
