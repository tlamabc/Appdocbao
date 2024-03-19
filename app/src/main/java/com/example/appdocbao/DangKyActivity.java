package com.example.appdocbao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class DangKyActivity extends AppCompatActivity {
    EditText edtUserName, edtSDT, edtEmail, edtID;
    Button btnLogout, dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        FirebaseApp.initializeApp(this);
        addControls();
        xulyDK();
        dangnhap();
    }

    private void xulyDK() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtEmail.getText().toString().trim();
                String pass = edtID.getText().toString().trim();
                if (name.isEmpty() || pass.isEmpty()) {
                    return;
                }
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(name, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(DangKyActivity.this, LoginActivity.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(DangKyActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    private void dangnhap() {
              dangnhap.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                              Intent intent = new Intent(DangKyActivity.this, LoginActivity.class);
                               startActivity(intent);
                            finish();
                            }
     });
         }

    private void addControls() {
        dangnhap = findViewById(R.id.dangnhapp);
        edtUserName = findViewById(R.id.edtUserName);
        edtSDT = findViewById(R.id.edtSDT);
        edtEmail = findViewById(R.id.edtEmail);
        edtID = findViewById(R.id.edtID);
        btnLogout = findViewById(R.id.btnLogout);
    }
}