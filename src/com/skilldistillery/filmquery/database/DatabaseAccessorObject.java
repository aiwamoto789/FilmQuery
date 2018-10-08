package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	public String getLanguage(int film_id) {
		String user = "student";
		String pass = "student";
		Connection conn = null;
		String sql = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT language.name FROM film JOIN language ON film.language_id = language.id WHERE "
					+ "film.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film_id);
			ResultSet rs = stmt.executeQuery();
			String language = "";
			if(rs.next() == true) {
				language = rs.getString(1);
				return language;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Film getFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String pass = "student";
		Connection conn = null;
		String sql = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate,"
					+ "length, rating, replacement_cost, special_features"
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			film = new Film();
			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRelease_year(rs.getShort("release_year"));
				film.setLanguage_id(rs.getInt("language_id"));
				film.setRental_duration(rs.getInt("rental_duration"));
				film.setRental_rate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setRating(rs.getString("rating"));
				film.setReplacement_cost(rs.getDouble("replacement_cost"));
				film.setSpecial_features(rs.getString("special_features"));
				film.setActorsInFilm(getActorsByFilmId(rs.getInt("id")));
				film.setLanguage(getLanguage(rs.getInt("id")));
			}
			rs.close();
			stmt.close();
			conn.close();
			return film;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Actor getActorById(int actorId) throws SQLException {
		Actor actor = null;
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt(1));
			actor.setFirst_name(actorResult.getString(2));
			actor.setLast_name(actorResult.getString(3));
			actor.setFilms((List<Film>) getFilmById(actorId)); // An Actor has Films
		}
		actorResult.close();
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public ArrayList<Film> getFilmsByKeyWord(String keyword) {
		ArrayList<Film> films = new ArrayList<>();

		String user = "student";
		String pass = "student";
		Connection conn = null;
		String sql = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, "
					+ "length, replacement_cost, rating, special_features FROM film WHERE title "
					+ "LIKE ? or description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			films = new ArrayList<>();
			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRelease_year(rs.getShort("release_year"));
				film.setLanguage_id(rs.getInt("language_id"));
				film.setRental_duration(rs.getInt("rental_duration"));
				film.setRental_rate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacement_cost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecial_features(rs.getString("special_features"));
				 film.setActorsInFilm(getActorsByFilmId(rs.getInt("id")));
				film.setLanguage(getLanguage(rs.getInt("id")));
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
			return films;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		ArrayList<Actor> actors = new ArrayList<>();
		try {
			String sql = "SELECT actor.id, actor.first_name, actor.last_name, film.title FROM actor JOIN film_actor on "
					+ "actor.id = film_actor.actor_id JOIN film ON film.id = film_actor.film_id WHERE film.id = ?;";

			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();

			while (actorResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorResult.getInt(1));
				actor.setFirst_name(actorResult.getString(2));
				actor.setLast_name(actorResult.getString(3));
				actors.add(actor);

			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;

	}

}
