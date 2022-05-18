package HW2;

import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable{

    private boolean status;
    private Calendar programTime;
    private boolean programAction;

    public SmartPlug(String alias, String macId){
        this.setAlias(alias);
        this.setMacId(macId);
    }

    public void turnOn(){
        if (this.isConnectionStatus()){
            if (status){
                System.out.println("Smart Plug - " + this.getAlias() + " has been already turned on");
            }else {
                setStatus(true);
                Calendar now = Calendar.getInstance();
                System.out.println("Smart Plug - " + this.getAlias() +  " is turned on now (Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) + ")");
            }
        }
    }

    public void turnOff(){
        if (this.isConnectionStatus()){
            if (!status){
                System.out.println("Smart Plug - " + this.getAlias() + " has been already turned off");
            }else {
                setStatus(false);
                Calendar now = Calendar.getInstance();
                System.out.println("Smart Plug - " + this.getAlias() +  " is turned off now (Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) +")");
            }
        }
    }

    public boolean testObject(){
        if (this.isConnectionStatus()){
            System.out.println("Test is starting for SmartPlug");
            smartObjectToString();
            turnOn();
            turnOff();
            System.out.println("Test completed for SmartPlug");
            return true;
        }
        return false;
    }

    public void setTimer(int seconds) {
        if (isConnectionStatus()){
            Calendar now = Calendar.getInstance();
            programTime = now;
            programTime.add(Calendar.SECOND,seconds);
            if (this.isStatus()){
                System.out.println("Smart plug - " + this.getAlias() + " will be turned off " + seconds + " seconds later! " + "(Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) +")");
            }else {
                System.out.println("Smart plug - " + this.getAlias() + " will be turned on " + seconds + " seconds later! " + "(Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) +")");

            }
        }
    }


    public void cancelTimer() {
        this.setProgramTime(null);
    }


    public void runProgram() {
        if (isConnectionStatus()){
            Calendar now = Calendar.getInstance();
            boolean time = false;
            if (programTime !=null)
                time = now.getTimeInMillis()/1000 == programTime.getTimeInMillis()/1000;
            if (programAction && time ){
                System.out.println("RunProgram -> Smart Plug - " + this.getAlias());
                turnOn();
                setProgramTime(null);
            }else if (!programAction && time){
                System.out.println("RunProgram -> Smart Plug - " + this.getAlias());
                turnOff();
                setProgramTime(null);
            }

        }
    }


    public boolean shutdownObject() {
        if (this.isConnectionStatus()){
            if (this.isStatus()){
                smartObjectToString();
                turnOff();
                return true;
            }
        }
        return false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        this.programAction = !status;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean isProgramAction() {
        return programAction;
    }

    public String getClassNameAsString(){
        return "SmartPlug";
    }
}
