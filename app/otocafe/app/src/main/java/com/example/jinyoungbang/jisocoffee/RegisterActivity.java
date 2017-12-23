package com.example.jinyoungbang.jisocoffee;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private String userPhone;
    private  String userID;
    private String userPasswrod;
    private String userGender;
    private String userName;
    private String userEmail;
    private AlertDialog dialog;
    private boolean validate = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final Calendar cal = Calendar.getInstance();
        final String regDate = String.valueOf(cal.get(Calendar.YEAR))+"-"
                +String.valueOf(cal.get(Calendar.MONTH)+1)+"-"
                +String.valueOf(cal.get(Calendar.DATE)+1);



        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText emailText = (EditText) findViewById(R.id.emailText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final EditText numberText = (EditText) findViewById(R.id.numberText);
        final EditText birthText = (EditText) findViewById(R.id.birthtext);

        Button cancel = (Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        RadioGroup genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        int genderGroupID = genderGroup.getCheckedRadioButtonId();
        userGender = ((RadioButton)findViewById(genderGroupID)).getText().toString();

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton genderButton = (RadioButton) findViewById(i);
                userGender = genderButton.getText().toString();
            }
        });

        final Button validateButton = (Button) findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                if(validate)
                {
                    return;
                }

                if(userID.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("아이디는 빈 칸일 수 없습니다.")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("사용할수 있는 아이디입니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                idText.setEnabled(false);
                                validate = true;
                                idText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                validateButton.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("사용할수 없는 아이디입니다.")
                                        .setNegativeButton("확인",null)
                                        .create();
                                dialog.show();
                            }

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });


        birthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year;
                int month;
                int day;
                if(birthText.getText().toString().equals("")){
                    year = cal.get(Calendar.YEAR);
                    month = cal.get(Calendar.MONTH);
                    day = cal.get(Calendar.DATE);
                }else{
                    String[] tmp = birthText.getText().toString().split("-");
                    year = Integer.parseInt(tmp[0]);
                    month = Integer.parseInt(tmp[1])-1;
                    day = Integer.parseInt(tmp[2]);
                }

                new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date="";
                        date += year;
                        date += "-";
                        if(month+1 < 10)
                            date += "0";
                        date+=(month+1);
                        date += "-";
                        if(dayOfMonth<10)
                            date += "0";
                        date += dayOfMonth;
                        birthText.setText(date);
                    }
                }, year, month, day).show();
            }
        });
        birthText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int year;
                int month;
                int day;
                if(birthText.getText().toString().equals("")){
                    year = cal.get(Calendar.YEAR);
                    month = cal.get(Calendar.MONTH);
                    day = cal.get(Calendar.DATE);
                }else{
                    String[] tmp = birthText.getText().toString().split("-");
                    year = Integer.parseInt(tmp[0]);
                    month = Integer.parseInt(tmp[1]);
                    day = Integer.parseInt(tmp[2]);
                }

                new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date="";
                        date += year;
                        date += "-";
                        if(month+1 < 10)
                            date += "0";
                        date+=(month+1);
                        date += "-";
                        if(dayOfMonth<10)
                            date += "0";
                        date += dayOfMonth;
                        birthText.setText(date);
                    }
                }, year, month, day).show();
            }
        });

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String userEmail = emailText.getText().toString();
                String userName = nameText.getText().toString();
                String userPhone = numberText.getText().toString();
                String userbirth = birthText.getText().toString();
                String datereg = regDate.toString();


                if(!validate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("먼저 중복체크를 해주세요")
                            .setNegativeButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }

                if(userID.equals("") || userPassword.equals("") || userEmail.equals("") || userGender.equals("") ||userbirth.equals("") ||userName.equals("") ||userPhone.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("빈칸 없이 입력해주세요")
                            .setNegativeButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            Log.d("test", jsonResponse.getString("num") + ", " +
                                    jsonResponse.getString("num") + ", " +
                                    jsonResponse.getString("regDate") + ", " +
                                    jsonResponse.getString("userID") + ", " +
                                    jsonResponse.getString("userPassword") + ", " +
                                    jsonResponse.getString("userGender") + ", " +
                                    jsonResponse.getString("userName") + ", " +
                                    jsonResponse.getString("userEmail") + ", " +
                                    jsonResponse.getString("userPhone") + ", " +
                                    jsonResponse.getString("userbirth"));
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("회원등록에 성공하였습니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                finish();
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("회원등록에 실패하였습니다.")
                                        .setNegativeButton("확인",null)
                                        .create();
                                dialog.show();
                            }

                        }
                        catch(Exception e){
                            e.printStackTrace();

                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(regDate,userID,userPassword,userGender,userName,userbirth,userEmail,userPhone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
}
