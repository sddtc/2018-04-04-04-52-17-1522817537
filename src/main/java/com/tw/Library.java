package com.tw;

import java.util.regex.Pattern;

public class Library {
    
    public boolean someLibraryMethod() {
        return true;
    }

    public String accept(int commandNumber) {
        if(1 == commandNumber) {
            return "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";
        }
        return null;
    }

    public String saveStudentInfo(String studentInfo) {
        String regex = "([\\u4e00-\\u9fa5]*,(\\s*)){1}(\\d*),(\\s*)([\\u4e00-\\u9fa5]+:)(\\s*)(\\d*)";
        boolean isStudentInfoMatch = Pattern.matches(regex, studentInfo);
        if(isStudentInfoMatch) {
            return "学生xxx的成绩被添加";
        } else {
            return "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）";
        }
    }
}
