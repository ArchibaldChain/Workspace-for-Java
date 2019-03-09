package Week4;

public class TimeComplexityTest {

    public static void main(String[] args) {
        int[] a = {3,4,-4,5,-6,3,9,-4,9,-2,9,5,-3,-9,10};


        System.out.println(Algorithm1N3(a));
        System.out.println(Algorithm2N2(a));
        System.out.println(Algorithm3(a));
        System.out.println(Algorithm4(a));
    }

    static int Algorithm1N3(int[] a){
        int max = a[0], temp, count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                temp = 0;
                for (int k = i; k <= j; k++) {
                    temp += a[k];
                    count++;
                }
                if(temp>max)
                    max = temp;
            }
        }
        System.out.println("Time cost:"+count);
        return max;
    }

    static int Algorithm2N2(int[] a){
        int max = a[0], temp, count = 0;
        for (int i = 0; i < a.length; i++) {
            temp = 0;
            for (int j = i; j < a.length; j++) {
                temp += a[j];
                count ++;
                if(temp > max)
                    max = temp;
            }
        }
        System.out.println("Time cost:"+count);
        return max;
    }

    static int[] a;
    static int count;
    static int Algorithm3(int[] number){
        a = number;
        count = 0;

        int x =  DivideConquor(0, a.length-1);
        System.out.println("Time cost:"+count);
        return x;

    }


    static int DivideConquor(int l, int r){
        count++;

        int temp = 0;
        if(l == r){
            return a[l];
        }
        int mid = (l+r)/2;
        int leftMax = a[mid];
        int rightMax = a[mid+1];
        int maxLeft = DivideConquor(l, mid);
        int maxRight = DivideConquor(mid + 1, r);
        for (int i = mid; i >= l; i--) {
            temp += a[i];
            if (leftMax < temp)
                leftMax = temp;
        }
        temp = 0;
        for (int i = mid+1; i <= r; i++) {
            temp += a[i];
            if (rightMax < temp)
                rightMax = temp;
        }


        return Math.max(rightMax + leftMax, Math.max(maxLeft,maxRight));
    }

    private static int Algorithm4(int[] number){
        int max = number[0], temp = 0,count = 0;
        for (int i = 0; i < number.length; i++) {
            temp += number[i];
            if (temp > max){
                max = temp;
            }
            if(temp<0)
                temp = 0;
            count ++;
        }
        System.out.println("Time cost:"+count);
        return max;
    }

}

