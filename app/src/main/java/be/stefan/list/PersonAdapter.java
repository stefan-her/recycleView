package be.stefan.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> peopleData;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_firstName, item_lastName;
        private ImageView item_img;

        public ViewHolder(View v) {
            super(v);

            item_firstName = v.findViewById(R.id.item_firstName);
            item_lastName = v.findViewById(R.id.item_lastName);
            item_img = v.findViewById(R.id.img);
        }

    }

    public PersonAdapter(ArrayList<Person> people) {
        this.peopleData = people;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        Person people = peopleData.get(position);
        holder.item_lastName.setText(people.getLastname());
        holder.item_firstName.setText(people.getFirstname());

        ImageView img = holder.item_img;
        img.setImageResource(R.drawable.homme);
        if(people.getGender() == Person.Gender.FEMALE) { img.setImageResource(R.drawable.femme); }
    }

    @Override
    public int getItemCount() {
        return peopleData.size();
    }
}
