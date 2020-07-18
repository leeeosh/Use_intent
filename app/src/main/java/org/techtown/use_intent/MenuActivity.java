package org.techtown.use_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");  //부가 데이터, intent를 통해 부가데이터를 다른 activity로 전달 할 수 있다.
                setResult(200, intent); //200이 응답코드로 돌아갈 때 200이 main_activity에 전달 된다. 이 코드를 통해 intent와 intent에 실은 부가데이터를 전달 할  수 있다.
                finish(); //현재 이 화면이 없어진다, 안드로이드에서 새 화면을 띄우면 기존 화면은 밑에 깔려 있게 되므로 없애면 기존 화면 나온다.
            }
        });
    }


}