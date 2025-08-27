package ku.cs.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    @DisplayName("ทดสอบระบบ isID")
    void testIsID() {
        Student s = new Student("6710451399", "SirapobNoomthong");
        assertTrue(s.isId("6710451399"));
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        Student s = new Student("6710451399", "SirapobNoomthong");
        s.changeName("GehrmanSparrow");
        assertEquals("GehrmanSparrow", s.getName());
    }

    @Test
    @DisplayName("ทดสอบว่าชื่อตรงมั้ย")
    void testIsContains(){
        Student s = new Student("6710451399", "SirapobNoomthong");
        assertTrue(s.isNameContains("Sirapob"));
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 50.5 คะแนน")
    void testAddScore(){
        Student s = new Student("6710451399", "SirapobNoomthong");
        s.addScore(50.5);
        assertEquals(50.5, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6710451399", "SirapobNoomthong");
        s.addScore(85);
        assertEquals("A", s.getGrade());
    }



}