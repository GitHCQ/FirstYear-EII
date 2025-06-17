package uo.mp.lab03.SocialApp.ui;

import uo.mp.lab03.SocialApp.model.TextMessage;

import java.util.ArrayList;

import uo.mp.lab03.SocialApp.model.Image;
import uo.mp.lab03.SocialApp.model.Item;
import uo.mp.lab03.SocialApp.service.SocialNetwork;

public class NetworkApp {
	public void SimulateClient() {
		SocialNetwork social=new SocialNetwork();
		social.addPost(new Image("Iria", "filename1.jpg", "Caption 1"));
		// Agregar fotos y mensajes de dos usuarios diferentes
        Image photo1 = new Image("user1", "filename1.jpg", "Caption 1");
        TextMessage message1 = new TextMessage("user2", "Hello, this is a text message!");

        Image photo2 = new Image("user1", "filename2.jpg", "Caption 2");
        TextMessage message2 = new TextMessage("user2", "Another text message!");
        social.addPost(photo1);
        social.addPost(message1);
        social.addPost(photo2);
        social.addPost(message2);

        // Imprimir todos los posts
        System.out.println("All Posts:");
        social.listaAllPost(System.out);
        //Imprime los post de un usuario
        String user1="Iria";
        System.out.println("\nPosts asociados al usuario " + user1 + ":");
        ArrayList<Item> postsByUser = social.findPostByUser(user1);
        for (Item post : postsByUser) {
            System.out.println(post);
        }
        System.out.println("Post en formato Html");
        ArrayList<String> htmlFormattedPosts = social.toHtmlFormat();
        for (String formattedPost : htmlFormattedPosts) {
            System.out.println(formattedPost);
        }
        
    }
}

