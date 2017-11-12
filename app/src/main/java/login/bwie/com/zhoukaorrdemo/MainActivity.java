package login.bwie.com.zhoukaorrdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.but_login)
    Button butLogin;
    @InjectView(R.id.but_zhuce)
    Button butZhuce;
    @InjectView(R.id.et01)
    EditText et01;
    @InjectView(R.id.et02)
    EditText et02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    @OnClick({R.id.but_login, R.id.but_zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_login:
                String text = et01.getText().toString() ;
                if(TextUtils.isEmpty(text)){
                    Toast.makeText(MainActivity.this, "请您注册账号", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent2 = new Intent(MainActivity.this, ThreeActivity.class);
                    startActivity(intent2);
                }

                break;
            case R.id.but_zhuce:
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
