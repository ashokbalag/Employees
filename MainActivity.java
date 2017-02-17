package com.ashokbala.android.employees;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String JSON_URL = "https://private-2a004-androidtest3.apiary-mock.com/employeesList";

    RequestQueue mRequestQueue;
    ListView listView;
    List<Employee> EmpList = new ArrayList<Employee>();


    List<Employee.Skill> SkillList = new ArrayList<Employee.Skill>();
    CustomAdaptor customAdaptor;

    // Progress dialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.mList);

        customAdaptor = new CustomAdaptor(this, EmpList,SkillList);
        listView.setAdapter(customAdaptor );

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 2048 * 2048); // 1MB cap
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
        // Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);
        //Instantiate the RequestQueue.
        mRequestQueue = Volley.newRequestQueue(this);
        // Start the queue
        mRequestQueue.start();
        makeJsonObjectRequest();
        showpDialog();

    }


    @Override
    protected void onStart() {
        super.onStart();


    }





    private void makeJsonObjectRequest() {



        final JsonArrayRequest jsonArrReq = new JsonArrayRequest(Request.Method.GET,
                JSON_URL, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response1) {


                //Log.d("Data", response.toString());
                try {
                    JSONObject jresponse = response1.getJSONObject(0);
                    JSONArray jarray = jresponse.getJSONArray("employee");
                    //Log.e("nickname2",jresponse.toString());
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    // Converts JSON string into a collection of Student object.

                    //for(int i=0;i<jarray.length();i++)
                   /// {
                        JSONObject response = jarray.getJSONObject(0);
                        JSONArray skill= response.getJSONArray("skills");
                       // JSONObject Subresponse = skill.getJSONObject(0);
                             Type type = new TypeToken<List<Employee>>() {}.getType();
                             List<Employee> studentList = gson.fromJson(jarray.toString(), type);
                            Type type0 = new TypeToken<List<Employee.Skill>>(){}.getType();
                            ArrayList<Employee.Skill> list = gson.fromJson(skill.toString(), type0);
                            for(int i=0;i<studentList.size();i++) {
                                //for (Employee employee : studentList) {
                                System.out.println("Test :" + studentList.get(i).getFirstName());
                                EmpList.add(studentList.get(i));
                                System.out.println(list.get(0).getExtraCurricular().toString().replace('[',' ').replace(']',' '));
                                System.out.println(list.get(0).getTechnical().toString().replace('[',' ').replace(']',' '));
                                SkillList.add(list.get(0));
                                System.out.println("Test :"+studentList.size()+" "+list.size());
                            }

                           /* for (Employee.Skill p : list) {
                                System.out.println(p.getExtraCurricular().toString().replace('[',' ').replace(']',' '));
                                System.out.println(p.getTechnical().toString().replace('[',' ').replace(']',' '));
                                SkillList.add(p);

                            }*/
                    customAdaptor.notifyDataSetChanged();
                    // }


                  /*  for(int i=0;i<jarray.length();i++)
                    {
                        JSONObject response = jarray.getJSONObject(i);
                        JSONArray skill= response.getJSONArray("skills");
                        JSONObject Subresponse = skill.getJSONObject(0);
                        JSONArray Sub1skill= Subresponse.getJSONArray("extra_curricular");
                        JSONArray Sub2skill= Subresponse.getJSONArray("technical");
                        Gson gson = new Gson();
                        Employee result = gson.fromJson(jarray.toString(), Employee.class);
                        Employee.Skill result1 = gson.fromJson(skill.toString(), Employee.Skill.class);
                        Log.e("TEST",result1.getExtraCurricular().toString());
                        Log.e("nickname2",result.getLastName());
                        Type type0 = new TypeToken<List<Employee.Skill>>(){}.getType();
                        ArrayList<Employee.Skill> list = gson.fromJson(skill.toString(), type0);
                            for (Employee.Skill p : list) {
                               for(int j=0;j<Sub1skill.length();j++)
                                System.out.println(p.getExtraCurricular().get(j).toString()+p.toString());
                                for(int j=0;j<Sub2skill.length();j++)
                                System.out.println(p.getTechnical().get(j).toString());
                            }
                        System.out.println(result.getSkills());
                        EmpList.add(result);
                        customAdaptor.notifyDataSetChanged();
                        //Log.e("nickname",result.getFirstName()+result.getDesignation()+result1.toString());
                        //Log.e("Test:",result1.getTechnical().toString());
                        // Parsing json object response
                        // response will be a json object
                       /* String id = response.getString("id");
                        String firstName = response.getString("firstName");
                        String lastName = response.getString("lastName");
                        String address = response.getString("address");
                        String city = response.getString("city");
                        String zipcode = response.getString("zipcode");
                        String gender = response.getString("gender");
                        String dob = response.getString("dob");
                        String mobile = response.getString("mobile");
                        String email = response.getString("email");
                        String designation = response.getString("designation");
                        String nationality = response.getString("nationality");
                        String language = response.getString("language");
                        String imageURL = response.getString("imageURL");
                        //String skill = response.getString("skills");
                        JSONArray skill= response.getJSONArray("skills");
                        JSONObject Subresponse = skill.getJSONObject(0);
                        JSONArray technicalArray= Subresponse.getJSONArray("technical");
                        JSONArray extra_curricularArray= Subresponse.getJSONArray("extra_curricular");
                        StringBuilder buffer1=new StringBuilder();
                        StringBuilder buffer2=new StringBuilder();
                        for(int j=0;j<technicalArray.length();j++) {
                            String technical = technicalArray.getString(j).toString();
                            buffer1.append(technical).append(" ");
                        }
                        for(int j=0;j<extra_curricularArray.length();j++) {
                            String extra_curricular = extra_curricularArray.getString(j).toString();
                            buffer2.append(extra_curricular).append(" ");;
                            // Log.e("nickname",technical+extra_curricular);
                        }*/




                       // Log.e("nickname",id+firstName+lastName+address+city+zipcode+gender+dob+mobile+email+designation+nationality+language+imageURL+buffer1.toString()+buffer2.toString());


                    //}
                    hidepDialog();
                }catch (JSONException e) {
                    e.printStackTrace();
                    hidepDialog();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Data", "Error: " + error.getMessage());
                /*Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();*/
                // hide the progress dialog
                hidepDialog();
            }


        });

        // Adding request to request queue
        //AppController.getInstance().addToRequestQueue(jsonObjReq);

        // Add the request to the RequestQueue.
        mRequestQueue.add(jsonArrReq);

    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
