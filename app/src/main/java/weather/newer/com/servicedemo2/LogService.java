package weather.newer.com.servicedemo2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class LogService extends Service {
    private static final String TAG ="LogService ";
    LogThread thread;
    String now;
    public String getNow(){
        return now;
    }

    public LogService() {
    }

    /**
     *
     * 创建
     */
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        thread=new LogThread();
       // thread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new LogServiceBinder();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, " onDestroy");
        super.onDestroy();
        thread.isRunning=false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "  onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "  onRebind");
        super.onRebind(intent);
    }
    class LogServiceBinder extends Binder{
        /**
         *
         * 获得外部类的当前实例（服务对象）
         * @return
         */
        public LogService   getService(){
            return LogService.this;
        }
    }
    class LogThread extends Thread{
        volatile boolean isRunning=true;
        public void run(){
            super.run();
            while(isRunning){
            now=new Date().toLocaleString();
                Log.d("Date",now.toString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}
