package HW2;

public abstract class SmartObject {
    private String alias;
    private String macId;
    private String IP;
    private boolean connectionStatus;

    public SmartObject(){

    }

    public boolean connect(String IP){
        this.IP = IP;
        connectionStatus = true;
        System.out.println(this.alias + " connection established");
        return true;
    }

    public boolean disconnect(){
        this.IP = null;
        connectionStatus = false;
        return false;
    }

    public void smartObjectToString(){
        System.out.println("This is " + getClass().getSimpleName().toString() + " device " + this.getAlias() +"\n" +
                "\tMacId: " + this.getMacId() +"\n" +
                "\tIP: " + this.getIP());
    }

    public boolean controlConnection(){
        System.out.println("This device is not connected. SmartCamera ->" + this.alias);
        return this.connectionStatus;
    }

    public abstract boolean testObject();
    public abstract boolean shutdownObject();

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
