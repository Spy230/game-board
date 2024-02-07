package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // поля
    private TextView score;
    private Button lionsTeam, panthersTeam;
    private int countLions = 0, countPanthers = 0;
    private static final String COUNT_LIONS_KEY = "count_lions";
    private static final String COUNT_PANTHERS_KEY = "count_panthers";

    // создание активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Создание активности", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);

        // привязка разметки к полям
        score = findViewById(R.id.score);
        lionsTeam = findViewById(R.id.lionsTeam);
        panthersTeam = findViewById(R.id.panthersTeam);

        // обработка нажатия кнопок
        lionsTeam.setOnClickListener(listener);
        panthersTeam.setOnClickListener(listener);

        //восстановление счетчика
        if (savedInstanceState != null) {
            countLions = savedInstanceState.getInt(COUNT_LIONS_KEY);
            countPanthers = savedInstanceState.getInt(COUNT_PANTHERS_KEY);
            updateScore();
        }
    }


    // запуск активности
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Запуск активности", Toast.LENGTH_SHORT).show();
    }

    // открытие взаимодействия с активностью
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Открытие взаимодействия с активностью", Toast.LENGTH_SHORT).show();
    }

    // отзыв взаимодействия с активностью
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Отзыв взаимодействия с активностью", Toast.LENGTH_SHORT).show();
    }

    // скрытие активности
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Скрытие активности", Toast.LENGTH_SHORT).show();
    }

    // уничтожение активности
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT).show();
    }
        //сохранение
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_LIONS_KEY, countLions);
        outState.putInt(COUNT_PANTHERS_KEY, countPanthers);
    }

    private void updateScore() {
        score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.lionsTeam) {
                countLions++;
            } else if (view.getId() == R.id.panthersTeam) {
                countPanthers++;
            }
            updateScore();
        }
    };
}