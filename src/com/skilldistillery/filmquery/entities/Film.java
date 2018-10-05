package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Set;

public class Film {
	String title, description, rating;
	int id, release_year, language_id, rental_duration, length;
	double rental_rate, replacement_cost;
	List<String> actorsInFilm;
	Set<String> special_features;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}
	public double getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public List<String> getActorsInFilm() {
		return actorsInFilm;
	}
	public void setActorsInFilm(List<String> actorsInFilm) {
		this.actorsInFilm = actorsInFilm;
	}
	public Set<String> getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(Set<String> special_features) {
		this.special_features = special_features;
	}
}
