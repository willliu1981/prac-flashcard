package controller;

import java.sql.SQLException;
import java.util.Scanner;

import command.AddPredicate;
import command.CommandPredicate;
import command.QueryPredicate;
import command.UpdatePredicate;
import model.Vocabulary;

public class Play {
	private static String help = "[add en ct] [query-all|q-all|q] [query-id id|q-id id] [update id en ct] [delete id]"
			+ " [help] [exit]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help);

		args = new String[] { "query-all" };
		Scanner sc = new Scanner(System.in);
		Dao<Vocabulary> dao=VocabularyFactory.instance();

		try {
			System.out.println("請輸入代碼:");
			out: while (sc.hasNextLine()) {
				String[] s = sc.nextLine().toLowerCase().split(" ");
				if (s.length > 0 && (s[0] != null || s[0].trim() != "")) {
					String code = s[0];
					switch (code.trim()) {
					case "hello":
						System.out.println("Hi");
						break;
					case "q":
					case "q-all":
					case "query-all":
						dao.queryall().forEach(System.out::println);
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
