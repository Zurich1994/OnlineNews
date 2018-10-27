package slidingmenu;

import jerome.news.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class  Collection extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);
        ImageButton bt1=(ImageButton)findViewById(R.id.back1);//返回功能界面
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }





}

