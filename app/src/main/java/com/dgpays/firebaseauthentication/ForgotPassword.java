package com.dgpays.firebaseauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dgpays.firebaseauthentication.databinding.ActivityForgotPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private Toast toast;
    private ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_left);
    }

    public void init() {
        binding.setListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.btnPasswordReset) {
            sendNewPassword();
        } else if (view == binding.btnLoginHere) {
            startActivity(new Intent(ForgotPassword.this, MainActivity.class));
        }
    }

    public void sendNewPassword() {
        mAuth = FirebaseAuth.getInstance();
        String mail = binding.emailAdress.getText().toString();

        if (TextUtils.isEmpty(mail)) {
            showToast("Lütfen email adresinizi giriniz");
            return;
        }

        mAuth.sendPasswordResetEmail(mail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            showToast("Yeni parola için gerekli bağlantı adresinize gönderildi!");
                            startActivity(new Intent(ForgotPassword.this,MainActivity.class));
                            finish();
                        } else {
                            showToast("Mail gönderme hatası!");
                        }
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

