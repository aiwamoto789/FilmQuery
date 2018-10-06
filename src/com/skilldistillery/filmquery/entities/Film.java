package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Set;

public class Film {
	private String title, description, rating;
	private int id, release_year, language_id, rental_duration, length;
	private double rental_rate, replacement_cost;
	private List<Actor> actorsInFilm;
	private String special_features;
	
	public Film() {
		
	}
	
	
	public Film(String title, String description, String rating, int id, int release_year, int language_id,
			int rental_duration, int length, double rental_rate, double replacement_cost, List<Actor> actorsInFilm,
			String special_features) {
		super();
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.id = id;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.length = length;
		this.rental_rate = rental_rate;
		this.replacement_cost = replacement_cost;
		this.actorsInFilm = actorsInFilm;
		this.special_features = special_features;
	}

	


	@Override
	public String toString() {
		return "Film [title=" + title + ", description=" + description + ", rating=" + rating + ", id=" + id
				+ ", release_year=" + release_year + ", language_id=" + language_id + ", rental_duration="
				+ rental_duration + ", length=" + length + ", rental_rate=" + rental_rate + ", replacement_cost="
				+ replacement_cost + ", actorsInFilm=" + actorsInFilm + ", special_features=" + special_features + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorsInFilm == null) ? 0 : actorsInFilm.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + language_id;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + release_year;
		result = prime * result + rental_duration;
		long temp;
		temp = Double.doubleToLongBits(rental_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacement_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((special_features == null) ? 0 : special_features.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actorsInFilm == null) {
			if (other.actorsInFilm != null)
				return false;
		} else if (!actorsInFilm.equals(other.actorsInFilm))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language_id != other.language_id)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (release_year != other.release_year)
			return false;
		if (rental_duration != other.rental_duration)
			return false;
		if (Double.doubleToLongBits(rental_rate) != Double.doubleToLongBits(other.rental_rate))
			return false;
		if (Double.doubleToLongBits(replacement_cost) != Double.doubleToLongBits(other.replacement_cost))
			return false;
		if (special_features == null) {
			if (other.special_features != null)
				return false;
		} else if (!special_features.equals(other.special_features))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


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
	public List<Actor> getActorsInFilm() {
		return actorsInFilm;
	}
	public void setActorsInFilm(List<Actor> actorsInFilm) {
		this.actorsInFilm = actorsInFilm;
	}
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	
	
}
