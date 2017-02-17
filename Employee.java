package com.ashokbala.android.employees;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;



/**
 * Created by ELANGOB on 2/15/2017.
 */

public class Employee  {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = null;


    @SerializedName("employee")
    @Expose
    private List<Employee> employee = null;


    /**
     * No args constructor for use in serialization
     */
    public Employee() {
    }

    /**
     * @param skills
     * @param lastName
     * @param zipcode
     * @param designation
     * @param city
     * @param id
     * @param nationality
     * @param address
     * @param email
     * @param dob
     * @param gender
     * @param language
     * @param firstName
     * @param imageURL
     * @param mobile
     */
    public Employee(String id, String firstName, String lastName, String address, String city, String zipcode, String gender, String dob, String designation, String mobile, String email, String nationality, String language, String imageURL, List<Skill> skills) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.gender = gender;
        this.dob = dob;
        this.designation = designation;
        this.mobile = mobile;
        this.email = email;
        this.nationality = nationality;
        this.language = language;
        this.imageURL = imageURL;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }



    public class Skill {

        @SerializedName("technical")
        @Expose
        private List<String> technical = null;
        @SerializedName("extra_curricular")
        @Expose
        private List<String> extraCurricular = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public Skill() {
        }

        /**
         *
         * @param extraCurricular
         * @param technical
         */
        public Skill(List<String> technical, List<String> extraCurricular) {
            super();
            this.technical = technical;
            this.extraCurricular = extraCurricular;
        }

        public List<String> getTechnical() {
            return technical;
        }

        public void setTechnical(List<String> technical) {
            this.technical = technical;
        }

        public Skill withTechnical(List<String> technical) {
            this.technical = technical;
            return this;
        }

        public List<String> getExtraCurricular() {
            return extraCurricular;
        }

        public void setExtraCurricular(List<String> extraCurricular) {
            this.extraCurricular = extraCurricular;
        }

        public Skill withExtraCurricular(List<String> extraCurricular) {
            this.extraCurricular = extraCurricular;
            return this;
        }



    }



}



