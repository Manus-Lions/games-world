package games.guitarHero;
import javax.sound.sampled.*;

public class DisturbNoise {
	
	private static final int SAMPLE_RATE = 44100; // sample rate in Hz
	  private static final int AMPLITUDE = 32000; // amplitude of sine wave
	  private static final int FREQUENCY = 440; // frequency of sine wave in Hz
	  private static final double DURATION = 0.02 ; // duration of sine wave in seconds


	
	public static void dissonance() {
		
		 // Set up audio format

		    AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE, 16, 1, true, false);
		    SourceDataLine line;
		    try {
		      line = AudioSystem.getSourceDataLine(audioFormat);
		      line.open(audioFormat);
		      line.start();
		      for (int i = 0; i < DURATION * SAMPLE_RATE; i++) {
		        double angle = (2.0 * Math.PI * i * FREQUENCY) / SAMPLE_RATE;
		        int value = (int) (AMPLITUDE * Math.sin(angle));
		        line.write(new byte[] { (byte) (value & 0xff), (byte) ((value >> 8) & 0xff) }, 0, 2);
		      }
		      line.drain();
		      line.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }

		}

		
	
       

