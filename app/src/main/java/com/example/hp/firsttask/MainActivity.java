package com.example.hp.firsttask;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_login;
    private Button button_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_login=(Button)findViewById(R.id.login);
        button_hint=(Button)findViewById(R.id.hint);
        button_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框")//显示的消息内容
                        .setTitle("对话框");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.show();
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view1=inflater.inflate(R.layout.login_dialog,null);
                builder.setView(view1).setTitle("Login")
                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            EditText editText=(EditText) view1.findViewById(R.id.editTextUserId);
                            EditText editText1=(EditText) view1.findViewById(R.id.editTextPwd);
                            // String inputText1 = editText1.getText().toString();
                            // String inputText = editText.getText().toString();
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String inputText1 = editText1.getText().toString();
                                String inputText = editText.getText().toString();
                                //   System.out.println(inputText);
                                if(inputText!=null){
                                    if(inputText.equals("abc")){
                                        if(inputText1.equals("123")){
                                            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this,"用户名错误",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }

                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.finish();
                            }
                        });
                builder.show();
            }
        });
    }
}
