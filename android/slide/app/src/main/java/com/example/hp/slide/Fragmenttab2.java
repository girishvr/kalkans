package com.example.hp.slide;



        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.app.Fragment;

public class Fragmenttab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
        return rootView;
    }

}
//Next, create a class for the third tab. Go to File > New > Class and name