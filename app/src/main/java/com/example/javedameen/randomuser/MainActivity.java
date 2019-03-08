package com.example.javedameen.randomuser;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.javedameen.randomuser.model.RandomUsers;
import com.example.javedameen.randomuser.ui.MainActivityContract;
import com.example.javedameen.randomuser.ui.fragment.UserDetailFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainActivityContract.View, UserDetailFragment.OnFragmentInteractionListener {

    @Inject
    MainActivityContract.Presenter mPresenter;

    private EditText userId;
    private EditText numOfUsers;
    private Spinner dropdown;
    private Button btnQuery;

    public DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout) findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.queryUser){
                    Toast.makeText(MainActivity.this,"Query User Selected",Toast.LENGTH_LONG).show();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragmentContainer, UserDetailFragment.newInstance("Javed","Shaikh"))
                            .commitAllowingStateLoss();
                    dl.closeDrawer(Gravity.LEFT);
                }else if (id == R.id.viewStoredUser){
                    Toast.makeText(MainActivity.this,"View Stored User Seleted",Toast.LENGTH_LONG).show();
                }else if (id == R.id.exit){
                    Toast.makeText(MainActivity.this,"Exit Seleted",Toast.LENGTH_LONG).show();
                    dl.closeDrawer(Gravity.LEFT);
                }
                return false;
            }
        });


        init();

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sex = parent.getItemAtPosition(position).toString();
                if(!sex.trim().equals("Select")){
                    mPresenter.getRandomUsersOnGender(sex);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = userId.getText().toString();
                String numUsers = numOfUsers.getText().toString();
                if(uid != null && uid.length()>0){
                    mPresenter.getRandomUser(Integer.parseInt(uid));
                }else if(numUsers != null && numUsers.length()>0){
                    mPresenter.getRandomUsersMultiple(Integer.parseInt(numUsers));
                }
            }
        });


    }

    private void init(){
        dropdown = (Spinner) findViewById(R.id.dropdown);
        userId = (EditText) findViewById(R.id.userId);
        numOfUsers = (EditText) findViewById(R.id.numOfUsers);
        btnQuery = (Button) findViewById(R.id.btnQuery);

        String[] items = new String[]{
                getString(R.string.Select),
                getString(R.string.Male),
                getString(R.string.Female)
                                    };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    @Override
    public void showResult(RandomUsers result) {
        if(result != null){
            Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) ||super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
