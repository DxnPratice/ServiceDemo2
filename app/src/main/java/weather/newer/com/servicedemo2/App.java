package weather.newer.com.servicedemo2;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

/**
 *
 * 应用程序的起点和入口
 * Created by windows on 2016/8/15.
 */
public class App  extends Application {
    private static final String TAG ="app" ;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        Log.d(TAG, "onCreate");
        //启动服务
        startService(new Intent(this,LogService.class));
    }
}
