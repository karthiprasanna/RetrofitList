package mathew.navjacinth.com.retrofitdemo.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mathew.navjacinth.com.retrofitdemo.R;
import mathew.navjacinth.com.retrofitdemo.adapter.EmployeeAdapter;
import mathew.navjacinth.com.retrofitdemo.model.Employee;
import mathew.navjacinth.com.retrofitdemo.model.EmployeeList;
import mathew.navjacinth.com.retrofitdemo.network.GetEmployeeDataService;
import mathew.navjacinth.com.retrofitdemo.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EmployeeAdapter adapter;
    private RecyclerView recyclerView;
    private Employee.Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Create handle for the RetrofitInstance interface*/
        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<EmployeeList> call = service.getEmployeeData();

        /*Log the URL called*/
        Log.e("URL Called", call.request().url() + "");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_employee_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
               // generateEmployeeList(response.body().getEmployeeArrayList());
                List<Employee> employees=response.body().getEmployeeList();

                for (int i=0;i<employees.size();i++) {

                    Log.e("movies","....."+employees.toString());
                    phone = employees.get(i).getPhone();
                    Log.e("phone","....."+employees.toString());
                }
                recyclerView.setAdapter(new EmployeeAdapter(employees, R.layout.row_employee, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
/*
    private void generateEmployeeList(ArrayList<Employee> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_employee_list);

        adapter = new EmployeeAdapter(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
*/
}
