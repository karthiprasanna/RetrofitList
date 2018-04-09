package mathew.navjacinth.com.retrofitdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mathew.navjacinth.com.retrofitdemo.R;
import mathew.navjacinth.com.retrofitdemo.model.Employee;

/**
 * Created by Navjacinth Mathew on 1/18/2017.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> dataList;

    public EmployeeAdapter(ArrayList<Employee> dataList) {
        this.dataList = dataList;
    }

    public EmployeeAdapter(List<Employee> employees, int row_employee, Context applicationContext) {
this.dataList=employees;

    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        holder.txtEmpName.setText(dataList.get(position).getName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmail());
        holder.txtEmpPhone.setText(dataList.get(position).getId());
        holder.txtEmpMobile.setText(dataList.get(position).getPhone().getMobile());
        holder.txtEmpHome.setText(dataList.get(position).getPhone().getHome());
        holder.txtEmpOffice.setText(dataList.get(position).getPhone().getOffice());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail, txtEmpPhone,txtEmpMobile, txtEmpHome, txtEmpOffice;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            txtEmpName = (TextView) itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail = (TextView) itemView.findViewById(R.id.txt_employee_email);
            txtEmpPhone = (TextView) itemView.findViewById(R.id.txt_employee_phone);

            txtEmpMobile = (TextView) itemView.findViewById(R.id.txt_employee_mobile);
            txtEmpHome = (TextView) itemView.findViewById(R.id.txt_employee_home);
            txtEmpOffice = (TextView) itemView.findViewById(R.id.txt_employee_office);
        }
    }
}