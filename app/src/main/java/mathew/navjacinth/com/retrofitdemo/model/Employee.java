package mathew.navjacinth.com.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Navjacinth Mathew on 1/18/2017.
 */

public class Employee {
    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;

private Phone phone;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public class Phone {
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("home")
    private String home;
    @SerializedName("office")
    private String office;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "mobile='" + mobile + '\'' +
                ", home='" + home + '\'' +
                ", office='" + office + '\'' +
                '}';
    }

    public void setOffice(String office) {
        this.office = office;
    }
}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}