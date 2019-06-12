package audios;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ObstacleAudio {
	
	public ObstacleAudio() {
		
		try {
			
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File("bgm/O.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}//class