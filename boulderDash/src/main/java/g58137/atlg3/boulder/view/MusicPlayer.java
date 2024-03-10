package g58137.atlg3.boulder.view;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    Clip clip;

    public MusicPlayer() throws LineUnavailableException {
        clip = AudioSystem.getClip();
    }

    public void playStart() {
        try {
            String path = getClass().getResource("BoulderDashTheme.wav").getPath();
            File file = new File(path);
            AudioInputStream boulderDashTheme = AudioSystem.getAudioInputStream(file);
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
            AudioInputStream dashAudio = AudioSystem.getAudioInputStream(file);
            clip.open(dashAudio);
        } catch (Exception e){
            System.out.println("Can't open the music.\nError message :"+e.getMessage());
        }
        clip.start();
    }

    public void playDiamond() {
        try {
            clip = AudioSystem.getClip();
            String path = getClass().getResource("diamond.wav").getPath();
            File file = new File(path);
            AudioInputStream diamondAudio = AudioSystem.getAudioInputStream(file);
            clip.open(diamondAudio);
        } catch (Exception e){
            System.out.println("Can't open the music.\nError message :"+e.getMessage());
        }
        clip.start();
    }

    public void stop(){
        clip.stop();
    }
}
