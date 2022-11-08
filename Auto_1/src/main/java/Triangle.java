import java.util.Scanner;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public String determineType() {
        String output = "";
        if(negativy(a,b,c))
            output="Введено отрицательное значение";
        else if (!exists(a, b, c)) {
            output="Введенные значения не могут быть сторонами треугольника, так как сумма двух сторон должна быть больше третьей";
        } else if(equilateral(a,b,c)) {
            output="Треугольник равносторонний";
        } else if(versatile(a,b,c)) {
            output="Треугольник разносторонний";
        } else if (isosceles(a,b,c)) {
            output="Треугольник равнобедренный";
        }
               return output;
    }

    static boolean exists (int a, int b, int c) // проверка на существование треугольника
    {
        return (a+b > c && b+c>a && c+a>b);

    }

    static boolean negativy (int a, int b, int c) // проверка на Отрицательные значения
    {
            return (a<=0 || b<=0 || c<=0);
           }

    static boolean equilateral (int a, int b, int c) // проверка на равносторонность
    {
        return(a==b && b==c);

    }

    static boolean versatile (int a, int b, int c) // проверка на разносторонность
    {
        return (a!=b && b!=c && c!=a);

    }

    static boolean isosceles (int a, int b, int c) // проверка на равнобедренность
    {
        return((a==b && b!=c ) || (a!=b && c==a) || (c==b && c!=a));

    }
    public static void main(String [] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите занчение сторон треугольника (целые неотрицательные числа)");
            System.out.print("Сторона а: ");
            int a = in.nextInt();
            System.out.print("Сторона b: ");
            int b = in.nextInt();
            System.out.print("Сторона c: ");
            int c = in.nextInt();
            Triangle t = new Triangle(a, b, c);
            System.out.println(t.determineType());

        }
        catch (Exception e)
        {

            System.out.println("Введенное занчение не удовлетворяют условию ввода");
        }
    }
}
