package com.example.pr10savichev;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AlertDialog(String title, String message){
        // создает и отображает диалоговое окно с заголовком и сообщением.
        // диалоговое окно не может быть отменено и содержит кнопку “OK”, которая закрывает диалог.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alter = builder.create();
        alter.show();
    }

    public void Consider(View view) {
        // метод при нажатии кнопки, считывает значения из поле и выполняет расчёт в зависимоти от состояния переключателя ToDollar.
        // результат отображается в поле Result.
        EditText CurrencyRate = findViewById(R.id.editText);
        EditText Amount = findViewById(R.id.editText2);
        Switch ToDollar = findViewById(R.id.switch1);
        TextView tv = findViewById(R.id.textView3);

        if( CurrencyRate.getText().length() <= 0 || Amount.getText().length() <= 0)
        {
            AlertDialog("Уведомление", "Заполните все поля.");
            return;
        }

        float f_count = Float.parseFloat(String.valueOf(CurrencyRate.getText()));
        float f_course = Float.parseFloat(String.valueOf(Amount.getText()));
        float composition = 0;

        if(!ToDollar.isChecked()) {
            composition = f_count * f_course;
            tv.setText(composition + "р.");
        }
        else {
            composition = f_count / f_course;
            tv.setText(composition + " $.");
        }
    }

    public void URL(View view) {
        //метод открывает веб-страницу
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sberbank.ru/ru/quotes/currencies"));
        startActivity(intent);
    }
}