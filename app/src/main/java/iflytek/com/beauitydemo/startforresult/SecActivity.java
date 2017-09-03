package iflytek.com.beauitydemo.startforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import iflytek.com.beauitydemo.R;

public class SecActivity extends AppCompatActivity {

    EditText editText;
    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        editText = (EditText) findViewById(R.id.sec_edit);
        backBtn = (Button)findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("msg", msg);
                setResult(1,intent);
                finish();
            }
        });
    }
}
