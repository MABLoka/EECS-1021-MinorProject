package MinorProject;
import org.firmata4j.IODevice;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import java.io.IOException;
public class ButtonListener implements IODeviceEventListener {
    private final Pin buttonPin;
    private final Pin pump;
    private final IODevice arduino;
    // constructor
    ButtonListener(Pin Pump, Pin buttonPin, IODevice A) {
        this.buttonPin = buttonPin;
        this.pump = Pump;
        this.arduino = A;
    }

    @Override
    public void onStart(IOEvent event) {

    }

    @Override
    public void onStop(IOEvent event) {

    }

    @Override
    public void onPinChange(IOEvent event) {
        // Return right away if the even isn't from the Button.
        if (event.getPin().getIndex() != buttonPin.getIndex()) {
            return;
        }
        try {
            pump.setValue(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    @Override
    public void onMessageReceive(IOEvent event, String message) {

    }
}