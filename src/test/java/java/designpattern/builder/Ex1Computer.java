package java.designpattern.builder;


/**
 * Steps : 
 * 1. Create Computer Class.
 * 2. Take some mandatory and optional paramters and create getter of all the parameters.
 * 3. Create Builder Class of same name inside that class with Builder appended like ComputerBuilder
 * 4. Create private constructor of Computer class and pass ComputerBuilder class object as argument.
 * 5. Create copy of all parameters in ComputerBuilder class.
 * 
 * Please go through this link for better understanding : https://www.journaldev.com/1425/builder-design-pattern-in-java
 * @author vinitg
 *
 */
public class Ex1Computer {
	// mandatory parameters
	private String HDD;
	private String RAM;
	
	// optional paramters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	
	//Getter Methods
	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	/**
	 * Notice that : Computer class has only getters and private constructor so only wat to get Computer class object is to call ComputerBuilderClass.
	 * @param builder
	 */
	private Ex1Computer(Ex1ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	public static class Ex1ComputerBuilder{
		// mandatory parameters
		private String HDD;
		private String RAM;
		
		// optional paramters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		public Ex1ComputerBuilder(String hdd, String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}
		
		public Ex1ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}
		
		public Ex1ComputerBuilder setBluetoothCardEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Ex1Computer build() {
			return new Ex1Computer(this);
		}
	}

}

