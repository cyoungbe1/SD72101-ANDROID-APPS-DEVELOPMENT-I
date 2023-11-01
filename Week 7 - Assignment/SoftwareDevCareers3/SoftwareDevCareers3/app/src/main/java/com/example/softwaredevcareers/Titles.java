package com.example.softwaredevcareers;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Titles extends Fragment {

    private TitlesViewModel mViewModel;

    public static Titles newInstance() {
        return new Titles();
    }

    View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_titles, container, false);

        Button descriptionbtn = (Button) root.findViewById(R.id.descriptionbtn);
        TextView descriptiondisplay = (TextView) root.findViewById(R.id.descriptionDisplay);

        descriptionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner careerspinner = (Spinner) root.findViewById(R.id.careerSpinner);
                String spinnerSelectedvalue = careerspinner.getSelectedItem().toString();

                TextView output = (TextView) root.findViewById(R.id.descriptionDisplay);
                String[] Titles = getResources().getStringArray(R.array.titledescrips);
                output.setText(spinnerSelectedvalue + "\n" + Titles[careerspinner.getSelectedItemPosition()]  );




            }
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TitlesViewModel.class);
        // TODO: Use the ViewModel
    }

}