/*ФИО, должность, email, телефон, зарплата, возраст;*/

package Lesson5;

public class StaffCredential {
    String fullName;
    String position;
    String email;
    String telNum;
    int salary;
    int age;

    public StaffCredential(String fullName, String position, String email, String telNum, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telNum = telNum;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StaffCredential{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telNum='" + telNum + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
