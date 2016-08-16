package weather.newer.com.servicedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //明确在不同的活动中都可以绑定服务
     //   bindService()
    }

    @Override
    protected void onStop() {
        super.onStop();
       // unbindService();
    }
}
