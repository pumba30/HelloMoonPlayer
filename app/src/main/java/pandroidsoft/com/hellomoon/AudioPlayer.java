package pandroidsoft.com.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by pumba30 on 18.11.2014.
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;
    private int mCurrentPositionMyTrack;
    private int mTriggerPosition = 0;



    public  void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public  void play(Context context){
        stop();

        mPlayer = MediaPlayer.create(context, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        if(mTriggerPosition == 0){
            mPlayer.start();
        }  else if(mTriggerPosition == 1){
            mPlayer.seekTo(mCurrentPositionMyTrack);
            mTriggerPosition = 0;
            mPlayer.start();
        }


    }


    public void pause(){
        mCurrentPositionMyTrack = mPlayer.getCurrentPosition();
        mTriggerPosition = 1;
        mPlayer.pause();
    }

}
