package com.qainfotech.tap.training.snl.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest {
	UUID uid;
	WebDriver driver;
	Board b_test;
	GameInProgressException game;
	InvalidTurnException invalid_turn;
	MaxPlayersReachedExeption max_player;
	NoUserWithSuchUUIDException no_user;
	@BeforeClass
	public void initialise() throws FileNotFoundException, UnsupportedEncodingException,
    IOException
	{
		b_test=new Board();	
	}
	
	@Test(expectedExceptions=MaxPlayersReachedExeption.class)
	public void max_player() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException 
	{
		String[] array_of_players= {"Neha","Rita","Gita","Sita","Rahul"};
		for(String s:array_of_players)
		{
		b_test.registerPlayer(s);
		}
		
		
	}
	@Test(expectedExceptions= PlayerExistsException.class)
	public void check_samename_player_exists() throws PlayerExistsException, FileNotFoundException, UnsupportedEncodingException, GameInProgressException, MaxPlayersReachedExeption, IOException
	{
		String[] array_of_players= {"Neha","Rita","Neha","Sita"};
		for(String s:array_of_players)
		{
			b_test.registerPlayer(s);
		}
	}
	@Test(expectedExceptions=InvalidTurnException.class)
	void check_turn_is_invalid() throws FileNotFoundException, UnsupportedEncodingException, InvalidTurnException
	{
		uid=UUID.randomUUID();
		b_test.rollDice(uid);
	}
	@Test(expectedExceptions=GameInProgressException.class)
	void check_game_in_progress() throws GameInProgressException, FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, MaxPlayersReachedExeption, IOException, InvalidTurnException
	{
            JSONArray players=b_test.registerPlayer("Neha");
            JSONObject obj=players.getJSONObject(0);
            UUID id=UUID.fromString(obj.getString("uuid"));
		b_test.rollDice(id);
		b_test.registerPlayer("kat");
        }
		
	@Test(expectedExceptions=NoUserWithSuchUUIDException.class)
	public void delete_player_incorrect_uid() throws IOException, NoUserWithSuchUUIDException
	{
		b_test=new Board();
		UUID uid_one= UUID.randomUUID();
		b_test.deletePlayer(uid_one);
        }

	
	}

