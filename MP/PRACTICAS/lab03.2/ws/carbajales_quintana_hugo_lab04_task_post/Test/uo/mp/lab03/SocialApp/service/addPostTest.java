package uo.mp.lab03.SocialApp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.SocialApp.model.Image;
import uo.mp.lab03.SocialApp.model.Item;
import uo.mp.lab03.SocialApp.model.TextMessage;

class addPostTest {
	private Item image;
	private Item textMessage;
	private String user;
	private String fileName;
	private String message;
	private String caption;
	private SocialNetwork socialNetwork;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception{
		user="Hugo";
		fileName="Marbella.jpg";
		caption="Enjoying";
		message="Hello!";
		image=new Image(user, fileName, caption);
		textMessage=new TextMessage(user, message);
		socialNetwork=new SocialNetwork();
	}
	/*
	 * Casos:
	 * 1.Se añade una imagen a la red social
	 * 2.Se añade una textMessage a la red social
	 * 3.El parametro que se pasa es null y salta excepcion
	 * 4.Se añade una imgagen y un textMessage
	 */
	@Test
	public void addImage() {
		socialNetwork.addPost(image);
		ArrayList<Item>itemsResult=socialNetwork.getPosts();
		assertEquals(1,itemsResult.size());
		assertTrue(itemsResult.contains(image));
	}
	@Test
	public void addTextMessage() {
		socialNetwork.addPost(textMessage);
		ArrayList<Item>itemsResult=socialNetwork.getPosts();
		assertEquals(1,itemsResult.size());
		assertTrue(itemsResult.contains(textMessage));
	}
	@Test
	public void noAddNull() {
		try {
		socialNetwork.addPost(null);
		}catch(RuntimeException e) {
			assertEquals("Post cannot be null",e.getMessage());
		}
	}
	@Test
	public void addImageAndText() {
		socialNetwork.addPost(image);
		socialNetwork.addPost(textMessage);
		ArrayList<Item>itemsResult=socialNetwork.getPosts();
		assertEquals(2,itemsResult.size());
		assertTrue(itemsResult.contains(image));
		assertTrue(itemsResult.contains(textMessage));
	}
	

	
	

}
