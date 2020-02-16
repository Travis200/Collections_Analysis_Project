public class Entry {
    private String surname;
    private String initials;
    private String telephoneExtension;

    public Entry(String args1, String args2, String args3) {
        String surname = args1;
        String initials = args2;
        String telephoneExtension = args3;

    }

    public String getSurname() {

        return this.surname;
    }

    public String getTelephoneExtension() {
        return this.telephoneExtension;
    }

    public void setTelephoneExtension(String newNumber) {
        this.telephoneExtension = newNumber;
    }
}
