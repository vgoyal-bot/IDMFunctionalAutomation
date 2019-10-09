package java.designpattern.builder;

import java.designpattern.builder.Ex1Computer.Ex1ComputerBuilder;

public class Ex1TestComputerBuilderPattern {

	public static void main(String[] args) {
		Ex1ComputerBuilder computebuilderObj = new Ex1ComputerBuilder("hdd", "ram").setBluetoothCardEnabled(true).setGraphicsCardEnabled(true);
		Ex1Computer computerObj = computebuilderObj.build();
	}
}
