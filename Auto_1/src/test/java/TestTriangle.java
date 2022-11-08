
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTriangle {
  private Triangle triangle =new Triangle(0,0,0);


  @Test(dataProvider = "isNegativy")
  public void testIsNegativy(boolean actualResult, boolean expectedResult)  {

      Assert.assertEquals(actualResult, expectedResult, "НЕ пройден тест на определение положительного числа");
  }

    @Test(dataProvider = "noExists")
    public void testNoExists(boolean actualResult, boolean expectedResult){
        Assert.assertEquals(actualResult, expectedResult, "НЕ пройден тест на определение возможности треугольника");
    }

    @Test(dataProvider = "isEquilateral")
    public void testIsEquilateral(boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "НЕ пройден тест равностороннего треугольника");
    }

    @Test(dataProvider = "isVersatile")
    public void testIsVersatile(boolean actualResult, boolean expectedResult) {
           Assert.assertEquals(actualResult, expectedResult, "НЕ пройден тест разностороннего треугольника");
    }

    @Test(dataProvider = "isIsosceles")
    public void testIsIsosceles(boolean actualResult, boolean expectedResult)  {
        Assert.assertEquals(actualResult, expectedResult, "НЕ пройден тест равнобедренность треугольника");
    }

@BeforeTest
public void setUp() {
    triangle=new Triangle(0, 0, 0);
}


@DataProvider()
public Object[][] isNegativy() {
    return new Object[][] {
            {triangle.negativy(0, 1, 10),true},
            {triangle.negativy(10,0,1),true},
            {triangle.negativy(1,10,0),true},
            {triangle.negativy(-4,1,1),true},
            {triangle.negativy(1,-4,1),true},
            {triangle.negativy(1,1,-4),true},
    };}
    @DataProvider()
    public Object[][] noExists() {
        return new Object[][] {
                {triangle.exists(1,2,3),false},
                {triangle.exists(1,3,2),false},
                {triangle.exists(2,1,3),false},
                {triangle.exists(2,3,1),false},
                {triangle.exists(3,2,1),false},
                {triangle.exists(3,1,2),false},
        };}
    @DataProvider()
    public Object[][] isEquilateral() {
        return new Object[][] {
                {triangle.equilateral(1,1,1),true},
                {triangle.equilateral(2,2,2),true},
                {triangle.equilateral(3,3,3),true},

        };}
    @DataProvider()
    public Object[][] isVersatile() {
        return new Object[][] {
                {triangle.versatile(4,5,6),true},
                {triangle.versatile(4,6,5),true},
                {triangle.versatile(5,4,6),true},
                {triangle.versatile(5,6,4),true},
                {triangle.versatile(6,4,5),true},
                {triangle.versatile(6,5,4),true},
        };}
    @DataProvider()
    public Object[][] isIsosceles() {
        return new Object[][] {
                {triangle.isosceles(100,100,99),true},
                {triangle.isosceles(99,100,100),true},
                {triangle.isosceles(100,99,100),true},


        };}
}
