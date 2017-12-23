package com.example.jinyoungbang.jisocoffee;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JinyoungBang on 2017-09-03.
 */

public class RegisterRequest extends StringRequest{
    final static private String URL = "http://52.79.219.34/UserRegister3.php";

    private Map<String, String> parameters;

    public RegisterRequest(String regDate,String userID, String userPassword, String userGender, String userName,String userbirth, String userEmail, String userPhone, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);


        parameters = new HashMap<>();
        try {
            parameters.put("regDate", URLEncoder.encode(regDate, "utf-8"));
            parameters.put("userID", userID);
            parameters.put("userPassword", userPassword);
            parameters.put("userGender",userGender);
            parameters.put("userName", userName);
            parameters.put("userEmail", userEmail);
            parameters.put("userPhone", userPhone);
            parameters.put("userbirth", userbirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }

}
