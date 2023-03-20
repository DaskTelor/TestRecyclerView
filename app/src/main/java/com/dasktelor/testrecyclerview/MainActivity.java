package com.dasktelor.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dasktelor.testrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //создаем список элементов Person
        ArrayList<Person> persons = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            persons.add(new Person("Anton", 90));
            persons.add(new Person("Lev", 43));
            persons.add(new Person("Veronika", 43));
        }

        //устанавливаем способ отображения списка, в данном случае таблицей
        //(можно посчитать и передать какое либо значение, которое будет зависеть от размера экрана)
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        //устанавливаем адаптер для нашего списка
        binding.recyclerView.setAdapter(new MyRecyclerViewAdapter(persons));




        //создаем намерение для новой активности
        Intent intent = new Intent(this, LoginActivity.class);
        //передаем параметры в новую активность
        intent.putExtra("name", "value");

        binding.buttonLoginStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //начинаем новую активность при нажатии на кнопку
                startActivity(intent);
                //удаляем текущую активность
                finish();
            }
        });

    }
}