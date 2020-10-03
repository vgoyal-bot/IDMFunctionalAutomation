package java.designpattern.factory;

public class TestFactoryMain {

	/**
	 * Here client will not aware of actual class will be called like PC.java or Server.java will be called, we are only passing the type of computer.
	 * @param args
	 */
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}

}