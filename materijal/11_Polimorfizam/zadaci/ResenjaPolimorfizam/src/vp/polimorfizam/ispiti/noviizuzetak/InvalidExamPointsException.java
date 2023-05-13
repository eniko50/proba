package vp.polimorfizam.ispiti.noviizuzetak;

public class InvalidExamPointsException extends RuntimeException {
	private int points; // informacija o broju poena koji su izazvali izuzetak
	
	public InvalidExamPointsException(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}	
}
