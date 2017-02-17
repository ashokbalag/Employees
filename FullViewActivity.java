package com.ashokbala.android.employees;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class FullViewActivity extends AppCompatActivity {


    TextView firstName,lastName,address,city,zipcode,gender,dob,designation,mobile,email,nationality,language,skills;
    ImageView imageURL;
    Bundle b;
    // Progress dialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        firstName=(TextView)findViewById(R.id.Emp_Fname);
        lastName=(TextView)findViewById(R.id.Emp_Lname);
        address=(TextView)findViewById(R.id.Emp_Add);
        city=(TextView)findViewById(R.id.Emp_City);
        zipcode=(TextView)findViewById(R.id.Emp_Pin);
        gender=(TextView)findViewById(R.id.Emp_Gen);
        dob=(TextView)findViewById(R.id.Emp_Dob);
        designation=(TextView)findViewById(R.id.Emp_Desc);
        mobile=(TextView)findViewById(R.id.Emp_Mob);
        email=(TextView)findViewById(R.id.Emp_Email);
        nationality=(TextView)findViewById(R.id.Emp_Nat);
        language=(TextView)findViewById(R.id.Emp_Lan);
        skills=(TextView)findViewById(R.id.Emp_Skill);
        imageURL=(ImageView)findViewById(R.id.imagefull);
        Show();
    }




    void Show()
    {
        firstName.setText(getIntent().getExtras().getString("Fname"));
        lastName.setText(getIntent().getExtras().getString("Lname"));
        dob.setText(getIntent().getExtras().getString("Dob"));
        gender.setText(getIntent().getExtras().getString("Gender"));
        address.setText(getIntent().getExtras().getString("Add"));
        city.setText(getIntent().getExtras().getString("City"));
        zipcode.setText(getIntent().getExtras().getString("zip"));
        designation.setText(getIntent().getExtras().getString("Des"));
        nationality.setText(getIntent().getExtras().getString("Nat"));
        email.setText(getIntent().getExtras().getString("Ema"));
        mobile.setText(getIntent().getExtras().getString("Mobi"));
        language.setText(getIntent().getExtras().getString("Lan"));
        skills.setText(getIntent().getExtras().getString("Skil"));
        String imgv=getIntent().getExtras().getString("img");
        Picasso.with(this).load(imgv)
                .placeholder(imageURL.getDrawable())
                .resize(150, 150)
                .into(imageURL);

        pDialog.dismiss();

    }
}
