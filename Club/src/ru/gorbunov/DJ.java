package ru.gorbunov;

import java.util.Random;

public class DJ {
	private String[] musicStyle = {"HipHop","RnB","Pop","ElectroHouse"};
	private String playingMusic;
	
	public String getMusic()
	{
		return this.playingMusic;
	}
	
	public DJ () 
	{
		this.playingMusic = musicStyle[new Random().nextInt(musicStyle.length)];
	}

	public void changeMusic() {
	    this.playingMusic = musicStyle[new Random().nextInt(musicStyle.length)];
	    System.out.println("В клубе меняется музыка, звучит: "+this.playingMusic);
	}
}
