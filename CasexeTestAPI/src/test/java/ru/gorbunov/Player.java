package ru.gorbunov;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

public class Player {
	String userName, userPassword, userId, userEmail, contryId, timezoneId, 
		   name, surname, gender, phoneNumber, birthDate;
	Boolean bonusesAllowed;
	Boolean isVerified;
	//конструктор для рандомного пользователя с required полями
    public Player() {
        this.userName = "RandomUser"+DateFormatUtils.format(Calendar.getInstance().getTime(), "ddHHmmSS");
        this.userEmail = userName+"@ya.ru";
        this.userPassword = "UXdlcnR5MTIzNDU2";
    }
}