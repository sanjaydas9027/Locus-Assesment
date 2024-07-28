package pojo;

public class Docs {
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRuntimeInMinutes() {
		return runtimeInMinutes;
	}
	public void setRuntimeInMinutes(int runtimeInMinutes) {
		this.runtimeInMinutes = runtimeInMinutes;
	}
	public int getBudgetInMillions() {
		return budgetInMillions;
	}
	public void setBudgetInMillions(int budgetInMillions) {
		this.budgetInMillions = budgetInMillions;
	}
	public int getBoxOfficeRevenueInMillions() {
		return boxOfficeRevenueInMillions;
	}
	public void setBoxOfficeRevenueInMillions(int boxOfficeRevenueInMillions) {
		this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
	}
	public int getAcademyAwardNominations() {
		return academyAwardNominations;
	}
	public void setAcademyAwardNominations(int academyAwardNominations) {
		this.academyAwardNominations = academyAwardNominations;
	}
	public int getAcademyAwardWins() {
		return academyAwardWins;
	}
	public void setAcademyAwardWins(int academyAwardWins) {
		this.academyAwardWins = academyAwardWins;
	}
	public int getRottenTomatoesScore() {
		return rottenTomatoesScore;
	}
	public void setRottenTomatoesScore(int rottenTomatoesScore) {
		this.rottenTomatoesScore = rottenTomatoesScore;
	}
	private String _id;
	private String name;
	private int runtimeInMinutes;
	private int budgetInMillions;
	private int boxOfficeRevenueInMillions;
	private int academyAwardNominations;
	private int academyAwardWins;
	private int rottenTomatoesScore;

}
