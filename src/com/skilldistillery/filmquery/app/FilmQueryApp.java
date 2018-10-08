package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
		// app.test();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}
//  private void test() throws SQLException {
//	  Film film = db.getFilmById(1);
//	  System.out.println(film);
//	  Actor actor = db.getActorById(2);
//	  System.out.println(actor);
//	  List<Actor> actors = db.getActorsByFilmId(3);
//	  System.out.println(actors);
//  }

	private void startUserInterface(Scanner input) {
		
		System.out.println("Search for a movie by (1)id or (2) keyword or press (0) to exit");
		FilmQueryApp app = new FilmQueryApp();
		try {
			int id = input.nextInt();
			switch (id) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				System.out.println("Enter the id of the movie you would like to see: ");
				int id2 = input.nextInt();
				Film film = db.getFilmById(id2);
				if (film == null) {
					System.out.println("Movie not found.  Invalid film id.");
				} else {
					System.out.println("Title: " + film.getTitle());
					System.out.println("year: " + film.getRelease_year());
					System.out.println("rating: " + film.getRating());
					System.out.println("description: " + film.getDescription());
					System.out.println("language: " + film.getLanguage());
					System.out.println("cast: " + film.getActorsInFilm());
				}
				break;
			}
			case 2: {
				System.out.println("Search for a movie by key-word: ");
				String keyword = input.next();
				ArrayList<Film> films = new ArrayList<Film>();
				try {
					films = db.getFilmsByKeyWord(keyword);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (films.size() > 0) {
					for (Film film : films) {

						System.out.println("Title: " + film.getTitle());
						System.out.println("year: " + film.getRelease_year());
						System.out.println("rating: " + film.getRating());
						System.out.println("description: " + film.getDescription());
						System.out.println("language: " + film.getLanguage());
						List<Actor> actors = film.getActorsInFilm();
						System.out.println("cast: ");
						for (Actor actor : actors) {
							System.out.println(actor.getFirst_name() + " ");
							System.out.println(actor.getLast_name());
						}
					}
				} else {
					System.out.println("unable to find movie that matches key-word");
				}
				break;
			}

			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid menu selection");
			app.launch();
		}
	}
}
