package com.example.jinyoungbang.jisocoffee;

import android.widget.Adapter;

/**
 * Created by JinyoungBang on 2017-09-19.
 */

public class MenuItem {

    private String ItemName;
    private String ItemSize;
    private String ItemNum;

    public void setItemName(String Name){
        ItemName = Name ;
    }

    public String getItemName(){
        return ItemName;
    }

    public void setItemSize(String Size){
        ItemSize = Size;
    }

    public String getItemSize(){
        return ItemSize;
    }


    public void setItemNum(String Num){
        ItemNum = Num;
    }

    public String getItemNum(){
        return ItemNum;
    }
}
