package audios;

import java.io.File;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class BGMusic {
	
	public BGMusic(){
		try {
			Sequence sequence;
			
			sequence = MidiSystem.getSequence(new File("bgm/flourish.mid"));
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			
			sequencer.start();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}//try_catch
	}
	
}//class