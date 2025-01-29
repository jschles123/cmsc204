import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

public class GradeBookTest {

    private GradeBook g1;
    private GradeBook g2;

    @BeforeEach
    public void setUp() {
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        for(int i = 6; i < 10; i++){
            g1.addScore(i * 10);
        }
        for(int i = 80; i < 100; i += 5){
            g2.addScore(i);
        }
    }
    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    @Test
    public void addScoreTest(){
        g1.addScore(100);
        g2.addScore(100);
        assertEquals("60.0 70.0 80.0 90.0 100.0 ", g1.toString());
        assertEquals("80.0 85.0 90.0 95.0 100.0 ", g2.toString());
    }

    @Test
    public void sumTest(){
        assertEquals(300,g1.sum(),.0001);
        assertEquals(350,g2.sum(),.0001);
    }

    @Test
    public void minimumTest(){
        assertEquals(60,g1.minimum(),.0001);
        assertEquals(80,g2.minimum(),.0001);
    }

    @Test
    public void finalScoreTest(){
        assertEquals(240,g1.finalScore(),.0001);
        assertEquals(270,g2.finalScore(),.0001);
    }

    @Test
    public void getScoreSizeTest(){
        assertEquals(5,g1.getScoreSize(),.0001);
        assertEquals(5,g2.getScoreSize(),.0001);
    }

    @Test
    public void toStringTest(){
        assertTrue(g1.toString().equals("60.0 70.0 80.0 90.0 "));
        assertTrue(g2.toString().equals("80.0 85.0 90.0 95.0 "));
    }
}