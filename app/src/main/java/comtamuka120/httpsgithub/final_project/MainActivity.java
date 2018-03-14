package comtamuka120.httpsgithub.final_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPass;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.login_user_ediText);
        txtPass = findViewById(R.id.pass_login_editText);
        firebaseAuth = FirebaseAuth.getInstance();
        }


    public void reg_button_loginClick(View v) {
        Intent  intent = new Intent(MainActivity.this, registration.class);
        startActivity(intent);
    }

    public void login_buttonClick(View v) {

        if(txtEmail.getText().toString().equals("") || txtPass.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Username or Password is Blank", Toast.LENGTH_LONG).show();



        } else {


            final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Please Wait...", "Processing", true);
            (firebaseAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtPass.getText().toString()))
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, blank_test.class);
                                intent.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                                startActivity(intent);
                            } else {
                                Log.e("ERROR", task.getException().toString());
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }

                        }
                    });
        }


    }
}
