public class Service {

    String Service_ID, Service_Name, Service_Discription, Rate_Change, Duration;

    public Service(String service_ID, String service_Name, String service_Discription, String rate_Change, String duration) {
        Service_ID = service_ID;
        Service_Name = service_Name;
        Service_Discription = service_Discription;
        Rate_Change = rate_Change;
        Duration = duration;
    }

    public Service() {

    }

    public String getService_ID() {
        return Service_ID;
    }

    public void setService_ID(String service_ID) {
        Service_ID = service_ID;
    }

    public String getService_Name() {
        return Service_Name;
    }

    public void setService_Name(String service_Name) {
        Service_Name = service_Name;
    }

    public String getService_Discription() {
        return Service_Discription;
    }

    public void setService_Discription(String service_Discription) {
        Service_Discription = service_Discription;
    }

    public String getRate_Change() {
        return Rate_Change;
    }

    public void setRate_Change(String rate_Change) {
        Rate_Change = rate_Change;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }
}
