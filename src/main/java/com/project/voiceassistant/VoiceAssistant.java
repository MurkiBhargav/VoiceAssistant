package com.project.voiceassistant;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceAssistant {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us"); // setting up the language
		config.setDictionaryPath("src\\main\\resources\\dictionary.dic");
		config.setLanguageModelPath("src\\main\\resources\\languagemodel.lm");
		
		try {
			LiveSpeechRecognizer speechRecognizer = new LiveSpeechRecognizer(config);
			speechRecognizer.startRecognition(true);
			System.out.println("Listening...");
			
			SpeechResult speechResult = null;
			
			PerformActions object = new PerformActions();
			
			while((speechResult = speechRecognizer.getResult())!= null) {
				String command = speechResult.getHypothesis();
				System.out.println("COMMAND :" +command);
				object.executeCommand(command);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
