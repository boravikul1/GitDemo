package com.seleniumautomation.mavenproject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class JavaStreams {

	public void regular()
	{
		ArrayList<String> names = new ArrayList<>();
		names.add("Vijay");
		names.add("Lakshmi");
		names.add("Gajendra");
		names.add("Manju");
		names.add("Vibhor");
		names.add("Rachna");
		names.add("Ankit");
		names.add("Monika");
		names.add("Vikul");
		names.add("Megha");
		names.add("Eliana");
		names.add("Amaya");
		names.add("Amyra");
		names.add("Abir");
		
//		for(int i=0;i<names.size();i++)
//		{
//			if(names.get(i).startsWith("M"))
//			System.out.println(names.get(i));
//		}
		
		System.out.println(names.stream().filter(s->s.startsWith("A")).count());
		names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		System.out.println(names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList()));
		System.out.println("The Sorted List is : ");
		System.out.println(names.stream().sorted().collect(Collectors.toList()));
		System.out.println("List in uppercase is: ");
		System.out.println(names.stream().map(s->s.toUpperCase()).collect(Collectors.toList()));
		System.out.println(names.stream().filter(s->s.length()>5).collect(Collectors.toList()));
		
	}
	
	
	public static void main(String[] args)
	{
		JavaStreams obj = new JavaStreams();
		obj.regular();
	}
}
