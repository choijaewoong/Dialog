package com.torerov.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tacademy on 2015-10-14.
 */
public class CustomDialogFragment extends DialogFragment{

    EditText inputView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        inputView = (EditText)view.findViewById(R.id.editText);
        Button btn = (Button)view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputView.getText().toString();
                Toast.makeText(getContext(), "text : " + text, Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Dialog d = getDialog();
        d.getWindow().setLayout(500,500);
        d.setTitle("Dialog Test");
        WindowManager.LayoutParams params = d.getWindow().getAttributes();
        params.gravity = Gravity.TOP;
//        params.x = 100;
//        params.y = 100;
        d.getWindow().setAttributes(params);
    }
}
