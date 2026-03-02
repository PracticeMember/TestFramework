package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class RegisterAccountPage {

	public RegisterAccountPage(WebDriver driver) {
		
	}
	public enum Check{
		RE,
		RO,
		ROO
	}
	public static void main(String[] args) {
		
		Map<String,String> map=new HashMap<>();
		map.put("1", "hello");
		System.out.println(map.get("2"));
	}
	
	
}
