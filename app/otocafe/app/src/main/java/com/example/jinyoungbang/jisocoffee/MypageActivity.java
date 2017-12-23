package com.example.jinyoungbang.jisocoffee;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.InterpolatorRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MypageActivity extends AppCompatActivity {

    public static int orderNum;
    public static int waitNum;
    public static int total;
    public static String[] menu;
    public static String[] count;
    public static String[] size;
    public static String date;
    public static boolean isOrder = false;

    private TimerTask timerTask;
    private Timer timer = new Timer();
    private int tmpWaitNum;
    TextView waitText;

    ListView listView;

    MenuAdapter menuAdapter;



    /*private Vibrator vibrator;
    private long[] pattern = {0, 2000, 1000, 2000, 1000, 2000};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Intent intent4 = getIntent();
        final String userNum = intent4.getStringExtra("userNum");

        //vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

       //TextView welcomemessage = (TextView) findViewById(R.id.idView);
       // String message =userId2 + "님의 페이지";
        //welcomemessage.setText(message);

        // ui 구성!!

        waitText = (TextView) findViewById(R.id.waitNum);
        tmpWaitNum = waitNum;

        listView = (ListView) findViewById(R.id.MenuList);

        if(isOrder){
            TextView dateText = (TextView) findViewById(R.id.dateText);
            dateText.setText(date);

            TextView totalText = (TextView) findViewById(R.id.totalText);
            totalText.setText(String.valueOf(total));
            menuAdapter = new MenuAdapter();

            for(int i=0 ; i<menu.length-1; i++){
                menuAdapter.addItem(menu[i], size[i], count[i]);
            }

            listView.setAdapter(menuAdapter);


            waitText.setText(String.valueOf(tmpWaitNum));
        }

        else{
            TextView dateText = (TextView) findViewById(R.id.dateText);
            dateText.setText("");

            TextView totalText = (TextView) findViewById(R.id.totalText);
            totalText.setText("");


            menuAdapter = new MenuAdapter();
            listView.setAdapter(menuAdapter);
            waitText.setText(String.valueOf(tmpWaitNum));
        }

        final Handler handler = new Handler(){
            public void handleMessage(Message msg){
                waitText.setText(String.valueOf(tmpWaitNum));
                Log.d("timer2", "waitNum 수정 : " + waitNum);
            }
        };

        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.d("timer2", "waitNum : " + waitNum);
                if(waitNum != tmpWaitNum){
                    tmpWaitNum = waitNum;

                    // 대기번호 UI 수정!
                   // waitText.setText(String.valueOf(tmpWaitNum));
                    Message msg = handler.obtainMessage();
                    handler.sendMessage(msg);
                }
            }
        };

        timer.schedule(timerTask, 0, 1000);


/*
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

                        waitNum = Integer.parseInt(jsonResponse.getString("wait"));
                        total = Integer.parseInt(jsonResponse.getString("total"));
                        orderNum = Integer.parseInt(jsonResponse.getString("orderNum"));
                        Log.d("timer", String.valueOf(orderNum));

                        String tmp = jsonResponse.getString("fullMenu");
                        menu = tmp.split(",");

                        tmp = jsonResponse.getString("count");
                        count = tmp.split(",");

                        tmp = jsonResponse.getString("size");
                        size = tmp.split(",");

                        tmp = jsonResponse.getString("date");
                        date = tmp.split(",");

                        isOrder = true;

                        // 여기서 한번 주문내역 설정!;

                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };

        MypageRequest mypageRequest = new MypageRequest(userId2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MypageActivity.this);
        queue.add(mypageRequest);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isOrder) {
                    timerTask = new TimerTask() {
                        @Override
                        public void run() {

                            Response.Listener<String> responseListener2 = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonResponse = jsonArray.getJSONObject(i);
                                            switch (Integer.parseInt(jsonResponse.getString("complete"))) {
                                                case 0:
                                                    int wait = Integer.parseInt(jsonResponse.getString("wait"));
                                                    Log.d("timer", "wait : " + wait);
                                                    //
                                                    break;
                                                case 1:
                                                    // 완성!! 진동울림!!
                                                    vibrator.vibrate(pattern, -1);
                                                    Toast.makeText(getApplicationContext(), "주문하신 제품이 완성되었습니다.", Toast.LENGTH_LONG).show();
                                                    Log.d("timer", "완성");
                                                    cancel();
                                                    break;
                                                case 2:
                                                    // 취소!!!
                                                    Log.d("timer", "취소");
                                                    cancel();
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            };

                            MypageRequest mypageRequest = new MypageRequest(orderNum, responseListener2);
                            RequestQueue queue = Volley.newRequestQueue(MypageActivity.this);
                            queue.add(mypageRequest);
                        }
                    };
                    timer.schedule(timerTask, 0, 3000);
                }
            }
        },2000);
*/
    }

    public static void init(){
        orderNum = 0;
        waitNum = 0;
        total = 0;
        menu = null;
        count = null;
        size = null;
        date = null;
        isOrder = false;
    }

}
