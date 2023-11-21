package com.example.securemove;

import androidx.appcompat.app.AppCompatActivity;

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


    private ImageView affineImageView;
    private ImageView cesarImageView;

    private boolean isAffineSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryp_et_decrypt);





        editText = findViewById(R.id.texte);
        cryptButton = findViewById(R.id.crytBtn);
        txtCrypte = findViewById(R.id.txtCrpte);
        decryptButton = findViewById(R.id.decrBtn);
        txtDecrypt = findViewById(R.id.texteDecypt);

        affineImageView = findViewById(R.id.affine);
        cesarImageView = findViewById(R.id.cesar);
        txtMethod= findViewById(R.id.txtMethod);


        // Set click listener for the "Crypter" button
        cryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from the EditText
                String originalText = editText.getText().toString();

                // Determine which cipher to use based on user selection
                String resultText;
                if (isAffineSelected) {
                    // Perform Affine Cipher encryption
                    resultText = CryptageManager.affineEncrypt(originalText, 5, 8); // Example coefficients
                } else {
                    // Perform Caesar Cipher encryption
                    resultText = CryptageManager.caesarEncrypt(originalText, 3); // Example shift
                }

                // Display the encrypted text in txtCrypte
                txtMethod.setText(R.string.txtMethod);
                txtCrypte.setText(resultText);
            }
        });

        // Set click listener for the "Decrypter" button
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from txtCrypte
                String encryptedText = txtCrypte.getText().toString();

                // Determine which cipher to use based on user selection
                String resultText;
                if (isAffineSelected) {
                    // Perform Affine Cipher decryption
                    resultText = CryptageManager.affineDecrypt(encryptedText, 5, 8); // Example coefficients
                } else {
                    // Perform Caesar Cipher decryption
                    resultText = CryptageManager.caesarDecrypt(encryptedText, 3); // Example shift
                }

                // Display the decrypted text in txtDecrypt
                txtDecrypt.setText(resultText);
            }
        });

        // Set click listener for the "Affine" ImageView
        affineImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set Affine Cipher as the selected cipher
                isAffineSelected = true;
            }
        });

        // Set click listener for the "Cesar" ImageView
        cesarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set Caesar Cipher as the selected cipher
                isAffineSelected = false;
            }
        });
    }
}