public class Customer {

    String ID_Number, Customer_Name, Address, email;
    int Telephone_Num;
    String Credit_card_info;
    int Current_Balance;

    public Customer(String ID_Number, String customer_Name, String address, String email, int telephone_Num, String credit_card_info, int current_Balance) {
        this.ID_Number = ID_Number;
        Customer_Name = customer_Name;
        Address = address;
        this.email = email;
        Telephone_Num = telephone_Num;
        Credit_card_info = credit_card_info;
        Current_Balance = current_Balance;
    }

    public Customer() {

    }

    public String getID_Number() {
        return ID_Number;
    }

    public void setID_Number(String ID_Number) {
        this.ID_Number = ID_Number;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone_Num() {
        return Telephone_Num;
    }

    public void setTelephone_Num(int telephone_Num) {
        Telephone_Num = telephone_Num;
    }

    public String getCredit_card_info() {
        return Credit_card_info;
    }

    public void setCredit_card_info(String credit_card_info) {
        Credit_card_info = credit_card_info;
    }

    public int getCurrent_Balance() {
        return Current_Balance;
    }

    public void setCurrent_Balance(int current_Balance) {
        Current_Balance = current_Balance;
    }
}
