package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.google.gson.Gson;

import command.deprecate.AddPredicate;
import command.deprecate.CommandPredicate;
import command.deprecate.QueryPredicate;
import command.deprecate.UpdatePredicate;
import controller.dao.Dao;
import controller.dao.DaoFactory;
import controller.dao.VocabularyDao;
import model.Vocabulary;

public class Play2 {
	private static String help = "[table id] [add en ct] [query-all|q-all|q] [query-id id|q-id id] [update id en ct] [delete id]"
			+ " [help] [exit]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help);

		args = new String[] { "query-all" };
		Scanner sc = new Scanner(System.in);
		//Dao<Vocabulary> dao=VocabularyDaoFactory.instance();
		Dao dao=(Dao)DaoFactory.getDao("Vocabulary");

		try {
			System.out.println("請輸入代碼:");
			out: while (sc.hasNextLine()) {
				String line=sc.nextLine();
				String[] s = line.toLowerCase().split(" ");
				if (s.length > 0 && (s[0] != null || s[0].trim() != "")) {
					String code = s[0];
					switch (code.trim()) {
					case "hello":
						System.out.println("Hi");
						break;
					case "table":
						if (CommandPredicate.predicate( new QueryPredicate(s))) {
							dao=(Dao)DaoFactory.getDao(App.getTable( s[1].trim()));
							System.out.println("切換table為 "+s[1].trim());
						} else {
							System.out.println("代碼錯誤: 需要 table name");
						}
						break;
					case "q":
					case "q-all":
					case "query-all":
						List<Object> list=dao.queryall();
						if(list !=null && !list.isEmpty()) {
							list.forEach(System.out::println);
						}else {
							System.out.println("List is Empty");
						}
						break;
					case "q-id":
					case "query-id":
						if (CommandPredicate.predicate( new QueryPredicate(s))) {
							try {
								System.out.println(dao.query(Integer.valueOf(s[1].trim())));
							} catch (Exception e) {
								System.out.println("error: " + e.getMessage());
							}
						} else {
							System.out.println("代碼錯誤: 需要 ID");
						}
						break;
					case "delete":
						if (CommandPredicate.predicate( new QueryPredicate(s))) {
							try {
								dao.delete(Integer.valueOf(s[1].trim()));
							} catch (Exception e) {
								System.out.println("error: " + e.getMessage());
							}
						} else {
							System.out.println("代碼錯誤: 需要 ID");
						}
						break;
					case "add":
						if (CommandPredicate.predicate(new AddPredicate(s))) {
							Vocabulary v = new Vocabulary();
							v.setValues(s[1].trim(), s[2].trim());
							dao.add(v);
						} else {
							System.out.println("代碼錯誤: 需要 一個英文 和 一個中文 作為參數");
						}
						break;
					case "update":
						if (CommandPredicate.predicate(new UpdatePredicate(s))) {
							Vocabulary v = new Vocabulary();
							v.setValues(s[2].trim(), s[3].trim());
							dao.update(v, Integer.valueOf(s[1].trim()));
						} else {
							System.out.println("代碼錯誤: 需要ID 以及 一個英文 和 一個中文  作為參數");
						}
						break;

					case "":
						break;
					case "help":
						System.out.println(help);
						break;
					case "exit":
						System.out.println("Goodbye");
						break out;
					default:
						System.out.println("代碼錯誤!");
						break;
					}
				}
				System.out.println("請輸入代碼:");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
