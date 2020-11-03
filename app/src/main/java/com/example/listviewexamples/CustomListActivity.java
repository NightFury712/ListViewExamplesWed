package com.example.listviewexamples;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewexamples.adapters.CustomAdapter;
import com.example.listviewexamples.models.CustomItemModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.bloco.faker.Faker;

public class CustomListActivity extends AppCompatActivity {

    List<CustomItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        Faker faker = new Faker();

        items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = faker.name.name();
            String textAvt = name.substring(0,1);
            String title = faker.lorem.sentence().substring(0, 20) + "...";
            Date time = faker.date.forward();

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            String timecv = df.format(time);
            items.add(new CustomItemModel(textAvt, name, title, timecv));
        }
        CustomAdapter adapter = new CustomAdapter(this, items);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}