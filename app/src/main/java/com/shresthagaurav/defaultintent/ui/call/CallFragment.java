package com.shresthagaurav.defaultintent.ui.call;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.shresthagaurav.defaultintent.R;

public class CallFragment extends Fragment {
    Button btnCall,btnclear;
    EditText etNumber;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_call, container, false);
        btnCall = root.findViewById(R.id.btncall);
        btnclear=root.findViewById(R.id.clearnumber);
        etNumber = root.findViewById(R.id.text_number);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String phnumber=(etNumber.getText().toString());
                intent.setData(Uri.parse("tel:" +phnumber));
                startActivity(intent);
                etNumber.setText("");
                btnclear.setVisibility(View.VISIBLE);
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber.setText("");
            }
        });
        return root;
    }

}