package jp.co.test.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "jp.co.test.myfirstapp.MESSAGE";
    public final static int REQUSET_CODE_COMPANY_INFO = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ActionBarを隠す
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        //会社情報ボタンをクリック
        Button infoBtn = (Button) findViewById(R.id.btn_company_info);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CompanyInfoActivity.class);
                startActivityForResult(intent, REQUSET_CODE_COMPANY_INFO);
            }
        });

        //地図ボタンをクリック

        //サービスボタンをクリック
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        super.onActivityResult(requestCode, resultCode, Data);

        if (requestCode == REQUSET_CODE_COMPANY_INFO) {
            Toast toast = Toast.makeText(getBaseContext(),
                    "onActivityResultのメソッド呼ばれる. Code　：" + requestCode
                            + ", Result　：" + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if (resultCode == RESULT_OK) {
                String name = Data.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(),
                        "受け取った name　：" + name, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.txt_email);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
