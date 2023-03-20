package com.dasktelor.testrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dasktelor.testrecyclerview.databinding.PersonItemBinding;

import java.util.ArrayList;


//когда будете создавать класс, пропишите все наследование, а AndroidStudio сама предложит автоматически сделать все методы
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    //массив где будет храниться информация
    private ArrayList<Person> persons;
    //конструктор адаптера, принимает массив, которых будет отображать
    MyRecyclerViewAdapter(ArrayList<Person> persons){
        this.persons = persons;
    }
    //создание view holder для каждого элемента списка
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //следующие 2 строчки запомнить
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PersonItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.person_item, parent, false);



        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(persons.get(position));
    }
    //Получаем общее количество наших элементов
    @Override
    public int getItemCount() {
        return persons.size();
    }
    //класс, который будет отображать один элемент списка (таких элементов будет много)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //binding, с помощью него и будем связывать person_item.xml и объект типа Person
        private final PersonItemBinding binding;

        //просто запомнить так сделать этот конструктор
        public ViewHolder(@NonNull PersonItemBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
        //связывание элемента person и xml
        public void bind(Person person){
            binding.setPerson(person);
        }
    }
}
