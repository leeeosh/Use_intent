package org.techtown.use_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);   //Menu_activity를 담고 있는 객체를 만든 것
                startActivityForResult(intent,101); //새로 띄운 화면으로부터 응답을 받는 코드, 이 101이란 숫자가 나중에 응답을 받을 때
                                                                //그대로 다시 돌아온다. 어떤 화면으로부터 온 응답인지 구분해 주기에 요청 코드에 해당


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {   //이 함수는 menu에서 main_activity로 돌아올 때 자동으로 호출 된다.
        //requsetCode에는 main_activity에서 보낸 101이 들어오고 resultCode에는 menu에서 쓴 200이 들어온다.
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){    //우리가 설정한 menu_activity에서 넘어왔음을 인지하는 것, 화면마다 다른 request code를 설정하면 구별해서 인지 가능
            if(data!=null){
                String name = data.getStringExtra("name");
                if(name != null){
                    Toast.makeText(this,"응답으로 받은 데이터 : "+ name, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}