package ayobaymak.com.myprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String developer = "Ayodeji";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton mailButton = (FloatingActionButton) findViewById(R.id.mailButton);
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setData(Uri.parse("mailto:"));
                Email.setType("text/plain");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"ayobaymak@gmail.com"});
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "HNG INTERN");

                if (Email.resolveActivity(getPackageManager()) !=null){
                    Email.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(Intent.createChooser(Email, "Email" + developer ));
                }
            }
        });
    }
}
