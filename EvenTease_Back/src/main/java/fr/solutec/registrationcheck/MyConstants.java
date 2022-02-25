package fr.solutec.registrationcheck;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;

import fr.solutec.rest.UserRest;

public class MyConstants {

    // Replace with your email here:  
    public static final String MY_EMAIL = "eventease.inscription@gmail.com";

    // Replace password!!
    public static final String MY_PASSWORD = "evente@se";

    /*public static String FRIEND_EMAIL="youssefbaissipro@gmail.com";UserRest.inscription();*/

    public static final int checkCode = 1111 + (int)(Math.random() * ((9999 - 1111) + 1));;
}
