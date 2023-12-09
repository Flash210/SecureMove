package com.example.securemove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class CrypEtDecrypt extends AppCompatActivity {

    private TextView txtDecrypt,txtCrypte,txtMethod,keyTxt;
    private ImageView affineImageView,vigenereImageView,cesarImageView;
    private EditText editText;
    private Button cryptButton,decryptButton,clearBtn;

    private Button btnLogOut;




    private boolean isAffineSelected = false,isCesarSelected = false, isVigenereSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryp_et_decrypt);


        editText = findViewById(R.id.texte);
        cryptButton = findViewById(R.id.crytBtn);
        txtCrypte = findViewById(R.id.txtCrpte);
        decryptButton = findViewById(R.id.decrBtn);
        txtDecrypt = findViewById(R.id.texteDecypt);
        keyTxt = findViewById(R.id.keyTxt);

        affineImageView = findViewById(R.id.affine);
        cesarImageView = findViewById(R.id.cesar);
        vigenereImageView = findViewById(R.id.vigenere);
        txtMethod = findViewById(R.id.txtMethod);

        clearBtn = findViewById(R.id.clearBtn);

        cryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalText = editText.getText().toString();

                String resultText = "";

                if (isAffineSelected) {
                    resultText = CryptageManager.affineEncrypt(originalText, 5, 8);
                } else if (isCesarSelected) {
                    resultText = CryptageManager.caesarEncrypt(originalText, 3);
                } else if (isVigenereSelected){
                  resultText= CryptageManager.vigenereEncrypt(originalText,keyTxt.getText().toString());
                }


                txtCrypte.setText(resultText);
            }
        });


        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String encryptedText = txtCrypte.getText().toString();

                String resultText = "";

                if (isAffineSelected) {
                    resultText = CryptageManager.affineDecrypt(encryptedText, 5, 8);
                } else if (isCesarSelected) {
                    resultText = CryptageManager.caesarDecrypt(encryptedText, 3);
                } else if (isVigenereSelected) {
                  resultText= CryptageManager.vigenereDecrypt(encryptedText,"k");
                }
                txtDecrypt.setText(editText.getText().toString());

            }
        });

        affineImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAffineSelected = true;
                isCesarSelected = false;
                isVigenereSelected = false;
                txtMethod.setText(getString(R.string.txtMethod) +" Affine ");
            }
        });

        cesarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAffineSelected = false;
                isCesarSelected = true;
                isVigenereSelected = false;
                txtMethod.setText(getString(R.string.txtMethod) +" Caesar ");
            }
        });

        vigenereImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAffineSelected = false;
                isCesarSelected = false;
                isVigenereSelected = true;
                txtMethod.setText(getString(R.string.txtMethod) +" Vigenere ");
                keyTxt.setVisibility(View.VISIBLE);


            }
        });


        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                txtCrypte.setText("");
                txtDecrypt.setText("");
                keyTxt.setText("");
                keyTxt.setVisibility(View.INVISIBLE);
            }
        });


    }



    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}