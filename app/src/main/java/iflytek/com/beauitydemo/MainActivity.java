package iflytek.com.beauitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import iflytek.com.beauitydemo.startforresult.FirstActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyView myView;
    private Button button,buttonFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.my_view);
        button = (Button)findViewById(R.id.clear);
        buttonFirst = (Button)findViewById(R.id.goto_First);
        button.setOnClickListener(this);
        buttonFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                myView.clear();
                break;
            case R.id.goto_First:
                startActivity(new Intent(this, FirstActivity.class));
                finish();
                break;
        }
    }
}
