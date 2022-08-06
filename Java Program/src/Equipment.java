public class Equipment {

    String Equipment_ID, Brand_Name, Purchase_Date;
    double Purchase_Price;
    String Type_Equipment;

    public Equipment(String equipment_ID, String brand_Name, String purchase_Date, double purchase_Price, String type_Equipment) {
        Equipment_ID = equipment_ID;
        Brand_Name = brand_Name;
        Purchase_Date = purchase_Date;
        Purchase_Price = purchase_Price;
        Type_Equipment = type_Equipment;
    }

    public Equipment() {

    }

    public String getEquipment_ID() {
        return Equipment_ID;
    }

    public void setEquipment_ID(String equipment_ID) {
        Equipment_ID = equipment_ID;
    }

    public String getBrand_Name() {
        return Brand_Name;
    }

    public void setBrand_Name(String brand_Name) {
        Brand_Name = brand_Name;
    }

    public String getPurchase_Date() {
        return Purchase_Date;
    }

    public void setPurchase_Date(String purchase_Date) {
        Purchase_Date = purchase_Date;
    }

    public double getPurchase_Price() {
        return Purchase_Price;
    }

    public void setPurchase_Price(double purchase_Price) {
        Purchase_Price = purchase_Price;
    }

    public String getType_Equipment() {
        return Type_Equipment;
    }

    public void setType_Equipment(String type_Equipment) {
        Type_Equipment = type_Equipment;
    }
}
