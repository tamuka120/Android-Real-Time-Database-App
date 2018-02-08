package comtamuka120.httpsgithub.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageButton imgbtn = (ImageButton) findViewById(R.id.imgbtn);
//        imgbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int_1 = new Intent(MainActivity.this, page_2.class);
//                startActivity(int_1);
//            }
//        });

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
         //create a list of items for the spinner.
        String[] items = new String[]{"Home", "Settings", "Games"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);



    }
}
