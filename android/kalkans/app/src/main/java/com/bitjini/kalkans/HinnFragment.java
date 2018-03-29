package com.bitjini.kalkans;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * A simple {@link Fragment} subclass.
 */

public class HinnFragment extends Fragment {


    public HinnFragment() {
        // Required empty public constructor
    }
    private TextView textView;
    private StringBuilder text = new StringBuilder();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hinn, container, false);

        //tabLayout.addTab(tabLayout.newTab().setText(R.string.flood2));
        }
        // Inflate the layout for this fragment
        BufferedReader reader = null;
    {
            try {
                reader = new BufferedReader(
                        new InputStreamReader(getContext().getAssets().open("FloodTipshindi.txt")));

                // do reading, usually loop until end of file reading
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    text.append(mLine);
                    text.append('\n');
                }
            } catch (IOException e) {
                Toast.makeText(getActivity().getApplicationContext(),"Error reading file!", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        //log the exception
                    }
                }

                TextView output= (TextView) textView.findViewById(R.id.hintext);
                output.setText((CharSequence) text);

            }
        }


    }

