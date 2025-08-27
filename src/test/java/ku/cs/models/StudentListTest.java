package ku.cs.models;

import static org.junit.jupiter.api.Assertions.*;
import ku.cs.services.StudentListHardCodeDatasource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentListTest {

    private StudentList slist;

    @BeforeEach
    void setUp(){
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        slist = datasource.readData();
    }

    @Test
    @DisplayName("เพิ่มนักเรียนไม่มีคะแนน + ลอง filter")
    void testAddNoScore(){
        slist.addNewStudent("6710400007", "Primmie");
        assertNotNull(slist.findStudentById("6710400007"));

        slist.addNewStudent("6710400007", "Plammy");
        StudentList filter = slist.filterByName("Plammy");
        assertNull(filter.findStudentById("6710400007"));
    }

    @Test
    @DisplayName("เพิ่มนักเรียนมีคะแนน")
    void testAddWithScore(){
        slist.addNewStudent("6710400006", "Primmie", 130);
        assertNotNull(slist.findStudentById("6710400006"));
    }

    @Test
    @DisplayName("หาด้วย ID")
    void testFindByID(){
        assertNotNull(slist.findStudentById("6710400009"));
        assertNull(slist.findStudentById("0123456789"));
    }

    @Test
    @DisplayName("ให้คะแนนแล้วดูเกรด")
    void testGiveScoreAndGrade(){
        slist.addNewStudent("6710400007", "Primmie", 30);
        slist.giveScoreToId("6710400007", 50);
        assertNotNull(slist.viewGradeOfId("6710400007"));
    }
}