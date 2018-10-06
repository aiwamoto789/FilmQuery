package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film getFilmById(int filmId);
  public Actor getActorById(int actorId) throws SQLException;
  public List<Actor> getActorsByFilmId(int filmId);
  public ArrayList<Film> getFilmsByKeyWord(String keyword) throws SQLException;
}
