package com.bitjini.kalkans;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1EnglishActivity.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1EnglishActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1EnglishActivity extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView textview;
    private VideoView vid;
    private ImageView ip, iv;
    private TextView t;
    private ViewPager mViewPager;
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    private OnFragmentInteractionListener mListener;

    public Tab1EnglishActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1EnglishActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1EnglishActivity newInstance(String param1, String param2) {
        Tab1EnglishActivity fragment = new Tab1EnglishActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


//        }
//                vid = (VideoView) vid.findViewById(R.id.svid);
//                iv = (ImageView) iv.findViewById(R.id.simg);
//                ip = (ImageView) ip.findViewById(R.id.playimg);
//                // t = (TextView) findViewById(R.id.textView1);
//
//               final ProgressDialog pd =  new ProgressDialog(getActivity(), R.layout.activity_sfaety_measures);
//               // final ProgressDialog pd =   (ProgressDialog)getView().findViewById(R.id.pd);
//                //createFromResource(Tab1EnglishActivity, this);
//
//                SharedPreferences sharedpreferences = context.getSharedPreferences("Reg", 0);
//                String currentsos = sharedpreferences.getString("Curentsos", "not found");
//                String link = null;
//                switch (currentsos) {
//                    case "Flood":
//                        link = "rtsp://r3---sn-npoe7nes.googlevideo.com/Cj0LENy73wIaNAkC2a5WRf0JjhMYDSANFC0Ak7daMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/AC20A75907C52EB82C519ED4A4835F21E66CDA9A.74AF38BB545E39B7B3A93980B9DB2B628799B5B7/yt6/1/video.3gp";
//                        break;
//                    case "Fire":
//                        link = "rtsp://r3---sn-a5mekn7d.googlevideo.com/Cj0LENy73wIaNAnJmj27UQkm6hMYDSANFC3VxbdaMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/CD23998BD72DB4EF1814047CC19D4B83245F450A.0410787B99BDD557CABBA737C29EB340EB7C95D1/yt6/1/video.3gp";
//                        break;
//                    case "Medical_Emergency":
//                        link = "rtsp://r5---sn-a5meknes.googlevideo.com/Cj0LENy73wIaNAn4WRc0jzhzvhMYDSANFC1GybdaMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/45ADCDF98CA9C232BB001F1F30C5D8FDD6E1DFDB.3323478CE2730606C731AD4230628DCE126C0067/yt6/1/video.3gp\n";
//                        break;
//                    case "Earthquake":
//                        link = "rtsp://r3---sn-a5meknel.googlevideo.com/Cj0LENy73wIaNAk2YfVIag-xBBMYDSANFC3QybdaMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/8F96FE5D9668F4CE216962E61F1BA85F30DAFA50.89D2A6CD40C00AD6DFBB04432EB33478628D88D9/yt6/1/video.3gp\n";
//                        break;
//                    case "Women Safety":
//                        link = "rtsp://r4---sn-a5meknle.googlevideo.com/Cj0LENy73wIaNAloCgMaSY22TxMYDSANFC0Hx7daMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/93E2A89924C0FC0643CDAD1201283157951484E6.0B83B8795D79C1B433A980995634E1FFD27D2E9A/yt6/1/video.3gp";
//                        break;
//                    case "Accident":
//                        link = "";
//                        break;
//                    case "Terrorist":
//                        link = "rtsp://r3---sn-a5meknl6.googlevideo.com/Cj0LENy73wIaNAnmtgycIwsFZxMYDSANFC0RybdaMOCoAUIASARgreyW-6PejYFYigELa0Z6SzQ1NEJEcHMM/0EC42EE01FF7BB1A90427C00A6345107DD225676.0A39F2B492B56ADA4518F7427A57B36972CE447D/yt6/1/video.3gp\n";
//                        break;
//                    case "Tsunami":
//                        link = "https://m.youtube.com/watch?v=m7EDddq9ftQ&itct=CBEQpDAYACITCJGwrZnuh9oCFUrIcwEdeX0OLjIGcmVsbWZ1SLbC1cek7cPYBA%3D%3D&hl=en&gl=IN&client=mv-google";
//                        break;
////                default:
////                    Toast.makeText(getBaseContext(), \"Emergency Call Made! \\n Location was not retrieved.\", Toast.LENGTH_SHORT).show();
//                }
//                String path1 = link;
//                Uri uri = Uri.parse(path1);
//                MediaController mc = new MediaController(getActivity(), (AttributeSet) this);
//                mc.setAnchorView(vid);
//                vid.setMediaController(mc);
//                mc.setMediaPlayer(vid);
//                vid.setVideoURI(uri);
//                vid.requestFocus();
//                ip.setClickable(true);
//                ip.setImageResource(R.drawable.play);
//                // ip.setVisibility(ImageView.INVISIBLE);
//                vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        // TODO Auto-generated method stub
//                        //ip.setVisibility(ImageView.VISIBLE);
//                        pd.dismiss();
////
//                    }
//                });
//                ip.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        // TODO Auto-generated method stub
//
//                        vid.start();
//
//
//                        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                        pd.setMessage("Loading Video...");
//                        pd.setIndeterminate(false);
//                        pd.setCancelable(true);
//                        pd.show();
//
//                        if (vid.isPlaying()) {
//                            iv.setVisibility(ImageView.INVISIBLE);
//                            ip.setVisibility(ImageView.INVISIBLE);
//                        } else {
//                            iv.setVisibility(ImageView.VISIBLE);
//                            ip.setVisibility(ImageView.VISIBLE);
//                        }
//
//
////                TextView text_view = (TextView) findViewById(R.id.textView1);
////                Typeface font = Typeface.createFromAsset(getAssets(), "floodd.ttf");
////                text_view.setTypeface(font);
//                    }
////
////            public void onStop() {
////                onStop();
////            }
//
//
               }
           }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1englishactivity, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
