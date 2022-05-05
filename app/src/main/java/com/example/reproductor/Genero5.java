package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Genero5 extends AppCompatActivity {

    ImageView btnPrev,btnNext,btnPause,btnPlay,imgSong,btnAutor;
    MediaPlayer mediaPlayer;
    double starttime = 0;
    double finaltime = 0;
    Handler myHandler = new Handler();
    SeekBar seekbar;
    TextView txtTiempo, txtDuracion, txtNombre;
    int songs[] = {R.raw.music1g5,R.raw.music2g5,R.raw.music3g5,R.raw.music4g5,R.raw.music5g5};
    int port[] = {R.drawable.g5b1,R.drawable.g5b2,R.drawable.g5b3,R.drawable.g5b4,R.drawable.g5b5};
    String name[] = {"See Naylors - Tali Nai 'Afe'","Magic System - Magic in the Air", "The Lumineers - Ho Hey", "Kodaline - The One","Robert Parker - 85 Again"};
    int index=0;
    int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero5);

        imgSong = (ImageView) findViewById(R.id.imgSong);
        btnAutor = (ImageView) findViewById(R.id.btnAutor);
        btnPrev = (ImageView) findViewById(R.id.btnPrev);
        btnNext = (ImageView) findViewById(R.id.btnNext);
        btnPause = (ImageView) findViewById(R.id.btnPause);
        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        txtTiempo = (TextView) findViewById(R.id.txtTiempo);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDuracion = (TextView) findViewById(R.id.txtDuracion);
        txtNombre.setText(name[index]);
        mediaPlayer = MediaPlayer.create(this,songs[index]);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        imgSong.setBackgroundResource(port[index]);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                finaltime = mediaPlayer.getDuration();
                starttime = mediaPlayer.getCurrentPosition();
                if (oneTimeOnly == 0){
                    seekbar.setMax((int) finaltime);
                    oneTimeOnly = 1;
                }
                txtDuracion.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finaltime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime)))
                );

                txtTiempo.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                        TimeUnit.MILLISECONDS.toSeconds((long) starttime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime)))
                );
                imgSong.setBackgroundResource(port[index]);
                seekbar.setProgress((int) starttime);
                myHandler.postDelayed(UpdateSongTime,100);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index>4)index=0;
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplication(), songs[index]);
                finaltime = mediaPlayer.getDuration();
                txtDuracion.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finaltime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime)))
                );
                starttime = mediaPlayer.getCurrentPosition();
                txtNombre.setText(name[index]);
                imgSong.setBackgroundResource(port[index]);
                mediaPlayer.start();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(index<0)index=4;
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplication(), songs[index]);
                finaltime = mediaPlayer.getDuration();
                txtDuracion.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finaltime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime)))
                );
                starttime = mediaPlayer.getCurrentPosition();
                txtNombre.setText(name[index]);
                imgSong.setBackgroundResource(port[index]);
                mediaPlayer.start();
            }
        });

    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            starttime = mediaPlayer.getCurrentPosition();
            txtTiempo.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                    TimeUnit.MILLISECONDS.toSeconds((long) starttime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime)))
            );
            seekbar.setProgress((int) starttime);
            myHandler.postDelayed(this,100);
        }
    };

    public void autor(View view) {
        if (index == 0){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCmIYKsTBFH0qCfM4YQpc4bg");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 1){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCAFa7ZqFFVqoMMhACqvAR8g");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 2){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCMcghb8JhNIYntWea9QKFGA");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 3){
            Uri url = Uri.parse("https://music.youtube.com/channel/UC0cymQddFci7e31o7EIznYw");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 4){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCa1xU8hVaCScU2R0M8AU8aw");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        }
    }
}
