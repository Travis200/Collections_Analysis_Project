public class Entry {
    String surname;
    String initials;
    String telephoneExtension;
    public Entry(String args1, String args2, String args3) {
        String surname = args1;
        String initials = args2;
        String telephoneExtension = args3;

    }
    public String getSurname(){
        return this.surname;
    }
    public String getTelephoneExtension(){
        return this.telephoneExtension;
    }
}
