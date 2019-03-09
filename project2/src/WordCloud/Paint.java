package WordCloud;
import java.awt.Font;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class Paint {

	public static void main(String[] args) {
		System.out.println("-- Initialized");
		 Font font;
        TextBoard tb = new TextBoard(1000, 1000, Color.pink);
        font = new Font("Apple", Font.BOLD, 80);

	        System.out.println("font is ok");
	        GetPlace gp=new GetPlace(200,200,font,"funk1",tb);
	        //tb.write("funk1",gp.getWX(),gp.getWY(),90,font,Color.black);
	        tb.write("funk1",200,200,0,font,Color.black);
		Rectangle2D t2 = tb.getBounds("funk", font, 200, 200);

        tb.write("funk1123",(int)t2.getMinX(),(int)t2.getMinY(),0,font,Color.green);



		 System.out.println(t2.getMinX()+" "+t2.getMinY());
	        System.out.println("-- Written");
	        tb.display();
	        System.out.println("-- Displayed (be patient, it's coming ...)");
	}

}
