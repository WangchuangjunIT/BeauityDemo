package iflytek.com.beauitydemo.startforresult;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import iflytek.com.beauitydemo.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, SecActivity.class);
                startActivityForResult(intent,3);
            }
        });

        findViewById(R.id.button_notify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(FirstActivity.this)
                        .setContentTitle("重要通知")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentText("该睡觉了该睡觉了该睡觉了该睡觉了");

                Notification notify = builder.build();
                manager.notify(1, notify);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String msg = data.getStringExtra("msg");
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(msg);
    }
}
