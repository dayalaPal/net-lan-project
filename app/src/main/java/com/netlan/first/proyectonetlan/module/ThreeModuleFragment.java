package com.netlan.first.proyectonetlan.module;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.netlan.first.proyectonetlan.games.PuzzleThree;
import com.netlan.first.proyectonetlan.quiz.StartQuizThreeActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ThreeModuleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ThreeModuleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThreeModuleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btPuzzT;
    Button btQuizT;

    Button clk;
    VideoView videov;
    MediaController mediaC;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ThreeModuleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment moduloTres.
     */
    // TODO: Rename and change types and number of parameters
    public static ThreeModuleFragment newInstance(String param1, String param2) {
        ThreeModuleFragment fragment = new ThreeModuleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(com.netlan.first.proyectonetlan.R.layout.fragment_module_three, container, false);
        // Inflate the layout for this fragment

 //       btClk = (Button)vista.findViewById(com.netlan.first.proyectonetlan.R.id.bot);
   //     vVideo = (VideoView)vista.findViewById(com.netlan.first.proyectonetlan.R.id.viView);
     ///   mcMedia = new MediaController(getActivity());
        //btClk.setOnClickListener(new View.OnClickListener(){
          //  public void onClick(View v){
            //    String vpath;
              //  vpath = "android.resource://com.example.hpprobook.myapplication/"+ com.netlan.first.proyectonetlan.R.raw.vlan;

                //Uri uri=Uri.parse(vpath);
               // vVideo.setVideoURI(uri);
               // vVideo.setMediaController(mcMedia);
               // mcMedia.setAnchorView(vVideo);
                //vVideo.start();
            //}
       // });

        //Button
        btPuzzT =(Button)vista.findViewById(com.netlan.first.proyectonetlan.R.id.bt_puzzt);
        btPuzzT.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PuzzleThree.class);
                getActivity().startActivity(intent);
            }
        });


        btQuizT =(Button)vista.findViewById(com.netlan.first.proyectonetlan.R.id.bt_quizt);
        btQuizT.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StartQuizThreeActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return vista;
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
