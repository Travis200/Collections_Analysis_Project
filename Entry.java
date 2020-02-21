public class Entry {

    private String surname;
    private String initials;
    private String telephoneExtension;

    //Here I have created a constructor for Entry
    public Entry(String args1, String args2, String args3) {
        this.surname = args1;
        this.initials = args2;
        this.telephoneExtension = args3;
    }

    // Here I have created getters so that I can access the access values from the constructor
    public String getSurname() { return this.surname; }
    public String getTelephoneExtension() {
        return this.telephoneExtension;
    }
    public String getInitials(){
        return this.initials;
    }
    // Here I have created a setter so that I can access the access telephone from the constructor
    public void setTelephoneExtension(String newNumber) {
        this.telephoneExtension = newNumber;
    }
}
