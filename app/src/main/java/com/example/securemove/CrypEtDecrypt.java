package com.example.securemove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CrypEtDecrypt extends AppCompatActivity {


    private EditText editText;
    private Button cryptButton;
    private TextView txtCrypte;
    private Button decryptButton;
    private TextView txtDecrypt;
    private TextView txtMethod;

    private TextView keyTxt;


    private ImageView affineImageView;

    private ImageView vigenereImageView;

    private ImageView cesarImageView;
    Button clearBtn;

    private boolean isAffineSelected = false;
    private boolean isCesarSelected = false;
    private boolean isVigenereSelected = false;


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
                    resultText = CryptageManager.affineEncrypt(originalText, 5, 8); // Example coefficients
                } else if (isCesarSelected) {
                    resultText = CryptageManager.caesarEncrypt(originalText, 3); // Example shift
                } else if (isVigenereSelected) {
                  resultText= CryptageManager.vigenereEncrypt(originalText,keyTxt.getText().toString()); // Example shift
                }


                txtCrypte.setText(resultText);
            }
        });

        // Set click listener for the "Decrypter" button
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from txtCrypte
                String encryptedText = txtCrypte.getText().toString();

                // Initialize resultText
                String resultText = "";

                // Determine which cipher to use based on user selection
                if (isAffineSelected) {
                    // Perform Affine Cipher decryption
                    resultText = CryptageManager.affineDecrypt(encryptedText, 5, 8); // Example coefficients
                } else if (isCesarSelected) {
                    // Perform Caesar Cipher decryption
                    resultText = CryptageManager.caesarDecrypt(encryptedText, 3); // Example shift
                } else if (isVigenereSelected) {
                  resultText= CryptageManager.vigenereDecrypt(encryptedText,"k"); // Example shift
                }
                txtDecrypt.setText(resultText);

            }
        });

        // Set click listener for the "Affine" ImageView
        affineImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAffineSelected = true;
                isCesarSelected = false;
                isVigenereSelected = false;
                txtMethod.setText(getString(R.string.txtMethod) +" Affine ");
            }
        });

        // Set click listener for the "Cesar" ImageView
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
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }
}