package g58137.atlg3.boulder.view;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    AudioInputStream boulderDashTheme;
    AudioInputStream dash;
    Clip clip;

    public MusicPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String path = getClass().getResource("BoulderDashTheme.wav").getPath();
        File file = new File(path);
        boulderDashTheme = AudioSystem.getAudioInputStream(file);
        path = getClass().getResource("dash.wav").getPath();
        file = new File(path);
        dash = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
    }

    public void playStart() {
        try {
            String path = getClass().getResource("BoulderDashTheme.wav").getPath();
            File file = new File(path);
            boulderDashTheme = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(boulderDashTheme);
        } catch (Exception e){
            System.out.println("Can't open the music.\nError message :"+e.getMessage());
        }
        clip.start();
    }

    public void playDash() {
        try {
            clip = AudioSystem.getClip();
            String path = getClass().getResource("dash.wav").getPath();
            File file = new File(path);
            dash = AudioSystem.getAudioInputStream(file);
            clip.open(dash);
        } catch (Exception e){
            System.out.println("Can't open the music.\nError message :"+e.getMessage());
        }
        clip.start();
    }

    public void stop(){
        clip.stop();
    }
}
