public class Address {
    private String street;
    private String building;
    private String apartment;

    public Address(String street, String building, String apartment) {
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "вул. " + street + ", буд. " + building + ", кв. " + apartment;
    }
}