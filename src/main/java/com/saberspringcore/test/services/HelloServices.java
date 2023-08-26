package com.saberspringcore.test.services;

public class HelloServices {

    public void  init(){
        System.out.println("init helloService called ................");
    }

    public String sayHello(String firstName,String lastName){
        return "Hello ".concat(firstName).concat(" ").concat(lastName);
    }

    public String sayBye(String firstName,String lastName){
        return "Bye Bye ".concat(firstName).concat(" ").concat(lastName);
    }

    public void destroy(){
        System.out.println("destroy helloService called ................");
    }
}
