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
        
    
    public static long MeasureTimeElapsed(long startTime, long finishTime){
        long timeElapsed = finishTime - startTime;
        
        return timeElapsed;
    }
    
}
