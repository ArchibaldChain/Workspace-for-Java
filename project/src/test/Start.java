package test;

import project.*;
import WordCloud.*;
import cn.ac.GUI.*;

public class Start {

	public static void main(String[] args)
    {
		/*MainForm frame = new MainForm();
		frame.launchFrame();*/
        GraphicalUserInterface gui =  new GraphicalUserInterface();
        gui.mainFrame();
	}


	/**
	 * Start from Here!!!
	 * @param path the file path
	 */
	public static void start(String path, String shape) {
		String code;
		code = CharestDetector.CharDetect(path);
		
		//devide and hanlp and count
		String text = FileIO.normallyFileReader(path, code);
		String words = Part1.hanlp(text);

		FrequencyCounter frequencyCounter = new FrequencyCounter(words);
		frequencyCounter.writingFrequency();

        System.out.println(shape);
		DrawWordCloud drawWordCloud = new DrawWordCloud(shape);//"Ellipse"
        System.out.println(shape);
		drawWordCloud.draw(frequencyCounter.getWordsFrequency());
	}

}
