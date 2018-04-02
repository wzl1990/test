package com.wzl.design.builder;

/**
 * @author: weizhenglong
 * @since 2018-04-02
 */
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private String phone;

    private Byte sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        sex = sex;
    }

    public User(){

    }

    public User(Long id, String name, Integer age, String email, String phone, Byte sex) {
        id = id;
        name = name;
        age = age;
        email = email;
        phone = phone;
        sex = sex;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private Long id;

        private String name;

        private Integer age;

        private String email;

        private String phone;

        private Byte sex;

        public Builder age(int age){
            this.age=age;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

     private Builder(){

     }

     public   User build(){
         return new User(id,name,age,email,phone,sex);
     }
    }

    public static void main(String[] args) {
        User wei = User.builder().age(1).name("wei").build();
        System.out.println(wei);
    }
}
