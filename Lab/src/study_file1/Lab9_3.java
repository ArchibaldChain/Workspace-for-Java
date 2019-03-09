package study_file1;

public class Lab9_3 {
    public  static  void main(String[] args) {
        String str1;
        StringBuilder str2;
        StringBuffer str3;
        long current1=System.currentTimeMillis();
        str1 = testString ();
        long current2=System.currentTimeMillis();
        System. out .println("Using String: "+(current2-current1));
        current1 = System. currentTimeMillis ();
        str2 = testStringBuilder ();
        current2=System. currentTimeMillis ();
        System. out .println("Using StringBuilder: "+(current2-current1));
        current1 = System. currentTimeMillis ();
        str3 = testStringBuffer ();
        current2 = System.currentTimeMillis ();
        System. out .println("Using StringBuffer: "+(current2-current1));
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);
    }

    static final int SIZE = 50000;
    static final int RANGE =100000;

    public  static  void testInteger(){

        for( int i=1;i<= SIZE ; i++)
        {
            System. out .print( (int)(Math. random ()* RANGE )+"\n");
            if(i%10==0)
            {
                System. out .println();
            }
        }
    }

    public  static String testString(){
        String str = "";
        for( int i=1;i<= SIZE ; i++)
        {
            str += (int)(Math.random()*RANGE) + "\n";
        }
        return str;
    }
    public  static StringBuilder testStringBuilder(){
        StringBuilder str = new StringBuilder();
        for( int i=1;i<= SIZE ; i++)
        {
            str.append((int)(Math.random()*RANGE) + "\n");
        }
        return str;
    }
    public  static StringBuffer testStringBuffer() {
        StringBuffer str = new StringBuffer();
        for( int i=1;i<= SIZE ; i++)
        {
            str.append((int)(Math.random()*RANGE) + "\n");
        }
        return str;
    }
}
