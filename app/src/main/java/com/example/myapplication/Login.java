package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.service.UserService;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final LinearLayout layout = findViewById(R.id.linearLayout);
        final LinearLayout layout2 = findViewById(R.id.linearLayout2);
        final LinearLayout layout3 = findViewById(R.id.linearLayout3);
        final LinearLayout layout4 = findViewById(R.id.linearLayout4);
        final Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);
        final Button login = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button register = findViewById(R.id.button5);
        final Button button6 = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    button.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    login.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                layout2.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout3.setVisibility(View.VISIBLE);
                layout4.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                register.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout3.setVisibility(View.GONE);
                layout4.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                register.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
            }
        });
        //登录
        final EditText username = findViewById(R.id.editText);
        final EditText pwd = findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                System.out.println(name);
                String pass=pwd.getText().toString();
                System.out.println(pass);
                Log.i("TAG",name+"_"+pass);
                UserService userService=new UserService(Login.this);
                boolean flag=userService.login(name,pass);
                if (flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(Login.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,Game.class);
                    startActivity(intent);
                }else{
                    Log.i("TAG","登录失败");
                    Toast.makeText(Login.this, "登录失败", Toast.LENGTH_LONG).show();
                }
            }
        });
        //注册
        final EditText rusername = findViewById(R.id.editText3);
        final EditText rpwd = findViewById(R.id.editText4);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = rusername.getText().toString().trim();
                String pwd = rpwd.getText().toString().trim();
                Log.i("TAG",name+"_"+pwd);
                UserService userService = new UserService(Login.this);
                User user = new User();
                user.setUsername(name);
                user.setPwd(pwd);
                userService.register(user);
                Toast.makeText(Login.this, "注册成功", Toast.LENGTH_LONG).show();
            }
        });
    }
}
