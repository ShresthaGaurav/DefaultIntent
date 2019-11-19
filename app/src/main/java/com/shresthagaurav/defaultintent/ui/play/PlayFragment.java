package com.shresthagaurav.defaultintent.ui.play;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.shresthagaurav.defaultintent.R;

public class PlayFragment extends Fragment {

    Button btngp, btnclear;
    EditText search;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_play, container, false);
        btngp = (Button) root.findViewById(R.id.btnSearch);
        search = root.findViewById(R.id.text_search);
        btnclear = (Button) root.findViewById(R.id.btnclear);

        btngp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(search.getText().toString())) {
                    Toast.makeText(getActivity(), "enter name to search", Toast.LENGTH_LONG).show();
                    search.setError("enter application name to search");
                } else {
                    String ser = search.getText().toString();
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("market://search?q=" + ser));
                    startActivity(goToMarket);
                    search.setText("");
                    btnclear.setVisibility(View.VISIBLE);
                }
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setText("");
            }
        });
        return root;
    }

}