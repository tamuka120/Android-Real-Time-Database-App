package comtamuka120.httpsgithub.final_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {

//    private EditText txtDob;
//    private EditText txtUser;
    private EditText txtEmail;
    private EditText txtPass;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        txtEmail = findViewById(R.id.email_reg_editText);
        txtPass = findViewById(R.id.pass_reg_editText);
//        txtDob = findViewById(R.id.dob_reg_editText);
//        txtUser = findViewById(R.id.user_reg_editText);


        firebaseAuth = FirebaseAuth.getInstance();
        }

    public void reg_btnClick(View v) {

        if(txtEmail.getText().toString().equals("") || txtPass.getText().toString().equals("")){
            Toast.makeText(registration.this, "Blank field", Toast.LENGTH_LONG).show();



        } else {


            final ProgressDialog progressDialog = ProgressDialog.show(registration.this, "Please Wait...", "Processing", true);
            (firebaseAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtPass.getText().toString()))
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                Toast.makeText(registration.this, "Registration Successful!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(registration.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Log.e("ERROR", task.getException().toString());
                                Toast.makeText(registration.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                            }


                        }
                    });

        }

    }
}
