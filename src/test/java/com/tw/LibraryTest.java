package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
    }

    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }

    @Test
    public void testWhenInputFirstReturnInputInfo() {
        String answer = library.accept(1);
        assertEquals("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：", answer);
    }

    @Test
    public void testWhenInputStudentInfoSuccess() {
        String info = "常卉, 001, 语文: 80";
        String saveStudentInfo = library.saveStudentInfo(info);
        assertEquals("学生xxx的成绩被添加", saveStudentInfo);
    }

    @Test
    public void testWhenInputStudentInfoFailed() {
        String info = "常卉, 001, 语文, 80";
        String saveStudentInfo = library.saveStudentInfo(info);
        assertEquals("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）", saveStudentInfo);
    }
}
