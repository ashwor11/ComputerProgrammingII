package HW2;

import java.util.Calendar;

public class SmartCamera extends SmartObject implements MotionControl,Comparable<SmartCamera>{
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife){
        this.setBatteryLife(batteryLife);
        this.setNightVision(nightVision);
        this.setMacId(macId);
        this.setAlias(alias);
    }

    public void recordOn(boolean isDay){
        if (this.isConnectionStatus()){
            if (this.status){
                System.out.println("Smart Camera - "+ this.getAlias() +" has been already turned on");
                return;
            }

            if (isNightVision()){
                this.setStatus(true);
                System.out.println("Smart Camera - "+ this.getAlias() +" is turned on now ");

            }else if (isDay) {
                this.setStatus(true);
                System.out.println("Smart Camera - "+ this.getAlias() +" is turned on now ");
            }else {
                System.out.println("Sorry! Smart Camera - "+ this.getAlias() +" does not have night vision feature.");
            }
        }
    }

    public void recordOff(){
        if (this.isConnectionStatus()){
            if (!status){
                System.out.println("Smart Camera - " + this.getAlias() + " has been already turned off");
            }else {
                this.setStatus(false);
                System.out.println("Smart Camera - " + this.getAlias() +  " is turned off now");
            }
        }
    }

    public boolean controlMotion(boolean hasMotion, boolean isDay) {
        if (hasMotion){
            System.out.println("Motion detected!");
            if (nightVision){
                recordOn(isDay);
            }else if (isDay){
                recordOn(isDay);
            }
        } else{
            System.out.println("Motion not detected!");
        }
        return false;
    }

    public boolean testObject() {
        if (this.isConnectionStatus()){
            System.out.println("Test is starting for SmartCamera");
            smartObjectToString();
            System.out.println("Test is starting for SmartCamera day time");
            recordOn(true);
            recordOff();
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            recordOff();
            System.out.println("Test completed for SmartCamera");
            return false;
        }
        return false;
    }

    public boolean shutdownObject() {
        if (this.isConnectionStatus()){
            smartObjectToString();
            setStatus(false);
        }
        return false;
    }

    public int compareTo(SmartCamera o) {
        if (this.getBatteryLife() > o.getBatteryLife())
            return 1;
        else if (this.getBatteryLife() < o.getBatteryLife())
            return -1;
        return 0;
    }

    public String toString(){
        String now = this.isStatus() ? "recording" : "not recording";
        return "SmartCamera -> " + this.getAlias() + "'s battery life is "+ this.getBatteryLife() + " status is " + now + " ";
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }
}
