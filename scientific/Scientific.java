package scientific;

import java.util.Scanner;

/*
    Class To Implement Scientific Calculator Functions
    Functions Avalilable: 
    arccos  -> cos inverse
    arcsin  -> sin inverse
    arctan  -> tan inverse
    cos    
    cube    
    cuberoot
    factorial
    getEValue
    getInverse
    getPiValue
    ln      -> Natural Log Base e
    log     -> Log to base 10
    maximum -> Returns maximum of given element (overloaded)
    minimum -> Returns minimum of given element (overloaded)
    raiseTo -> return a^b
    sin
    square
    squareroot
    tan
*/

public class Scientific {
    Scanner in = new Scanner(System.in);
    public double sin(double val)
    {
        val = Math.toRadians(val);
        return Math.sin(val);
    }
    public double cos(double val)
    {
        val = Math.toRadians(val);
        return Math.cos(val);
    }
    public double tan(double val)
    {
        val = Math.toRadians(val);
        return Math.tan(val);
    }

    public double arcsin(double val)
    {
        val = Math.asin(val);
        val = Math.toDegrees(val);
        return val;
    }
    public double arccos(double val)
    {
        val = Math.acos(val);
        val = Math.toDegrees(val);
        return val;
    }
    public double arctan(double val)
    {
        val = Math.atan(val);
        val = Math.toDegrees(val);
        return val;
    }

    public double sqRoot(double val)
    {
        return Math.sqrt(val);
    }

    public double cubeRoot(double val)
    {
        return Math.cbrt(val);
    }

    public double square(double val)
    {
        return val*val;
    }
    public double cube(double val)
    {
        return val*val*val;
    }

    public double ln(double val)
    {
        return Math.log(val);
    }
    public double log(double val)
    {
        return Math.log10(val);
    }

    public double raiseTo(double base, double to)
    {
        return Math.pow(base, to);
    }

    public double maximum()
    {
        String element;
        double val;
        System.out.println("Enter Elements (Enter 'q' to Exit)");
        double max = in.nextDouble();
        while(((element = in.next()).charAt(0)) != 'q')
        {
            try{
                val = Double.parseDouble(element);
            }catch(NumberFormatException e){
                System.out.println("NaN");
                continue;
            }
            if(val > max)
            {
                max = val;
            }
        }
        return max;
    }

    public double maximum(double arr[])
    {
        double max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    public double maximum(int arr[])
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    public double minimum()
    {
        String element;
        double val;
        System.out.println("Enter Elements...");
        double min = in.nextDouble();
        while(((element = in.next()).charAt(0)) != 'q')
        {
            try{
                val = Double.parseDouble(element);
            }catch(NumberFormatException e){
                System.out.println("NaN");
                continue;
            }
            if(val < min)
            {
                min = val;
            }
        }
        return min;
    }

    public double minimum(double arr[])
    {
        double min = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
    }

    public long factorial(long val)
    {
        if(val >= 1)
            return val*factorial(val-1);
        return 1;
    }

    public double getPiValue()
    {
        return Math.PI;
    }

    public double getEValue()
    {
        return Math.E;
    }

    public double getInverse(double val)
    {
        return (1/val);
    }
}