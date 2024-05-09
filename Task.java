package MinorProject;

import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.TimerTask;

public class Task extends TimerTask {

    private final Pin moistsensor;
    private final Pin pump;
    private final SSD1306 display;

    public Task(Pin MoistureSensor, Pin Pump, SSD1306 Display) {
        // Assigning variables to the pins and display
        this.moistsensor = MoistureSensor;
        this.pump = Pump;
        this.display = Display;
    }
    @Override
    public void run(){
        double moisturereadingV = moistsensor.getValue();
        System.out.println("Moisture level (V):"+moisturereadingV);
        String soilstate = null;
        String pumpstate = null;
        double thereshold = 600;
        if(moisturereadingV>thereshold){
            try {
                pump.setValue(1);
                soilstate = "Soil is Dry";
                pumpstate = "Pump is on";
            }catch (IOException e){
                throw new RuntimeException();
            }
        }else if (moisturereadingV<thereshold){
            try {
                pump.setValue(0);
                soilstate = "Soil is wet";
                pumpstate = "Pump is off";
            }catch (IOException e){
                throw new RuntimeException();
            }
        }else {
            try {
                pump.setValue(0);
            } catch (IOException e) {
                System.out.println("Error?");
            }
        }
        display.getCanvas().setTextsize(1);
        display.getCanvas().drawString(0, 0, soilstate+"\n"+pumpstate);
        display.display();
        display.clear();
    }
    }

