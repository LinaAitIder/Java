package ATC.Audio2TextApp;
import java.io.*;

import java.io.File;
import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.transcripts.types.*;
import com.assemblyai.api.resources.transcripts.types.SpeechModel;


// Transcription Audio Using An Api

public class App {
    public static void main(String[] args) throws IOException {
    	
    	// Creating a new client
    	AssemblyAI client = AssemblyAI.builder()
    	                .apiKey("4da44ae27f93439c92925968869ece26")
    	                .build();
    	 
    		     
    	// Choosing the Nano Speech Model Over 'Best' Model
    	@SuppressWarnings("unused")
		var params = TranscriptOptionalParams.builder()
        .speechModel(SpeechModel.NANO)
        .build();
    	
    	 //To detect the language
    	 params = TranscriptOptionalParams.builder()
                 .speakerLabels(true)
                 .languageDetection(true)
                 .build();
    	 
    	 //To specify the language
    	 params = TranscriptOptionalParams.builder()
    		        .languageCode(TranscriptLanguageCode.EN)
    		        .build();
    	 
    	 
    	 
    	//Transcribing the audio
    	Transcript transcript;
    	transcript = client.transcripts().transcribe(
			         new File("C:/Users/hp/eclipse-workspace/Audio2TextApp/src/main/java/ATC/Audio2TextApp/hello1_ar-eg.mp3"));
    	
    	//Transcription failure management
    	if (transcript.getStatus().equals(TranscriptStatus.ERROR)) {
    	    System.err.println(transcript.getError().get());
    	    System.exit(1);
    	}
    	
    	//Displaying the transcripted audio-text
    	System.out.println(transcript.getText().get());
        
    	
    }
}
