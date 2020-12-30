package net.onlinebuzz.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ViewPager2 viewPager2 ;


    ArrayList<VideoModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2 = (ViewPager2) findViewById(R.id.viewpager);
        models = new ArrayList<>();



       VideoModel v1 = new VideoModel("Title", "Description", "https://docjamal.xyz/wp-content/uploads/2020/08/video1.mp4");
        models.add(v1);
VideoModel v2 = new VideoModel("Title", "Description", "https://docjamal.xyz/wp-content/uploads/2020/08/video1.mp4");
        models.add(v2);
VideoModel v3 = new VideoModel("Title", "Description", "https://docjamal.xyz/wp-content/uploads/2020/08/video1.mp4");
        models.add(v3);

       viewPager2.setAdapter(new VideoAdapter(models));

       Log.d("tstTxt", String.valueOf(models.size()));
       Log.d("tstTxt", v1.getTitle()+" "+v1.desc+" "+v1.getUrl());

//        FirebaseRecyclerOptions<VideoModel> options =
//                new FirebaseRecyclerOptions.Builder<VideoModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("videos"), VideoModel.class)
//                        .build();
//
//        Log.d("testTxt",FirebaseDatabase.getInstance().getReference().child("videos").toString());
//
//        videoAdapter = new VideoAdapter(options);
//        viewPager2.setAdapter(videoAdapter);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        videoAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        videoAdapter.stopListening();
//    }
}