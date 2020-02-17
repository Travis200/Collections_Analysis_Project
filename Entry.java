public class Entry {
    private String surname;
    private String initials;
    private String telephoneExtension;

    public Entry(String args1, String args2, String args3) {
        this.surname = args1;
        this.initials = args2;
        this.telephoneExtension = args3;

    }

    public String getSurname() {

        return this.surname;
    }

    public String getTelephoneExtension() {
        return this.telephoneExtension;
    }
    public String getInitials(){
        return this.initials;
    }

    public void setTelephoneExtension(String newNumber) {
        this.telephoneExtension = newNumber;
    }
}
