package com.dgpays.firebaseauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dgpays.firebaseauthentication.databinding.ActivityCreateUserBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private ActivityCreateUserBinding binding;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setListener(this);
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_left);
    }


    @Override
    public void onClick(View view) {
        if (view == binding.btnCreateUser) {
            createNewUser();
        } else if (view == binding.btnLoginHere) {
            startActivity(new Intent(CreateUserActivity.this, MainActivity.class));
        }
    }

    public void createNewUser() {
        mAuth=FirebaseAuth.getInstance();
        String email = binding.emailAdress.getText().toString();
        String password = binding.password.getText().toString();
        if (TextUtils.isEmpty(email)) {
            showToast("Lütfen email adresinizi giriniz");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("Lütfen parolanızı giriniz");
            return;
        }
        if (password.length() < 6) {
            showToast("Parola en az 6 haneli olmalıdır");
            return;

        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            showToast("Yeni üye oluşturulamadı");
                        } else {
                            startActivity(new Intent(CreateUserActivity.this, HomeActivity.class));
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("Yeni üye oluşturulamadı");
            }
        });
    }

    public void showToast(String message) {
        runOnUiThread(() -> {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
            toast.show();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
    }
}