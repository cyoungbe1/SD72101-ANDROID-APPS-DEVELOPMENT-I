package com.example.apartmentlikesnda.ui.slideshow;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apartmentlikesnda.R;
import com.example.apartmentlikesnda.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button aptlikebutton = (Button) root.findViewById(R.id.aptlikebtn1);
        aptlikebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputaddress = (EditText) root.findViewById(R.id.addressinput1);
                String inputAddress =  inputaddress.getText().toString();


                EditText inputbedrooms = (EditText) root.findViewById(R.id.bedroomsinput1);
                String inputBedrooms =  inputbedrooms.getText().toString();
                int inputBedroomsint = Integer.parseInt(inputBedrooms);

                EditText inputbaths  = (EditText) root.findViewById(R.id.bathsinput1);
                String inputBaths =  inputbaths.getText().toString();
                int inputBathsint = Integer.parseInt(inputBaths);

                EditText inputrent = (EditText) root.findViewById(R.id.rentinput1);
                String inputRent =  inputrent.getText().toString();
                int inputRentint = Integer.parseInt(inputRent);

                EditText notes = (EditText) root.findViewById(R.id.notesinput1);
                String notes1 =  notes.getText().toString();


                SQLiteDatabase aptlikes = null;
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                        aptlikes = SQLiteDatabase.openDatabase("data/data/" + getActivity().getPackageName() + "/databases/aptlikes.db", null,
                                SQLiteDatabase.OPEN_READWRITE);

                        String insertSQL = "INSERT INTO apts (ADDRESS, NUMBEDRMS, NUMBATHS, MONTHLYRENT, NOTES) ";
                        insertSQL += " VALUES ('" + inputAddress + "', " + inputBedroomsint + ", " + inputBathsint + ", " + inputRentint + ", ";
                        insertSQL += "'" + notes1 + "');";

                        aptlikes.execSQL(insertSQL);
                        aptlikes.close();
                    }
                }
                catch(Exception ex){

                }
            }
        });



        return root;
    }


    }
