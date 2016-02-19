/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author WilliamPC
 */
public class Timer {
    private long startTime;
    private long finishTime;
    private long timeElapsed;
    
    public Timer(long sTime, long fTime){
        startTime = sTime;
        finishTime = fTime;
        
    }
    
    public long MeasureTimeElapsed(){
        timeElapsed = finishTime - startTime;
        
        return timeElapsed;
    }
    
}
