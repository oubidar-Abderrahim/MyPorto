import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Java Program to parse JSON String to Java object and converting a Java object
 * to equivalent JSON String.
 *
 * @author Satityr
 */
public class JSONParser {

	public static void main(String args[]) {
		toJSON(); // converting Java object to JSON String
		toJava(); // parsing JSON file to create Java object
	}

	/**
	 * Method to parse JSON String into Java Object using Jackson Parser.
	 *
	 */
	public static void toJava() {

		// this is the key object to convert JSON to Java
		ObjectMapper mapper = new ObjectMapper();

		try {
			File json = new File("player.json");
			Player cricketer = mapper.readValue(json, Player.class);
			System.out.println("Java object created from JSON String :");
			System.out.println(cricketer);

		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}

	/**
	 * Java method to convert Java Object into JSON String with help of Jackson
	 * API.
	 *
	 */
	public static void toJSON() {
		Player kevin = new Player("Kevin", "Cricket", 32, 221, new int[] { 33, 66, 78, 21, 9, 200 });

		// our bridge from Java to JSON and vice versa
		ObjectMapper mapper = new ObjectMapper();

		try {
			File json = new File("player.json");
			mapper.writeValue(json, kevin);
			System.out.println("Java object converted to JSON String, written to file");
			System.out.println(mapper.writeValueAsString(kevin));

		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}

}

/*
 * A simple Java values class with getters and setters. We will convert Player
 * class instance into JSON String and a JSON object to Player instance.
 */
class Player {

	private String name;
	private String sport;
	private int age;
	private int id;
	private int[] lastScores;

	public Player() {
		// just there, need by Jackson library
	}

	public Player(String name, String sport, int age, int id, int[] lastinnings) {
		this.name = name;
		this.sport = sport;
		this.age = age;
		this.id = id;
		lastScores = lastinnings;
	}

	public final String getName() {
		return name;
	}

	public final String getSport() {
		return sport;
	}

	public final int getAge() {
		return age;
	}

	public final int getId() {
		return id;
	}

	public final int[] getLastScores() {
		return lastScores;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setSport(String sport) {
		this.sport = sport;
	}

	public final void setAge(int age) {
		this.age = age;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final void setLastScores(int[] lastScores) {
		this.lastScores = lastScores;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", sport=" + sport + ", age=" + age + ", id=" + id + ", recent scores="
				+ Arrays.toString(lastScores) + "]";
	}

}