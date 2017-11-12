package login.bwie.com.zhoukaorrdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import login.bwie.com.zhoukaorrdemo.Adapter.MyBaseAdapter;
import login.bwie.com.zhoukaorrdemo.bean.JsonBean;

public class ThreeActivity extends AppCompatActivity {
    private ListView list_view;
    private List<JsonBean.NewslistBean> list=new ArrayList<>();
    private MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        list_view = (ListView) findViewById(R.id.list_view);
        //获取网络数据
        getDataNet();

    }

    private void getDataNet() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>(){

            @Override
            protected String doInBackground(Void... voids) {
                String path="https://api.tianapi.com/wxnew/?key=8d6e3228d25298f13af4fc40ce6c9679&num=10";
                try {
                    URL url = new URL(path);
                    HttpURLConnection conection= (HttpURLConnection) url.openConnection();
                    conection.setRequestMethod("GET");
                    conection.setConnectTimeout(5000);
                    conection.setReadTimeout(5000);
                    int responseCode = conection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = conection.getInputStream();
                        //字节转成字符串
                        String json=getStreamToString(inputStream,"utf-8");
                        return json;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String json) {
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(json, JsonBean.class);

                list.addAll(jsonBean.getNewslist());

                Log.i("list===========",list.toString());
                //设置适配器
                getAdapter();


            }
        };
        asyncTask.execute();
    }

    private void getAdapter() {
        if (adapter==null){
            adapter = new MyBaseAdapter(ThreeActivity.this,list);
            list_view.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }

    }
    private String getStreamToString(InputStream inputStream, String charset) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String string=null;
            while ((string=bufferedReader.readLine())!=null){
                stringBuilder.append(string);

            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}

