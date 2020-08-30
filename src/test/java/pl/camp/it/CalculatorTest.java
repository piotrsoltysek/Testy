package pl.camp.it;

import org.junit.*;

public class CalculatorTest {
    static Calculator calculator;

    public CalculatorTest() {
        System.out.println("Konstruktor");
    }

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
        System.out.println("BeforeClass !!");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void before() {
        System.out.println("Before !!");//żeby przygotować się do testu
    }

    @After
    public void after() {
        System.out.println("After !!");//żeby posprzątać po teście
    }


    @Test
    public void addTwoPositivesTest() {
        //scenariusz testowy, założenia
        int a = 5;
        int b = 7;
        int expectedResult = 12;

        //wykonanie testu
        int result = calculator.add(a, b);

        //sprawdzenie
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void addTwoNegativesTest() {
        int a = -5;
        int b = -7;
        int expectedResult = -12;

        int result = calculator.add(a, b);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void subtractTwoPositivesTest() {
        int a = 5;
        int b = 2;
        int expectedResult = 3;

        int result = calculator.subtract(a, b);

        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void divideTwoPositives() {
        int a = 7;
        int b = 2;
        double expectedResult = 3.5;

        double result = calculator.divide(a, b);

        Assert.assertEquals(expectedResult, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZeroTest() {
        int a = 4;
        int b = 0;
        double expectedResult = 0;

        double result = calculator.divide(a, b);
    }
}
