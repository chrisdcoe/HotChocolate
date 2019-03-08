package hotchocolate;

import java.util.concurrent.TimeUnit;

public class HotChocolate {

    public static final double tooHot = 185;
    public static final double tooCold = 160;

    public static void drinkHotChocolate(double cocoaTemp)
            throws TooHotException, TooColdException {
        if (cocoaTemp >= tooHot) {
            throw new TooHotException();
        } else if (cocoaTemp <= tooCold) {
            throw new TooColdException();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        double currentCocoaTemp = 270;
        boolean wrongTemp = true;
        while (wrongTemp) {
            try {
                System.out.println("Cocoa temperature: " + currentCocoaTemp);
                drinkHotChocolate(currentCocoaTemp);
                System.out.println("That cocoa was good!");
                wrongTemp = false;
            } catch (TooHotException e1) {
                System.out.println("Too hot. Waiting for cocoa to cool.");
                currentCocoaTemp -= 5;
                
            } catch (TooColdException e2) {
                System.out.println("Too cold. Warming up cocoa.");
                currentCocoaTemp += 5;
            } finally {
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }

}
