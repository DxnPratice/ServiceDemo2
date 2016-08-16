package weather.newer.com.servicedemo2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    LogService Myservice;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        textview= (TextView) findViewById(R.id.textview);

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");

        super.onStart();
        bindService(new Intent(this,LogService.class),
        conn,
        BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
        unbindService(conn);
    }
    //服务连接器(服务监视器）
    ServiceConnection conn=new ServiceConnection() {
        /**
         *
         * 绑定后，获得服务的引用
         * @param name       ComponentName
         * @param service   IBinder
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获得引用
          LogService.LogServiceBinder   binder= (LogService.LogServiceBinder) service;
           Myservice=binder.getService();
            Log.d("     ", "onServiceConnected");
            //绑定服务
            String now=Myservice.getNow().toString();

        }

        /**
         *
         * 服务意外结束时执行
         * @param name
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("     ", "onServiceDisconnected");
            Myservice=null;
        }
    };

    public void doUpdate(View view) {
        textview.setText(Myservice.getNow());
    }
}
