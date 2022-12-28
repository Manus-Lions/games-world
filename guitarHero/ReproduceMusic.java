package games.guitarHero;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproduceMusic {
	
	static Clip clip;
	
 public static void reproduceSong(String songPath) {
	 
	    try {
	      // Open an audio input stream.
	      File soundFile = new File(songPath);
	      AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	      // Get a sound clip resource.
	      clip = AudioSystem.getClip();
	      // Open audio clip and load samples from the audio input stream.
	      clip.open(audioIn);
	      clip.start();
	    } catch (UnsupportedAudioFileException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (LineUnavailableException e) {
	      e.printStackTrace();
	    }
	  }
	

public static void EndSong() {
	
	clip.stop();
    clip.close();
}


}