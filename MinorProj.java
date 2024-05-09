package MinorProject;

import edu.princeton.cs.introcs.StdDraw;
import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Timer;
public class MinorProj {
    public static void main(String[] args) throws IOException, InterruptedException{

        IODevice arduino = new FirmataDevice("COM3");
        //Start and initialize arduino board connection
        arduino.start();
        arduino.ensureInitializationIsDone();
        // Initialize OLED display
        I2CDevice i2cObject = arduino.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 display = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        display.init();

        Pin moist = arduino.getPin(14);// Pin A0
        Pin button = arduino.getPin(6);// Pin D6
        Pin pump = arduino.getPin(2);// Pin D2
        // set pin modes
        moist.setMode(Pin.Mode.ANALOG);
        button.setMode(Pin.Mode.INPUT);
        pump.setMode(Pin.Mode.OUTPUT);

        var task = new Task(moist, pump, display);
        new Timer().schedule(task,0,1000);

        int t = 0;// Variable used to time graph
        var draw = new Draw(moist, t);
        new Timer().schedule(draw,0,1000);// Updating the graph every sec
        //EventListener to turn of the program
        arduino.addEventListener(new ButtonListener(pump,button,arduino));
    }
}
