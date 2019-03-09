package WordCloud;
public class Rectangle {

    private int lx;

    private int  ly;//����������

    private int  rx;//�����º�����

    private int  ry;//����������

    public int  getLx() {
return lx;
}

    public void setLx(int  lx) {
this.lx = lx;
}

    public int  getLy() {
return ly;
}

    public void setLy(int  ly) {
this.ly = ly;
}

    public int  getRx() {
return rx;
}

    public void setRx(int  rx) {
this.rx = rx;
}

    public int  getRy() {
return ry;
}

    public void setRy(int  ry) {
this.ry = ry;
}

    public Rectangle(int  x,int  y,int  w,int  h){
        this.setLx(x);
        this.setLy(y);
        this.setRx(w);
        this.setRy(h);
    }



    public boolean isBool(){
        return Math.abs(this.getRx()-this.getLx())>=Math.abs(this.getRy()-this.getLy());
    }

} 

