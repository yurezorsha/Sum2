package yurez_orsha.sum2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        View.OnClickListener onClickListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button3:
                        Intent intent2 = new Intent(MenuActivity.this, LengthActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.button4:
                        Intent intent3 = new Intent(MenuActivity.this, TimeActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.button5:
                        Intent intent4 = new Intent(MenuActivity.this, AboutActivity.class);
                        startActivity(intent4);

                        break;
                    case R.id.button6:
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Author: Asinousky Yury\n Mail: yurez_orsha@mail.ru", Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    default:
                        break;
                }
            }
        };
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);

    }


}
