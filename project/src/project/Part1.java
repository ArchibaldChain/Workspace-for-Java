package project;

import java.util.List;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;

public class Part1 {

	// divide String
	public static String hanlp(String string) {
		if (string.length() != 0) {
			// hanlp the String
			string = HanLP.convertToSimplifiedChinese(string);
			List<Term> list = HanLP.segment(string);
			StringBuffer outlist = new StringBuffer();
			// Transform from list to String
			for (Term term : list) {
				// replace special characters and divide
				if (!CoreStopWordDictionary.shouldInclude(term)) {
					continue;
				} else {
					String str = term.toString();
					str=str.replaceAll("[a-zA-Z]", "");
					if (str.length() != 0)
						outlist.append(str + "|");
				}
			}
			String output = outlist.toString();
			return output;
		} else
			return null;
	}

}
