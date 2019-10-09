package java.designpattern.builder;

/**
 * Rules : 
 * 1. create a private constructor of Person class so that it can not be accessed from outside.
 * 2. Only create getters so that value can not be set directly and can only be set via PersonBuilder class.
 * Link: https://medium.com/@ajinkyabadve/builder-design-patterns-in-java-1ffb12648850
 * @author vinitg
 *
 */
public class Ex2Person {
	
	// mandatory parameters
	private String firstName;
	private String lastName;
	
	//optional paramters
	private String fatherName;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	
	private Ex2Person(Ex2PersonBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.fatherName = builder.fatherName;
	}

	public static class Ex2PersonBuilder{
		// mandatory parameters
		private String firstName;
		private String lastName;
		
		//optional paramters
		private String fatherName;
		
		// Imagine in a way how will we pass the data frm calling class.
		public Ex2PersonBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public Ex2PersonBuilder setFatherName(String fatherName) {
			this.fatherName = fatherName;
			return this;
		}
		
		public Ex2Person build() {
			return new Ex2Person(this);
		}
	}
}
