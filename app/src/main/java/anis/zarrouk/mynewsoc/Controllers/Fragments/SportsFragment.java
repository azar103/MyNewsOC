package anis.zarrouk.mynewsoc.Controllers.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import anis.zarrouk.mynewsoc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends Fragment {


    public SportsFragment() {
        // Required empty public constructor
    }

    public static SportsFragment newInstance() {
        return (new SportsFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

}
