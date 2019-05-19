package ru.gorbunov;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

public class Player {
	String userName;
	String userPassword = "UXdlcnR5MTIzNDU2";
	String userId;
	String userEmail;
    public Player() {
        this.userName = "RandomUser"+DateFormatUtils.format(Calendar.getInstance().getTime(), "ddHHmmSS");
        this.userEmail = userName+"@ya.ru";
    }
	public Player(String userName) {
        this.userName = userName;
        this.userEmail = userName+"@ya.ru";
    }
}