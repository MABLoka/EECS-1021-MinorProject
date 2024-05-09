package MinorProject;
import java.util.HashMap;
import edu.princeton.cs.introcs.StdDraw;
import org.firmata4j.Pin;

import java.util.TimerTask;
public class Draw extends TimerTask{
    private final Pin moisturesensor;
    private int t;
    public Draw(Pin MoistureSensor, int time){
        this.moisturesensor = MoistureSensor;
        this.t = time;
    }
    @Override
    public void run(){
        HashMap<Integer, Long> data = new HashMap<>();
        var moistreadingV = moisturesensor.getValue();
        data.put(t, moistreadingV);
        StdDraw.show();
        t++;
        if(t==60){
            t=0;
            StdDraw.clear();
        }
        graphsetup();
        StdDraw.setPenColor(StdDraw.RED);
        data.forEach((xvalue,yvalue) -> StdDraw.text(xvalue,yvalue,"*"));
    }
    public static void graphsetup(){
        StdDraw.setXscale(-10,70);
        StdDraw.setYscale(-30,1200);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0,40,0,1024);  //Values upto 800
        StdDraw.line(0,40,60,40);//Values upto 60
        StdDraw.text(30,0,"[Time (Sec)]");
        StdDraw.text(5, 1060, "[Moisture Level (V)]");
        StdDraw.text(0,0,"0");
        StdDraw.text(60,0,"60");
        StdDraw.text(-3,1023,"5");
        StdDraw.text(-3,1023/2,"2.5");


    }
}

