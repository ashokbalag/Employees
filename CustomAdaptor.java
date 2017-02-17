package com.ashokbala.android.employees;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by ELANGOB on 2/15/2017.
 */
public class CustomAdaptor extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Employee> empItems;
    private List<Employee.Skill> Skillitem;
    //ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomAdaptor(Activity activity, List<Employee> empItems,List<Employee.Skill> SkillItems) {
        this.activity = activity;
        this.empItems = empItems;
        this.Skillitem = SkillItems;

    }

    @Override
    public int getCount() {
        return empItems.size();
    }

    @Override
    public Object getItem(int location) {
        return empItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row, null);

       /* if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);*/
        // Get the data item for this position
        final Employee user =empItems.get(position);

       final Employee.Skill user2=user.getSkills().get(0);
        // Check if an existing view is being reused, otherwise inflate the view

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Toast.makeText(activity,"Welcome"+position
                        +user.getFirstName()
                        +user.getLastName()
                        +user.getDob()
                        +user.getGender()
                        +user.getAddress()
                        +user.getCity()
                        +user.getZipcode()
                        +user.getDesignation()
                        +user.getNationality()
                        +user.getEmail()
                        +user.getLanguage()
                        +user.getMobile()
                        +user.getImageURL()

                        ,Toast.LENGTH_SHORT).show();*/

                Intent i=new Intent(activity.getApplicationContext(),FullViewActivity.class);
                Bundle extras = new Bundle();
                try {
                    extras.putString("Fname", user.getFirstName());
                    extras.putString("Lname", user.getLastName());
                    extras.putString("Dob", user.getDob());
                    extras.putString("Gender", user.getGender());
                    extras.putString("Add", user.getAddress());
                    extras.putString("City", user.getCity());
                    extras.putString("zip", user.getZipcode());
                    extras.putString("Des", user.getDesignation());
                    extras.putString("Nat", user.getNationality());
                    extras.putString("Ema", user.getEmail());
                    extras.putString("Mobi", user.getMobile());
                    extras.putString("Lan", user.getLanguage());
                    extras.putString("img", user.getImageURL());
                    extras.putString("Skil", user2.getTechnical().toString().replace('[', ' ').replace(']', ' ') + "\n" + user2.getExtraCurricular().toString().replace('[', ' ').replace(']', ' '));
                    i.putExtras(extras);
                    activity.startActivity(i);
                }catch (Exception e){}




            }
        });

        // Lookup view for data population
        TextView FName = (TextView) convertView.findViewById(R.id.Fname);
        TextView LName = (TextView) convertView.findViewById(R.id.LName);
        TextView Desc = (TextView) convertView.findViewById(R.id.Desc);
        TextView City = (TextView) convertView.findViewById(R.id.City);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.Img);
        // Populate the data into the template view using the data object
        FName.setText(user.getFirstName());
        LName.setText(user.getLastName());
        Desc.setText(user.getDesignation());
        City.setText(user2.getTechnical().toString());
        Picasso.with(activity).load(user.getImageURL())
                                .placeholder(imageView.getDrawable())
                                .resize(128, 128)
                                .into(imageView);



        // Return the completed view to render on screen
        return convertView;






    }


}