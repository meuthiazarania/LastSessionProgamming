package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CorrectionHn {

	static Scanner sc = new Scanner(System.in); //biar gak bikin scanner ulang"
	
	//Buat nyimpen data
	static ArrayList<String> listNama = new ArrayList<>();
	static ArrayList<Integer> listNilai = new ArrayList<>();
	
	public static void main(String[] args) {
		int pilihanMenu;
		
		do {
		System.out.println("                        _   _     _  _ _  _ \r\n"
				+ "  __ ___ _ _ _ _ ___ __| |_(_)___| || | \\| |\r\n"
				+ " / _/ _ \\ '_| '_/ -_) _|  _| / _ \\ __ | .` |\r\n"
				+ " \\__\\___/_| |_| \\___\\__|\\__|_\\___/_||_|_|\\_|\r\n"
				+ "                                            ");
		System.out.println("1. Add New Data");
		System.out.println("2. View All");
		System.out.println("3. Search Data");
		System.out.println("4. Exit");
		
		//validasi
		do {
		System.out.print(">>>");
		pilihanMenu = sc.nextInt(); sc.nextLine();
		}while(pilihanMenu < 1 || pilihanMenu > 4);
		
		switch(pilihanMenu) {
		case 1:
			//add
			addnewData();
			break;
		case 2:
			//viewall
			viewAll();
			break;
		case 3:
			//search data
			searchdata();
			break;
		case 4:
			//exit
			exit();
			break;
		}
		
		}while(pilihanMenu != 4 );
		
	}

	private static void exit() {
		System.out.println("Thank You For Using This Program!");
		
	}

	private static void searchdata() {
		if(listNama.isEmpty()) {
			System.out.println("Please input a Data First!");
			//break
			return;
		}
		
		System.out.println("Input a Name: ");
		String nama = sc.nextLine();
		
		for(int i = 0; i < listNama.size(); i++) {
			if(listNama.get(i).equalsIgnoreCase(nama)) {
				System.out.println(listNama.get(i) + " " + nama);
				return;
			}
		}
		
		System.out.println(nama + "Is Not Found");
		
	}

	private static void viewAll() {
		if(listNama.isEmpty()) {
			System.out.println("Please Input a Data First!");
			//break
			return;
		}
		
		//Sort
		bubbleSort();
		
		//Tampilin Data
		for(int i = 0; i < listNama.size(); i++) {
			System.out.println(listNama.get(i) + " " + listNilai.get(i));
		}
	}

	private static void bubbleSort() {
		for(int i = 0; i < listNilai.size(); i++) {
			for(int j = 0; j < listNilai.size() -1 -i; j++) {
				if(listNilai.get(j) < listNilai.get(j+1)) {
					
					//swap nama
					String nama = listNama.get(j);
					listNama.set(j, listNama.get(j+1));
					listNama.set(j+1, nama);
					
					//swap nilai 
					Integer nilai = listNilai.get(j);
					listNilai.set(j, listNilai.get(j+1));
					listNilai.set(j+1, nilai);
					
				}
			}
		}
		
	}

	private static void addnewData() {
		String nama;
		Integer nilai;
		
		System.out.println("Input Name: ");
		nama = sc.nextLine();
		
		do {
			System.out.println("input Score: ");
			nilai = sc.nextInt();
			sc.nextLine();
		} while (nilai < 0 || nilai > 100);
		
		listNama.add(nama);
		listNilai.add(nilai);
		
		System.out.println("New Data Successfully Added");
		
	}

}
