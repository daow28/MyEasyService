package app.tsc.rotchanan.myeasyservice.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import app.tsc.rotchanan.myeasyservice.R;

/**
 * Created by Rotchanan_it on 10/22/2017.
 */

public class SecondFragment extends Fragment {

    private ImageView imageView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Back Controller
        backController();


        // Image Controller
        imageController();


    } // Main method

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // requestCode : เหมือนตั๋วบอกว่าต้อง return ไปที่ไหน
        // resultCode : คือผลการทำงาน
        // data : ข้อมูลที่ return กลับมา

        if (resultCode == getActivity().RESULT_OK) {

            try {

                Uri uri = data.getData(); //Uri คือตัวสำหรับคัดกรองว่าเป็นภาพ,เสียง หรือวิดิโอ เป็นต้น
                Bitmap bitmap = BitmapFactory.decodeStream(
                        getActivity().getContentResolver().openInputStream(uri));

                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(getActivity(), "Not choose Image", Toast.LENGTH_SHORT).show();
        }
    }

    private void imageController() {
        imageView = getView().findViewById(R.id.imvHuman);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT); //คำสั่งสำหรับใช้ให้คนอื่นทำงาน
                intent.setType("image/*"); //สั่งให้ intent ช่วยหาว่ามีแอพตัวไหนอ่านรูปภาพได้บ้าง ใน device นี้
                startActivityForResult(intent.createChooser(intent,
                        "Please Choose App"), 1); //คำสั่งสำหรับให้แสดง dialog ถาม user ให้เลือก app
            }
        });
    }

    private void backController() {
        // initial
        Button button = getView().findViewById(R.id.btnBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .popBackStack();
            } // onClick
        });
    } // backController


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }
} // Main Class
