package ru.gorbunov;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		DJ dj = new DJ();
		System.out.println("��������� ����������, � ����� ������: "+dj.getMusic());
		for (int i = 0; i <= 120; i+=5)
		{
			System.out.println(new Date().toString());
			ArrayList<Person> dancingList = new ArrayList<Person>();
			ArrayList<Person> drinkingList = new ArrayList<Person>();
			personList.add(new Person());
			System.out.println("���������� ����� � �����: "+personList.size());
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
		System.out.println("��������� ��������");
	}

	public static void printDancingList(ArrayList<Person> dancingList)
	{
		if (dancingList.isEmpty())
		{
			System.out.println("�� �������� �����.");
		}
		else
		{
			System.out.println("���������� ���������� �� ��������: "+dancingList.size()+", ����� ���:");
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
			System.out.println("� ���� �����.");
		}
		else
		{
			System.out.println("���������� ����������, ������ �����, � ����: "+drinkingList.size()+", ����� ���:");
			for(Person drinkingPerson : drinkingList)
			{
				System.out.println("- "+drinkingPerson.getFirstName()+" "+drinkingPerson.getSecondName());
			}
		}			
	}
		
}
