package com.shenxm.withweather.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shenxm.withweather.R;
import com.shenxm.withweather.util.statusbar.StatusBarUtil;

/**
 * Created by SHEN XIAOMING on 2016/9/24.
 */
public class FirstActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        getWindow().setEnterTransition(new Fade());
//        getWindow().setExitTransition(new Fade());
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_first);
        StatusBarUtil.setTranslucent(FirstActivity.this);

        // 进入跳转页面，暂停2秒
        toMainActivity();
    }

    /**
     * 异步任务实现
     */
    private void toMainActivity() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(FirstActivity.this).toBundle());
                FirstActivity.this.finish();
            }
        }.execute();
    }
}
