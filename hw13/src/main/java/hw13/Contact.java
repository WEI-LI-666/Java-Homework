package hw13;

import java.util.Date;

public class Contact implements Comparable<Contact> {
    private String name;
    private String phone;
    private String email;
    private Date birthday;

    public Contact(String name, String phone, String email, Date birthday) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int compareTo(Contact o) {
        return (this.name.compareTo(o.name));
    }
}
