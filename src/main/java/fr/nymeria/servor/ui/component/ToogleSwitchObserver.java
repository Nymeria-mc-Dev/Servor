package fr.nymeria.servor.ui.component;

import java.util.Observable;
import java.util.Observer;

public class ToogleSwitchObserver implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof ToogleSwitch) {
            ToogleSwitch observedObject = (ToogleSwitch) observable;
            boolean newValue = observedObject.isPowered();
            System.out.println("Value changed to: " + newValue);
        }
    }
}
