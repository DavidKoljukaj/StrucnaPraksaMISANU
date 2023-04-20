package task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void serializeLink(Link inputLink, String fileName) throws IOException{
		
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(inputLink);
		out.close();
		file.close();
	}
	
	public static Link deserializeLink(String fileName) throws IOException, ClassNotFoundException{
		
		FileInputStream file = new FileInputStream(fileName);
		ObjectInputStream on = new ObjectInputStream(file);
		return (Link) on.readObject(); 
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Link randomLink = new Link("Proba", 2);
		final String filename = "serijalizacija.txt";
		System.out.println("Pre serijalizacije: ");
		randomLink.printLink();
		serializeLink(randomLink, filename);
		Link linkFromFile = deserializeLink(filename);
		System.out.println("Nakon serijalizacije: ");
		linkFromFile.printLink();
		
	}

}
