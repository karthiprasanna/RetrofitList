package mathew.navjacinth.com.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navjacinth Mathew on 1/18/2017.
 */

public class EmployeeList {
    @SerializedName("contacts")
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
