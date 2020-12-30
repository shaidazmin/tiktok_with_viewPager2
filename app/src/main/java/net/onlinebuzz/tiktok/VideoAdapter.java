package net.onlinebuzz.tiktok;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    ArrayList<VideoModel> videoModels ;

    public VideoAdapter(ArrayList<VideoModel> videoModels) {
        this.videoModels = videoModels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video_row,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.videoView.setVideoPath(videoModels.get(position).getUrl());
        holder.title.setText(videoModels.get(position).getTitle());

        holder.desc.setText(videoModels.get(position).getDesc());
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.progressBar.setVisibility(View.GONE);
                mediaPlayer.start();
            }
        });

        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView title, desc;
        ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = (VideoView) itemView.findViewById(R.id.videoView);
            title = (TextView) itemView.findViewById(R.id.textVideoTitle);
            desc = (TextView) itemView.findViewById(R.id.textVideoDescription);
            progressBar = (ProgressBar) itemView.findViewById(R.id.videoProgressBar);
        }

//        void setData(VideoModel obj){
//
//            title.setText(obj.getTitle());
//            desc.setText(obj.getDesc());
//            videoView.setVideoPath(obj.getUrl());
//
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mediaPlayer) {
//                    progressBar.setVisibility(View.GONE);
//                    mediaPlayer.start();
//                }
//            });
//
//            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mediaPlayer) {
//                    mediaPlayer.start();
//                }
//            });
//        }
    }

}
