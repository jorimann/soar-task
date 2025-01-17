package ui.models;

import javax.swing.*;

public record User(String email
        ,String password
        ,String repeatPassword
        ,String securityQuestion
        ,String answer
        ,String fullName){
}
