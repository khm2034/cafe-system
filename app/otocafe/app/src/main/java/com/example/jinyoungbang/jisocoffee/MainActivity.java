package com.example.jinyoungbang.jisocoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent3 = getIntent();
        final String userNum = intent3.getStringExtra("userNum");


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    //JSONObject jsonResponse = new JSONObject(response);
                    Log.d("order", "1");
                    JSONArray jsonArray = new JSONArray(response);
                    Log.d("order", response);
                    Log.d("order", jsonArray.toString());
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonResponse = jsonArray.getJSONObject(i);

                        MypageActivity.waitNum = Integer.parseInt(jsonResponse.getString("wait"));
                        MypageActivity.total = Integer.parseInt(jsonResponse.getString("total"));
                        MypageActivity.orderNum = Integer.parseInt(jsonResponse.getString("orderNum"));

                        String tmp = jsonResponse.getString("fullMenu");
                        MypageActivity.menu = tmp.split(",");

                        tmp = jsonResponse.getString("count");
                        MypageActivity.count = tmp.split(",");

                        tmp = jsonResponse.getString("size");
                        MypageActivity.size = tmp.split(",");

                        tmp = jsonResponse.getString("date");
                        MypageActivity.date = tmp;

                        MypageActivity.isOrder = true;

                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };

        MypageRequest mypageRequest = new MypageRequest(userNum, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(mypageRequest);


        Button menuButton = (Button) findViewById(R.id.menuButton);

        Button seatButton = (Button) findViewById(R.id.seatButton);






        seatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,SeatActivity.class);
                intent1.putExtra("userNum",userNum);
                startActivity(intent1);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                intent.putExtra("userNum",userNum);
                startActivity(intent);
            }
        });

       Button mypagebutton = (Button) findViewById(R.id.mypage);
        mypagebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MypageActivity.class);
                intent2.putExtra("userNum",userNum);
                startActivity(intent2);
            }
        });

    }
}
