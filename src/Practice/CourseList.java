package Practice;

import java.util.ArrayList;

public class CourseList {

    ArrayList<Course> courses;

    CourseList() {
        courses = new ArrayList<>();
    }

    public static void main(String[] args) {
        Course c1 = new Course("Programming 1", "C123");
        Course c2 = new Course("Web Programming", "C456");
        Course c3 = new Course("Data Structures", "C789");
        Course c4 = new Course("Database Application", "C000");
        CourseList list = new CourseList();
        list.addCourse(c1);
        list.addCourse(c2);
        list.addCourse(c3);
        list.addCourse(c4);
        list.addPrerequisite(c2, c1);  // make Programming 1 a prerequisite of Web Programming
        list.addPrerequisite(c3, c1);  // make Programming 1 a prerequisite of Data Structures
        list.addPrerequisite(c4, c2);  // make Web Programming a prerequisite of Database Application
        System.out.println(list.takeFirst(c1));  // true
        System.out.println(list.takeFirst(c3));  // false
        System.out.println(list.coursesTaken());
    }

    public String coursesTaken() {
        StringBuilder result = new StringBuilder();
        int n = 0;
        while (n < courses.size()) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).prerequisite.size() == 0) {
                    n++;
                    if (result.length() == 0) {
                        result.append(courses.get(i).name);
                    } else {
                        result.append(", ").append(courses.get(i).name);
                    }

                    for (int j = 0; j < courses.size(); j++) {
                        if (i == j) {
                            continue;
                        }
                        courses.get(j).prerequisite.remove(courses.get(i));
                    }
                }
            }
        }
        return result.toString();
    }

    public boolean takeFirst(Course c) {
        return c.prerequisite.size() == 0;
    }

    public void addPrerequisite(Course c, Course pre) {
        c.prerequisite.add(pre);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    static class Course {
        String name;
        String code;
        ArrayList<Course> prerequisite;

        Course(String name, String code) {
            this.name = name;
            this.code = code;
            prerequisite = new ArrayList<>();
        }
    }

}
