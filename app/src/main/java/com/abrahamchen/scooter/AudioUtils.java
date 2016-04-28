package com.abrahamchen.scooter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by AbrahamChen on 16/4/28.
 */
public class AudioUtils {
    private static MediaPlayer mp;

    public static void playAudio(String mediaUrl, Context context, final RelativeLayout playStatus) {
        try {
            Log.i("FileOutputStream", mediaUrl);
            URLConnection cn = new URL(mediaUrl).openConnection();
            InputStream is = cn.getInputStream();

            // create file to store audio
            File mediaFile = new File(context.getCacheDir(), "mediafile");
            FileOutputStream fos = new FileOutputStream(mediaFile);
            byte buf[] = new byte[16 * 1024];
            Log.i("FileOutputStream", "Download");

            // write to file until complete
            do {
                int numread = is.read(buf);
                if (numread <= 0)
                    break;
                fos.write(buf, 0, numread);
            } while (true);
            fos.flush();
            fos.close();
            Log.i("FileOutputStream", "Saved");
            mp = new MediaPlayer();

            // create listener to tidy up after playback complete
            MediaPlayer.OnCompletionListener listener = new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    // free up media player
                    mp.release();
                    playStatus.performClick();
                    Log.i("OnCompletionListener", "MediaPlayer Released");
                }
            };
            mp.setOnCompletionListener(listener);

            FileInputStream fis = new FileInputStream(mediaFile);
            // set mediaplayer data source to file descriptor of input stream
            mp.setDataSource(fis.getFD());
            mp.prepare();
            Log.i("MediaPlayer", "Start Player");
            mp.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean getMediaPlayStatus() {
        return mp.isPlaying();
    }

    public static void stopAudio() {
        try {
            mp.stop(); //error
            mp.reset();
            mp.release();
        } catch (Exception e) {
            Log.e("Nitif Activity", e.toString());
        }
    }
}
