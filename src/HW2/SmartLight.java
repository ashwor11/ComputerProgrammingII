package HW2;

import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable{

    private boolean hasLightTurned;
    private Calendar programTime;
    private boolean programAction;

    public SmartLight(String alias, String macId){
        this.setAlias(alias);
        this.setMacId(macId);
    }

    public void turnOnLight(){
        if (this.hasLightTurned){
            System.out.println("Smart Light - " + this.getAlias() + " has been already turned on");
        }else {
            setHasLightTurned(true);
            Calendar now = Calendar.getInstance();
            System.out.println("Smart Light - " + this.getAlias() +  " is turned on now (Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) + ")");
        }
    }

    public void turnOffLight(){
        if (!this.hasLightTurned){
            System.out.println("Smart Light - " + this.getAlias() + " has been already turned off");
        }else {
            setHasLightTurned(false);
            Calendar now = Calendar.getInstance();
            System.out.println("Smart Light - " + this.getAlias() +  " is turned off now (Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) + ")");
        }
    }




    @Override
    public void onLeave() {
        if (isConnectionStatus()){
            System.out.println("On Leave -> Smart Light - " + this.getAlias());
            turnOffLight();
        }

    }

    @Override
    public void onCome() {
        if (isConnectionStatus()){
            System.out.println("On Come -> Smart Light - " + this.getAlias());
            turnOnLight();
        }
    }

    @Override
    public void setTimer(int seconds) {
        if (isConnectionStatus()){
            Calendar now = Calendar.getInstance();
            programTime = now;
            programTime.add(Calendar.SECOND,seconds);
            if (hasLightTurned){
                System.out.println("Smart light - " + this.getAlias() + " will be turned off " + seconds + " seconds later! " + "(Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) +")");
            }else {
                System.out.println("Smart light - " + this.getAlias() + " will be turned on " + seconds + " seconds later! " + "(Current time: " + now.get(Calendar.HOUR_OF_DAY) +":" + now.get(Calendar.MINUTE) +":" + now.get(Calendar.SECOND) +")");

            }
        }

    }

    @Override
    public void cancelTimer() {
        if (isConnectionStatus()){
             programTime = null;
        }

    }

    @Override
    public void runProgram() {
        if (isConnectionStatus()){
            Calendar now = Calendar.getInstance();
            boolean time = false;
            if (programTime !=null)
                time = now.getTimeInMillis()/1000 == programTime.getTimeInMillis()/1000;
            if (programAction && time){
                System.out.println("RunProgram -> Smart Light - " + this.getAlias());
                turnOnLight();
                setProgramTime(null);
            }else if (!programAction && time){
                System.out.println("RunProgram -> Smart Light - " + this.getAlias());
                turnOffLight();
                setProgramTime(null);
            }

        }
    }

    @Override
    public boolean testObject() {
        if (this.isConnectionStatus()){
            System.out.println("Test is starting for SmartLight");
            smartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
            return true;
        }
        return false;
    }

    @Override
    public boolean shutdownObject() {
        if (this.isConnectionStatus()){
            smartObjectToString();
            turnOffLight();
        }
        return false;
    }

    public boolean isHasLightTurned() {
        return hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
        this.programAction = !hasLightTurned;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

}
