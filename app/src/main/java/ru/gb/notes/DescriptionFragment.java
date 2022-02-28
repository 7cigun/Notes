package ru.gb.notes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DescriptionFragment extends Fragment {

    public static final String KEY_NOTE = "note";

    private NotesStore note;

    public static DescriptionFragment newInstance(NotesStore note) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_description,menu);
        menu.findItem(R.id.action_about).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_toast: {
                Toast.makeText(requireContext(),"Description Fragment", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        note = getArguments().getParcelable(KEY_NOTE);
        TextView descriptionView = new TextView(getContext());
        descriptionView.setTextSize(30f);

        String[] notes = getResources().getStringArray(R.array.task);
        String[] date = getResources().getStringArray(R.array.date);
        descriptionView.setText((notes[note.getIndex()]) + "\n\n" + (date[note.getIndex()]));
        ((LinearLayout) view).addView(descriptionView);
    }
}