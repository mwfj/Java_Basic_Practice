package mwfj.demo.jdbc2.servlet;

import java.util.UUID;

public class MainModule {

	public static void main(String[] args) {
		System.out.println( UUID.randomUUID().toString().replace("-", "").toUpperCase());

	}

}
