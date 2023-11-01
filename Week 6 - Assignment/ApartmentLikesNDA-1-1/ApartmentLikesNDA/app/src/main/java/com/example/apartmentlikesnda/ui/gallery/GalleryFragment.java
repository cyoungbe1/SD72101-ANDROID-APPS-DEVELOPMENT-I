package com.example.apartmentlikesnda.ui.gallery;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apartmentlikesnda.R;
import com.example.apartmentlikesnda.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String output1 = "    \n";


        SQLiteDatabase aptlikes = null;


        {

            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1)
                    aptlikes = SQLiteDatabase.openDatabase("/data/data/" + getActivity().getPackageName() + "/databases/aptlikes.db", null,
                            SQLiteDatabase.OPEN_READONLY);

                String sql = "SELECT * FROM apts";
                Cursor crs = aptlikes.rawQuery(sql, null);

                if (crs.moveToFirst()) {
                    // if the database has at least 1 record
                    do {
                        // list the records
                        output1 += crs.getString(0) + "     " +
                                crs.getInt(1) + "    " +
                                crs.getInt(2) + "    \n" +
                                crs.getInt(3) + "    " +
                                crs.getString(4) + "   \n\n ";
                    } while (crs.moveToNext());
                    aptlikes.close();
                }

            } catch (SQLiteException e) {
                output1 = "Problem with database";
            }
            TextView output = (TextView) root.findViewById(R.id.output1);
            output.setText(output1);


            return root;
        }


    }
}