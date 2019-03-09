package test;

import project.*;
import WordCloud.*;
import cn.ac.GUI.*;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Start.Start("C:\\Academic file\\CS/redSun.txt");

//        MainForm.GUI();
		MainForm frame = new MainForm();
		frame.launchFrame();

	}


	/**
	 * Start from Here!!!
	 * @param path the file path
	 */
	public static void start(String path) {
		String code;
		code = CharestDetector.CharDetect(path);
		
		//devide and hanlp and count
		String text = FileIO.normallyFileReader(path, code);
		String words = Part1.hanlp(text);

		FrequencyCounter frequencyCounter = new FrequencyCounter(words);
		frequencyCounter.writingFrequency();

		DrawWordCloud drawWordCloud = new DrawWordCloud();
		drawWordCloud.draw(frequencyCounter.getWordsFrequency());
	}

}
