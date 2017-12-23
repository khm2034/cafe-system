package com.example.jinyoungbang.jisocoffee;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.jinyoungbang.jisocoffee.Fragment.OneFragment;
import com.example.jinyoungbang.jisocoffee.Fragment.ThreeFragment;
import com.example.jinyoungbang.jisocoffee.Fragment.TwoFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MenuActivity extends AppCompatActivity {
    private WebView mWebView;
    private String userNum;

    private TimerTask timerTask;
    private Timer timer = new Timer(true);

    private Vibrator vibrator;
    private long[] pattern = {0, 2000, 1000, 2000, 1000, 2000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        userNum = intent.getStringExtra("userNum");


        mWebView = (WebView) findViewById(R.id.webview);

        mWebView.getSettings().setJavaScriptEnabled(true);
        // 구글홈페이지 지정
        mWebView.loadUrl("http://52.79.219.34:8080/jspweb/order");
        // WebViewClient 지정

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {


                if(newProgress >= 100){
                    mWebView.loadUrl("javascript:setNum('" + userNum.toString()  +"')");
                }
            }
        });

        EditText userId = (EditText) findViewById(R.id.idText);
        mWebView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

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

        final MypageRequest mypageRequest = new MypageRequest(userNum, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MenuActivity.this);
        queue.add(mypageRequest);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(MypageActivity.isOrder) {
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
                                                    MypageActivity.waitNum = wait;
                                                    break;
                                                case 1:
                                                    // 완성!! 진동울림!!
                                                    Log.d("timer", "진동시작");
                                                    vibrator.vibrate(pattern, -1);
                                                    //Log.d("timer", "진동끝);
                                                    Toast.makeText(getApplicationContext(), "주문하신 제품이 완성되었습니다.", Toast.LENGTH_LONG).show();
                                                    MypageActivity.init();
                                                    Log.d("timer", "완성");
                                                    cancel();
                                                    break;
                                                case 2:
                                                    // 취소!!!
                                                    MypageActivity.init();
                                                    Toast.makeText(getApplicationContext(), "주문하신 제품이 취소되었습니다.", Toast.LENGTH_LONG).show();
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

                            MypageRequest mypageRequest = new MypageRequest(MypageActivity.orderNum, responseListener2);
                            RequestQueue queue = Volley.newRequestQueue(MenuActivity.this);
                            queue.add(mypageRequest);
                        }
                    };
                    timer.schedule(timerTask, 0, 3000);
                }
            }
        },2000);
    }
}