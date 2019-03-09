package WordCloud;




import java.util.List;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;


public class DrawWordCloud  {
	
//	 public static Map readFile(String path) {
//	 HashMap<String,Integer> m = new HashMap<>();
//		try {
//		Reader reader = new InputStreamReader(new FileInputStream(path),"UTF-8");
//				BufferedReader bufferedReader = new BufferedReader(reader);
//				String []a = null;
//				String string = null;
//				int i =0;
//	     while ((string = bufferedReader.readLine()) != null) {
//	    	 if(string.length()==0)
//		 			continue;
//	    	 		i++;
////	    	 	System.out.println(string);
//
//			    a= string.split(",");
////			   System.out.println(a[0]+a[1]);
//	    	    int b = Integer.valueOf(a[1]);
//	    	 		m.put(a[0], b);
//
//				}
//
//
//		bufferedReader.close();
//
//		reader.close();
//
//
//		System.out.println("Finish Reading");
//
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//			}
//	 catch (IOException e) {
//
//		e.printStackTrace();
//			}
//
//		return m;
//		}

    public void draw(String args) {
        List<Rectangle> rects = new ArrayList<>();

        TextBoard tb = new TextBoard(1000, 1000,Color.BLACK);

        System.out.println("-- Start Drawing --");
        int r1 = 0;
        int r2 = 0;

        Random random = new Random();
        GetSuitFont g = new GetSuitFont(args);
        for (int i = 0; i < g.getWords().length; i++)
        {

            Font font = g.getSuitableFont(g.getFrequency()[i]);
            Color color = g.getSuitableColor(g.getFrequency()[i]);
            if (font == null || color == null) break;
            Rectangle2D t = tb.getBounds(g.getWords()[i], font, r1, r2);
            int angle = random.nextInt(2);

            if (i == 0 || angle == 0)
            {
                boolean out = true;
                int a = 0;
                while (out)
                {
                    out = false;
                    if (i == 0) {
                        r1 = 500 - (int)(0.5*t.getWidth());
                        r2 = 500 - 30;
                        t = tb.getBounds(g.getWords()[i], font, r1, r2);
                        break;
                    }
                    int type = 0;
                    double precentage = ((double)g.getFrequency()[i] - (double)g.getFrequency()[g.getFrequency().length-1]) /
                            ((double)g.getFrequency()[0] - (double)g.getFrequency()[g.getFrequency().length-1]);
                    if (precentage >= 0.6){
                        type = 1;
                    } else if (precentage >= 0.3){
                        type = 2;
                    }
                    int[] array = CloudBound(type);
                    r1 = array[0];
                    r2 = array[1];
                    t = tb.getBounds(g.getWords()[i], font, r1, r2);

                    for (Rectangle r : rects) {
                        if (Rect.Rect(r.getLx(), r.getLy(), r.getRx(), r.getRy(),
                                (int) t.getMinX() - 1, (int) t.getMinY() - 1, (int) t.getMaxX() + 1, (int) t.getMaxY() + 1)) {
                            out = true;
                        }
                    }
                    a++;
                    if (a == 500) {
                        a = 0;
                        System.out.println("\nmaking it smaller");
                        System.out.println("font size: " + font.getSize());
                        g.makeSizeSmaller();
                        font = g.getSuitableFont(g.getFrequency()[i]);
                        if (font == null) break;
                        System.out.println("font size: " + font.getSize());
                    }
                }
                if (font == null) break;
                tb.write(g.getWords()[i], r1, r2,0, font, color);
                rects.add(new Rectangle((int) t.getMinX() - 3, (int) t.getMinY() - 3,
                        (int) t.getMaxX() + 3, (int) t.getMaxY() + 3));
                System.out.printf(" %d *",a);
            }

            else {
                boolean out = true;
                int a = 0;
                while (out)
                {

                    out = false;
                    int type = 0;
                    double precentage = ((double)g.getFrequency()[i] - (double)g.getFrequency()[g.getFrequency().length-1]) /
                            ((double)g.getFrequency()[0] - (double)g.getFrequency()[g.getFrequency().length-1]);
                    if (precentage >= 0.6){
                        type = 1;
                    } else if (precentage >= 0.3){
                        type = 2;
                    }

                    int[] array = CloudBound(type);
                    r1 = array[0];
                    r2 = array[1];
                    GetPlace ga = new GetPlace(r1,r2,font,g.getWords()[i],tb);
                    ga.GetStatic();
                    for (Rectangle r : rects) {
                        if (Rect.Rect(r.getLx(), r.getLy(), r.getRx(), r.getRy(),
                                ga.getLUX(), ga.getLUY(), ga.getRDX(), ga.getRDY()) ){
                            out = true;
                        }
                    }
                    a++;
                    if (a == 500) {
                        System.out.println("\nmaking it smaller");
                        System.out.println("font size: " + font.getSize());
                        g.makeSizeSmaller();
                        font = g.getSuitableFont(g.getFrequency()[i]);
                        if (font == null) break;
                        System.out.println("font size: " + font.getSize());
                        a = 0;
                    }
                }
                if (font == null) break;
                GetPlace ga = new GetPlace(r1,r2,font,g.getWords()[i],tb);
                ga.GetStatic();
                tb.write(g.getWords()[i], ga.getWX(), ga.getWY(),90, font, color);
                rects.add(new Rectangle( ga.getLUX()-3, ga.getLUY()-3, ga.getRDX()+3, ga.getRDY()+3));
                System.out.printf(" %d *",a);
            }

        }

        Save.saveJpg(tb);
        System.out.println("-- Written --");
        tb.display();
        System.out.println("-- Finished --");
    }


    private static int[] CloudBound(int type){
        long a,b;
        if(type == 1){
            a = 280;
            b = 210;
        }
        else if(type == 2){
            a = 360;
            b = 290;
        }
        else{
            a = 410;
            b = 340;
        }
        int r1 = 0, r2 = 0;
        Random rand =new Random();
        double r = a*a*b*b + 1;
        while (r > a*a*b*b){
            r1 = rand.nextInt(920) + 39;
            r2 = rand.nextInt(700) + 99;
            r = b*b*(r1-445)*(r1-445) + a*a*(r2-450)*(r2-450);
        }
        int array[] = {r1, r2};
        return array;
    }

}
