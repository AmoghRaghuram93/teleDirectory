//package com.thoughtclan.config;
//
//import java.util.Scanner;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.thoughtclan.service.TelephoneServiceImpl;
//import com.thoughtclan.service.TelephoneService;
//
//public class Telephone {
//
//	public static void main(String[] args) {
//
//		String name;
//		Long phoneno;
//		int id;
//		boolean flag = false;
//		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//		TelephoneService myBean = (TelephoneServiceImpl) context.getBean("telServiceBean");
//		// myBean.display();
//		// myBean.add("gary", "4", 123455676);
//		// myBean.display();
//		//
//		// myBean.delete("3");
//		// myBean.display();
//		// flag = myBean.search("1");
//		// myBean.edit("1");
//		// myBean.display();
//
//		Scanner sc = new Scanner(System.in);
//		int userOpt = 0;
//		while (userOpt != 6) {
//			System.out.println("");
//			System.out.println("----- Telephone Directory ------");
//			System.out.println("(1) View Directory ");
//			System.out.println("(2) Add Contact");
//			System.out.println("(3) Delete Contact");
//			System.out.println("(4) Edit Contact");
//			System.out.println("(5) Search Contact");
//			System.out.println("(6) Exit menu");
//			userOpt = sc.nextInt();
//
//			if (userOpt == 1) {
//				myBean.display();
//			} else if (userOpt == 2) {
//				System.out.println("Enter the name");
//				name = sc.next();
//				System.out.println("Enter the phone number");
//				phoneno = sc.nextLong();
//				//myBean.addPerson(name, phoneno);
//			} else if (userOpt == 3) {
//				System.out.println("Enter the id");
//				id = sc.nextInt();
//				myBean.delete(id);
//			} else if (userOpt == 4) {
//				System.out.println("Enter the id");
//				id = sc.nextInt();
//				//yBean.edit(id);
//			} else if (userOpt == 5) {
//				System.out.println("Enter the id");
//				id = sc.nextInt();
//				myBean.searchId(id);
//			}
//			((ConfigurableApplicationContext)context).close();
//		}
//
//	}
//
//}
