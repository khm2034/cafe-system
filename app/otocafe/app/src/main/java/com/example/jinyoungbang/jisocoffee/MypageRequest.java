package com.example.jinyoungbang.jisocoffee;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by JinyoungBang on 2017-09-16.
 */

public class MypageRequest extends StringRequest {
    final static private String URL = "http://52.79.219.34/userOrderList.php";


    private Map<String,String> parameters;

    public MypageRequest(String userNum, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        Log.d("order", "2");
        parameters = new HashMap<>();
        parameters.put("userNum",userNum);
    }

    public MypageRequest(int orderNum, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id","");
        parameters.put("orderNum",String.valueOf(orderNum));
    }

    @Override
    public Map<String,String> getParams() {
        return parameters;
    }
}
