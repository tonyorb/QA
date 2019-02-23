package ru.gorbunov;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		DJ dj = new DJ();
		System.out.println("Вечеринка начинается, в клубе играет: "+dj.getMusic());
		for (int i = 0; i <= 120; i+=5)
		{
			System.out.println(new Date().toString());
			ArrayList<Person> dancingList = new ArrayList<Person>();
			ArrayList<Person> drinkingList = new ArrayList<Person>();
			personList.add(new Person());
			System.out.println("Колчисевто людей в клубе: "+personList.size());
			dj.changeMusic();
			for(Person person : personList)
			{
				if (person.getFavoriteMusic().equals(dj.getMusic()))
				{
					dancingList.add(person);
				}
				else
				{
					drinkingList.add(person);
				}
			}
			printDancingList(dancingList);
			printDrinkingList(drinkingList);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Вечеринка окончена");
	}

	public static void printDancingList(ArrayList<Person> dancingList)
	{
		if (dancingList.isEmpty())
		{
			System.out.println("На танцполе пусто.");
		}
		else
		{
			System.out.println("Количество персонажей на танцполе: "+dancingList.size()+", среди них:");
			for(Person dancingPerson : dancingList)
			{
				System.out.println("- "+dancingPerson.getFirstName()+" "+dancingPerson.getSecondName());
			}				
		}
	}
	public static void printDrinkingList(ArrayList<Person> drinkingList)
	{
		if (drinkingList.isEmpty())
		{
			System.out.println("В баре пусто.");
		}
		else
		{
			System.out.println("Количество персонажей, пьющих водку, в баре: "+drinkingList.size()+", среди них:");
			for(Person drinkingPerson : drinkingList)
			{
				System.out.println("- "+drinkingPerson.getFirstName()+" "+drinkingPerson.getSecondName());
			}
		}			
	}
		
}
