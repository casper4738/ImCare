package com.feechan.imcare.activity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

import com.feechan.imcare.R;
import com.feechan.imcare.adapter.ArtikelListAdapter;
import com.feechan.imcare.adapter.VideoListAdapter;
import com.feechan.imcare.entity.Artikel;
import com.feechan.imcare.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {



    Video video;
    ProgressDialog pDialog;
    VideoView penyakitVideoView;
    String VideoURL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_video);
        penyakitVideoView = (VideoView) findViewById(R.id.penyakitVideoView);
        penyakitVideoView.setZOrderOnTop(true);


        video = (Video)getIntent().getSerializableExtra("video");
        VideoURL = video.getContentvideo();
        Log.d("care","Video URL >>> "+VideoURL);
        bufferVideo();
    }



    private void bufferVideo(){

        // Create a progressbar
        pDialog = new ProgressDialog(VideoActivity.this);
        // Set progressbar title
        pDialog.setTitle("Android Video Streaming Tutorial");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();
        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(VideoActivity.this);
            mediacontroller.setAnchorView(penyakitVideoView);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            penyakitVideoView.setMediaController(mediacontroller);
            penyakitVideoView.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        penyakitVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                penyakitVideoView.start();
            }
        });
        penyakitVideoView.requestFocus();
    }
}
