package audios;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TreasureAudio {
	
	public TreasureAudio() {
		
		try {
			
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File("bgm/T.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}//class