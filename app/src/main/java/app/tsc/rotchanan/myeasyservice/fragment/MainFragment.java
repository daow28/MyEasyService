package app.tsc.rotchanan.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.tsc.rotchanan.myeasyservice.R;

/**
 * Created by Rotchanan_it on 10/21/2017.
 */

public class MainFragment extends Fragment{

    // การสร้าง Method หลัก
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Button Controller
        buttonController();

    } // Main method

    private void buttonController() {
        // initial View
        Button button = getView().findViewById(R.id.btnGoToSecond);

        // Get Event from Click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to SecondFragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new SecondFragment())
                        .addToBackStack(null) // คำสั่งนี้เป็นการบอกว่าไม่ต้องถอดหน้ากากเก่าออก ให้เอาหน้ากากใหม่ไปทับ เวลากด back ก็จะกลับไปหน้ากากเดิมได้
                        .commit();

            } // onClick
        });

    }

    // การสร้างหน้ากาก
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    } // onCreateView
}  //Main Class
