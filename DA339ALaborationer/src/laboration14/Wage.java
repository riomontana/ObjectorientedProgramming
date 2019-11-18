package laboration14;

public abstract class Wage { private long id;
public Wage( long id ) {
	this.id = id;
}
public long getId() { 
	return this.id;
}

public String toString() {
	return "Id: " + this.id + ", lön denna månad: " + wage() + " kr";
}
public abstract double wage(); 
}
