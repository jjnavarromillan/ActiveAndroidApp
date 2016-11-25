package com.example.proharvesting.activeandroidapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by proharvesting on 11/25/2016.
 */
@Table(name="Position")
public class Position extends Model {

    @Column(name="PositionName")
    public String PositionName;

    public static List<Position> getAllPositions(){
        return new Select().from(Position.class).execute();
    }



}
