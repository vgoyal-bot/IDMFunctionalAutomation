package java.designpattern.builder;

import java.designpattern.builder.Ex2Person.Ex2PersonBuilder;

public class Ex2TestPersonBuilderPattern {
	
	public static void main(String[] args) {
		Ex2PersonBuilder obj = new Ex2PersonBuilder("firstName", "lastName").setFatherName("fatherName");
		Ex2Person personObj = obj.build();
	}
}
