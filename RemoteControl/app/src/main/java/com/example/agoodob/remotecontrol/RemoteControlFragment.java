package com.example.agoodob.remotecontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/*

 */
public class RemoteControlFragment extends Fragment {

    private TextView mSelectedTextView;
    private TextView mWorkingTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_remote_control, container, false);

        mSelectedTextView = (TextView) v.findViewById(R.id.fragment_remote_control_selectedTextView);
        mWorkingTextView = (TextView) v.findViewById(R.id.fragment_remote_control_workingTextView);

        // 当被点击的时候就把自己的文字，添加到 workingTextView 里
        View.OnClickListener numberButtonListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = (TextView)v;
                String working = mWorkingTextView.getText().toString();
                String text = textView.getText().toString();
                if(working.equals("0")){
                    mWorkingTextView.setText(text);
                } else {
                    mWorkingTextView.setText(working + text);
                }
            }
        };

        TableLayout tb = (TableLayout) v.findViewById(R.id.fragment_remote_control_tableLayout);
        int number = 1;

        for (int i = 2; i < tb.getChildCount() - 1; i++) {
            TableRow row = (TableRow) tb.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                Button b = (Button) row.getChildAt(j);
                b.setText(""+number);
                b.setOnClickListener(numberButtonListener);
                number++;
            }
        }

        TableRow bottomRow = (TableRow) tb.getChildAt(tb.getChildCount() -1);

        Button deleteButton = (Button) bottomRow.getChildAt(0);
        deleteButton.setText(R.string.Delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWorkingTextView.setText("0");
            }
        });

        Button zeroButton = (Button) bottomRow.getChildAt(1);
        zeroButton.setText("0");
        zeroButton.setOnClickListener(numberButtonListener);

        Button enterButton =  (Button) bottomRow.getChildAt(2);
        enterButton.setText(R.string.Enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence working = mWorkingTextView.getText();
                if(working.length() > 0){
                    mSelectedTextView.setText(working);
                }
                mWorkingTextView.setText("0");
            }
        });

        return v;
    }
}
