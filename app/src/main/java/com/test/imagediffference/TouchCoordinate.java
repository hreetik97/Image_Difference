package com.test.imagediffference;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;


public class TouchCoordinate {
    float x,y;
    public TouchCoordinate(){

    }
    public TouchCoordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Map<Integer,TouchCoordinate> coordinateMap(){
        HashMap<Integer,TouchCoordinate>coordinateMap = new HashMap<Integer, TouchCoordinate>();
        coordinateMap.put(1,new TouchCoordinate(950f,600f));
        coordinateMap.put(2,new TouchCoordinate(1403f,813f));
        coordinateMap.put(3,new TouchCoordinate(1385f,120f));
        coordinateMap.put(4,new TouchCoordinate(126f,800f));
        coordinateMap.put(5,new TouchCoordinate(61f,376f));
        return coordinateMap;
    }
    public void iteration(){
        Map<Integer,TouchCoordinate> d= coordinateMap();
          for (int i=0; i<=d.size();i++){
                TouchCoordinate touchCoordinate=d.get(i);
                if (touchCoordinate.x==4){
                    Log.d("@shiva", "iteration:");
                }
          }
    }
}
