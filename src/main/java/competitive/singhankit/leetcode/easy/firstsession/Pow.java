package competitive.singhankit.leetcode.easy.firstsession;

/**
 * @author _singhankit
 */
public class Pow {
    public static void main(String[] args) {
       // System.out.println(new Pow().myPow(2.00,10));
        //System.out.println(new Pow().myPow(.004538,0));
       System.out.println(new Pow().myPow(2,10));

     //  System.out.println(new Pow().pow2(.00001,2147483647));
   //    System.out.println(new Pow().myPow(2,-2));
//       System.out.println(new Pow().myPow(2,-2147483648));
//       System.out.println(Math.pow(2,-2147483648));
     //  System.out.println(new Pow().myPow(0.00001,2147483647));
      // System.out.println(Math.pow(0.00001,2147483647));
    }

    public double myPow(double x, int n) {
         if(n==Integer.MIN_VALUE)
             n=Integer.MAX_VALUE;
        int i=n;
         if(n<0)
          i=-n;

        double r=myPow(x,x,i);
      if(n<0)
          return 1/r;
      return r;
    }

    public double myPow(double x,double base ,int n){
        if(x>Double.MAX_VALUE)
            return 0;
        if(n==0)
            return 1;
        if(n<2)
            return x;
        return myPow(base*x,base,--n);
    }

//    public double myPow1(double x, int n) {
//        if (n == 0)
//            return 1;
//
//        int i=n;
//        n=Math.abs(n);
//        double ret = myPow1(x, n / 2);
//        ret = ret * ret;
//       // if (n % 2 != 0)
//         //   ret = ret * x;
//
//        if (i < 0) {
//           return 1/ret;
//        }
//        return ret;
//    }

//    public  double pow2(double base, int exp){
//        if(base>Double.MAX_VALUE)
//            return 0;
//        if(exp ==0){
//            return 1;
//        }
//        if(exp ==1){
//            return base;
//        }
//
//        if(exp % 2 == 0){
//            double half = pow2(base, exp/2);
//            return half * half;
//        }else{
//            double half = pow2(base, (exp -1)/2);
//            return base * half * half;
//        }
//    }
}
