package com.example.zadaniekgebicz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText imie = findViewById(R.id.editImie);
        EditText nazwisko = findViewById(R.id.editNazwisko);
        EditText email = findViewById(R.id.editEmail);
        EditText haslo = findViewById(R.id.editHaslo);
        Button przycisk = findViewById(R.id.buttonRejestruj);

        przycisk.setOnClickListener(v -> {

            String imieTekst = imie.getText().toString().trim();
            String nazwiskoTekst = nazwisko.getText().toString().trim();
            String emailTekst = email.getText().toString().trim();
            String hasloTekst = haslo.getText().toString();

            if (imieTekst.isEmpty() ||
                    nazwiskoTekst.isEmpty() ||
                    emailTekst.isEmpty() ||
                    hasloTekst.isEmpty()) {

                Toast.makeText(this,
                        "Uzupełnij wszystkie pola",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (!emailTekst.contains("@") ||
                    !emailTekst.contains(".")) {

                Toast.makeText(this,
                        "Podaj poprawny adres email",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            boolean duza = false;
            boolean mala = false;
            boolean specjalny = false;

            for (int i = 0; i < hasloTekst.length(); i++) {
                char znak = hasloTekst.charAt(i);
                if (Character.isUpperCase(znak))
                    duza = true;
                if (Character.isLowerCase(znak))
                    mala = true;
                if (!Character.isLetterOrDigit(znak))
                    specjalny = true;
            }

            if (hasloTekst.length() < 8 ||
                    !duza ||
                    !mala ||
                    !specjalny) {

                Toast.makeText(this,
                        "Hasło musi mieć co najmniej 8 znaków, Dużą/Małą literę, znak specjalny",
                        Toast.LENGTH_LONG).show();

                return;
            }
            Toast.makeText(this,
                    "Dane są poprawne",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
