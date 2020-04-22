/*
 *  Memory Class
 */
public class Memory extends Generics {
	/*
	 * fields
	 */
	public final String type = "Memory";
	public enum KeyType {combo, year, season, caption};
	public static KeyType key = KeyType.combo;
	private int year;
	private String season;
	private String caption;
	
	/*
	 * Constructor
	 */
	public Memory(int year, String season, String caption) {
		this.setType(type);
		this.year = year;
		this.season = season;
		this.caption = caption;
	}

	/*
	 * toString() method will format outpat based off of key selection
	 */
	@Override
	public String toString() {
		String out = "";
		
		switch(key) {
		case year:
			out += this.year;
			break;
		case season:
			out += this.season;
			break;
		case caption:
			out+= this.caption;
			break;
		case combo:
		default:
			out += type + ": " + this.year + ", " + this.season + ", " + this.caption;
		}
		return out;
	}
	
	
	/*
	 * Initialize sample memory data
	 */
	public static Generics[] memoryData() {
		Generics arr[] = {
				new Memory(2010, "Winter", "Ski Trip"),
				new Memory(2009, "Spring", "Spring Break"),
				new Memory(1999, "Summer", "Hawaii Family Vacation"),
				new Memory(2020, "Spring", "Coronocation"),
				new Memory(2005, "Winter", "Cookies with Grandma"),
				new Memory(2019, "Summer", "Del Mar Fair"),
				new Memory(2000, "Winter", "Surived Y2K Problem"),
				new Memory(2003, "Fall", "Apple Picking")
		};
		
		return arr;
	}
	
	/*
	 * Tester main for building Generics Array
	 */
	public static void main(String[] args) {
		Generics[] arr = memoryData();
		for(Generics obj : arr) {
			System.out.println(obj);
		}
	}
}
