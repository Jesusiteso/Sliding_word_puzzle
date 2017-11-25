package pruebas;

public class Scout{
	
	public int x, y;
	
	//1 up, 2 right, 3 down, 4 left
	public Scout(int y, int x) {
		this.x=x;
		this.y=y;
	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Scout)) return false;

		Scout scout = (Scout) o;

		if (x != scout.x) return false;
		return y == scout.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}


}
