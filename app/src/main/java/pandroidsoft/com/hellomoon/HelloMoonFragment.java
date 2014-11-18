package pandroidsoft.com.hellomoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by pumba30 on 18.11.2014.
 */
public class HelloMoonFragment extends Fragment {
    private Button mButtonPlay;
    private Button mButtonStop;
    private Button mButtonPause;
    AudioPlayer mPlayer = new AudioPlayer();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mButtonPlay = (Button) view.findViewById(R.id.hellomoon_playButton);
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());
            }
        });




        mButtonStop = (Button) view.findViewById(R.id.hellomoon_stopButton);
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });

        mButtonPause = (Button) view.findViewById(R.id.buttonPause);
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPlayer.stop();
    }
}
