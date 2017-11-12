package login.bwie.com.zhoukaorrdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TwoActivity extends AppCompatActivity {

    @InjectView(R.id.but_textview)
    TextView butTextview;
    @InjectView(R.id.loginQQ)
    Button loginQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.but_textview, R.id.loginQQ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_textview:
                Intent intent=new Intent(TwoActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.loginQQ:
                Toast.makeText(TwoActivity.this, "注册成功可以QQ登录", Toast.LENGTH_SHORT).show();
                break;
                
        }
    }
}
