package oop.PastaModified;

public class PastaModified {
	// Private properties
	private int price;
	private String type;


	// Constructs a PastaModified object with a price and a type
	public PastaModified(PastaType type) {
		//set type(PastaType) into type(string) utilising toString()
		this.type = type.toString();

	}

	// Gets the price of the pasta
	public int price() {
		return price;
	}

	//Gets the type of the pasta
	public String type() {
		return type;
	}

	//Overriding toString object method
	@Override
	public String toString() {
		return "PastaModified{" +
				"type=" + type +
				'}';
	}
}