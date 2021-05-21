package be.stefan.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Zaza", "Vanderquack", Person.Gender.FEMALE));
        people.add(new Person("Donald", "Duck", Person.Gender.MALE));
        people.add(new Person("Daisy", "Duck",  Person.Gender.FEMALE));
        people.add(new Person("Balthazar", "Picsou", Person.Gender.MALE));
        people.add(new Person("Della", "Duck",  Person.Gender.FEMALE));

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter(people);
        recyclerView.setAdapter(adapter);


        Button bt_add = findViewById(R.id.add);
        bt_add.setOnClickListener(v -> {
            Person p = new Person("Stefan", "Her", Person.Gender.MALE);
            people.add(p);
            adapter.notifyDataSetChanged();
        });

    }
}