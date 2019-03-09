package WordCloud;

public class Rect { 
    private float x1; 
    private float y1; 
    private float x2; 
    private float y2; 

    public Rect(float x1, float y1, float x2, float y2) 
    { 
       
        float tmp; 
        if(x1 > x2) 
        { 
            tmp = x1; 
            x1 = x2; 
            x2 = tmp; 
        } 

        if(y1 > y2) 
        { 
            tmp = y1; 
            y1 = y2; 
            y2 = tmp; 
        } 

        this.x1 = x1; 
        this.y1 = y1; 
        this.x2 = x2; 
        this.y2 = y2; 
    } 


    private boolean isPointInner(float x, float y) {
        if(x >=  x1 && x <= x2 && y >=  y1 && y <= y2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public float getLeftTopX() {
	return x1;
	} 
    public float getLeftTopY() {
	return y1;
	} 
    public float getRightBottomX() {
	return x2;
	} 
    public float getRightBottomY() {
	return y2;
	} 


    public boolean isRectIntersect(Rect rect) {
    return (
    		isPointInner(rect.getLeftTopX(), rect.getLeftTopY()) || 
            isPointInner(rect.getLeftTopX(), rect.getRightBottomY()) || 
            isPointInner(rect.getRightBottomX(), rect.getLeftTopY()) || 
            isPointInner(rect.getRightBottomX(), rect.getRightBottomY())
            )
    		; 
    }

    public static boolean Rect(float x1, float y1, float x2, float y2 ,float x3, float y3, float x4, float y4) {
        Rect rect1 = new Rect(x1, y1, x2,y2 );
        Rect rect2 = new Rect(x3, y3, x4, y4);
        if ((y1 <= y3 & y2 >= y4 & x2 <= x4 & x1 >=x3)
    		| (y3 <= y1 & y4>= y2 & x4 <=x2 & x3 >= x1)) {
        return true;
        }
        return   (rect1.isRectIntersect(rect2) || rect2.isRectIntersect(rect1));
    }
    public static void main(String[] args) {
		System.out.println(Rect(1,1,4,4,1,3,4,5));
}


}
