package WordCloud;

import java.awt.Font;
import java.awt.geom.Rectangle2D;

public class GetPlace {
	//需要写的垂直字体的左上点&字体&内容
	private int x0;
	private int y0;
	private Font font;
	private String text;
	private double h;
	private  double w;
	private double x;
	private double y;
	private TextBoard tb;
	
	/**
	 * 
	 * @param x1 the left up x you wanna out
	 * @param y1 the left up y you wanna put 
	 * @param font1 the Font
	 * @param text1 the String you wanna write
	 * @param tb1 the TextBoard you use
	 */
	public GetPlace(int x1,int y1,Font font1,String text1,TextBoard tb1) {
		x0=x1;
		y0=y1;
		font=font1;
		text=text1;
		tb=tb1;
		GetStatic();
	}
	
	/**
	 * initialize the method and prepare the statics
	 */
	public void GetStatic() {
		//TextBoard tb = new TextBoard(2000, 2000, Color.pink);
		Rectangle2D r = tb.getBounds( text, font, x0,y0);
		x=r.getMinX();
		y=r.getMinY();
		h= r.getHeight();
		w= r.getWidth();
	}
	
	

		/**
		 * get the left up x you should write in
		 * @return
		 */
		public int getWX() {
			return (int)(y0-h);
		}
		
		/**
		 * get the left up y you should write in
		 * @return
		 */
		public int getWY() {
			return (int)(-1*x0);
		}
		
		public int getLUX() {
			return (int)x;
		}
		
		public int getLUY() {
			return (int)y;
		}
		/**
		 * get the output text's right down x
		 * @return
		 */
		public int getRDX() {
			return (int)(x+h);
		}
		
		/**
		 * get the output text's right down y
		 * @return
		 */
		public int getRDY() {
			return (int)(y+w);
		}
		
}
