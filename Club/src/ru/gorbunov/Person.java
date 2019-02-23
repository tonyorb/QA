package ru.gorbunov;

import java.util.Random;

public class Person{

	private String firstName;
	private String secondName;
	private boolean isMale;
	private String favoriteMusic;
	private String[] maleNameList = {"John","David","Tom","Leonardo","Arnold","Peter","Paul","Michel"};
	private String[] femaleNameList = {"Alice","Victoria","Sarah","Nicole","Lana","Margarett","Anna","Monica"};
	private String[] secondNameList = {"Cooper","Black","Green","Freeman","Stone","West","Hope","Bellfort","Walker"};
	private String[] favoriteMusicList = {"HipHop","RnB","Pop","ElectroHouse"};
	
	public Person ()
	{
		this.isMale = Math.random() < 0.5;
		this.favoriteMusic = favoriteMusicList[new Random().nextInt(favoriteMusicList.length)];
		if (isMale)
		{
			this.firstName = maleNameList[new Random().nextInt(maleNameList.length)];
		}
		else
		{
			this.firstName = femaleNameList[new Random().nextInt(femaleNameList.length)];
		}
		this.secondName = secondNameList[new Random().nextInt(secondNameList.length)];
		System.out.println("В клуб приходит новый гость: "+firstName+" "+secondName+". Любимая музыка: "+favoriteMusic);
	}
	
	public String getFirstName ()
	{
		return this.firstName;
	}	
	public String getSecondName ()
	{
		return this.secondName;
	}
	public String getFavoriteMusic ()
	{
		return this.favoriteMusic;
	}
}
