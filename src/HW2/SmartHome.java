package HW2;

import java.util.ArrayList;
import java.util.Arrays;

public class SmartHome {
    private ArrayList<SmartObject> smartObjectList = new ArrayList<SmartObject>();

    public SmartHome(){}

    public boolean addSmartObject(SmartObject smartObject){
        System.out.println("---------------------------------------------------------------------------\n" +
                "---------------------------------------------------------------------------\n" +
                "Adding new SmartObject\n" +
                "---------------------------------------------------------------------------");
        smartObjectList.add(smartObject);
        smartObject.connect("10.0.0." + 10 + smartObjectList.indexOf(smartObject));
        smartObject.testObject();
        return true;

    }

    public boolean removeSmartObject(SmartObject smartObject){
        return smartObjectList.remove(smartObject);
    }

    public void controlLocation(boolean onCome){

            System.out.println("---------------------------------------------------------------------------\n" +
                    "---------------------------------------------------------------------------\n" +
                    "LocationControl: OnCome\n" +
                    "---------------------------------------------------------------------------");

        for (SmartObject smartObject: smartObjectList){

            if (smartObject instanceof LocationControl ){
                if (onCome)
                    ((LocationControl) smartObject).onCome();
                else
                    ((LocationControl) smartObject).onLeave();
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay){
        System.out.println("---------------------------------------------------------------------------\n" +
                "---------------------------------------------------------------------------\n" +
                "MotionControl: HasMotion, isDay\n" +
                "---------------------------------------------------------------------------\n");
        for (SmartObject smartObject: smartObjectList){
            if (smartObject instanceof MotionControl){
                ((MotionControl) smartObject).controlMotion(hasMotion,isDay);
            }
        }

    }

    public void controlProgrammable(){
        System.out.println("---------------------------------------------------------------------------\n" +
                "---------------------------------------------------------------------------\n" +
                "Programmable: runProgram\n" +
                "---------------------------------------------------------------------------");
        for (SmartObject smartObject: smartObjectList){
            if (smartObject instanceof Programmable){
                ((Programmable) smartObject).runProgram();
            }
        }
    }

    public void controlTimer(int seconds){
        System.out.println("---------------------------------------------------------------------------\n" +
                "---------------------------------------------------------------------------\n" +
                "Programmable: Timer = " + seconds + " seconds\n" +
                "---------------------------------------------------------------------------");

        for (SmartObject smartObject: smartObjectList){
            if (smartObject instanceof Programmable){
                if (seconds == 0){
                    ((Programmable) smartObject).cancelTimer();
                    continue;
                }
                ((Programmable) smartObject).setTimer(seconds);
            }
        }
    }

    public void controlTimerRandomly(){
        System.out.println("---------------------------------------------------------------------------\n" +
                "---------------------------------------------------------------------------\n" +
                "Programmable: Timer = 5 or 10 seconds randomly\n" +
                "---------------------------------------------------------------------------\n");

        for (SmartObject smartObject: smartObjectList){
            if (smartObject instanceof Programmable){
                int seconds = (int)(Math.random() * 2 + 1) * 5;
                if (seconds == 0){
                    ((Programmable) smartObject).cancelTimer();
                    continue;
                }
                ((Programmable) smartObject).setTimer(seconds);
            }
        }
    }

    public void sortCameras(){
        System.out.println("---------------------------------------------------------------------------\n" +
                "---------------------------------------------------------------------------\n" +
                "Sort Smart Cameras\n" +
                "---------------------------------------------------------------------------");
        ArrayList<SmartCamera> cameras = new ArrayList<SmartCamera>();

        for (SmartObject smartObject: smartObjectList){
            if (smartObject instanceof Comparable){
                cameras.add((SmartCamera) smartObject);
            }
        }
        Object[] last = cameras.toArray();
        Arrays.sort(last);
        for (Object object: last){
            System.out.println(object.toString());
        }

    }


}
