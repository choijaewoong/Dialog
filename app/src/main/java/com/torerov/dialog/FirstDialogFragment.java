package com.torerov.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Tacademy on 2015-10-14.
 */
public class FirstDialogFragment extends DialogFragment {

    String[] items = {"item1", "item2", "item3", "item4"};
    int selectPosition;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("SingleDialog");
        selectPosition = 1;
        builder.setSingleChoiceItems(items, selectPosition, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectPosition = which;
                MyDialogFragment d = new MyDialogFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment old = getFragmentManager().findFragmentByTag("dialog");
                if (old != null) {
                    ft.remove(old);
                }
                ft.addToBackStack(null);
                d.show(ft, "dialog2");
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "CHOICE : " + items[selectPosition], Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }
}
