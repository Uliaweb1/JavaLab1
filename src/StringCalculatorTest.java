//Junit5 tests for StringCalculator
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @org.junit.jupiter.api.Test
    void step1() {
        assertEquals(0, StringCalculator.Add(""), "Empty case");
        assertEquals(1, StringCalculator.Add("1"), "Trivial case");
        assertEquals(3, StringCalculator.Add("1,2"), "Single separator");
    }
    @org.junit.jupiter.api.Test
    void step2() {
        assertEquals(55, StringCalculator.Add( "1,2,3,4,5,6,7,8,9,10"), "Multiple numbers");
    }

    @org.junit.jupiter.api.Test
    void step3() {
        assertEquals(6, StringCalculator.Add("1\n2,3"), "Different separators");
        assertEquals(1, StringCalculator.Add("1,\n"), "Multiple separators without numbers");
    }

    @org.junit.jupiter.api.Test
    void step4() {
        assertEquals(3, StringCalculator.Add("//;\n1;2"), "Test failed");
    }

    @org.junit.jupiter.api.Test
    void step5() {
       // ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
            assertEquals(0, StringCalculator.Add("-11"), "Test failed");
        //});
       // Assertions.assertEquals("some message", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void step6() {
        assertEquals(1999, StringCalculator.Add("1000,999,1001"), "Test failed");
    }

    @org.junit.jupiter.api.Test
    void step7() {
        assertEquals(6, StringCalculator.Add("//[**]\n1**2**3"), "Test failed");
    }

    @org.junit.jupiter.api.Test
    void step8() {
        assertEquals(6, StringCalculator.Add("//[*][%]\n1*2%3"), "Test failed");
    }

    @org.junit.jupiter.api.Test
    void step9() {
        assertEquals(21, StringCalculator.Add("//[*][***][**]\n1*2***3**4,5\n6"), "Test failed");
        assertEquals(1012, StringCalculator.Add("//[*][%][$+$]\n1*3$+$2%1000,1001\n6"), "Test failed");
        assertEquals(55, StringCalculator.Add("//[*][%][Q][E]\n1Q2E3Q4E5Q6E7Q8E9Q10"), "Test failed");
    }
}
