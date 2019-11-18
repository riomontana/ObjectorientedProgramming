package laboration13;

public class Media {

	private long id;
	private String title;
	
	public Media( long id, String title ) { 
		this.id = id;
		this.title = title;
	}
	
	public long getId() {
		return id;
	}
	public void setId( long id ) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) { 
		this.title = title;
	}

	public String toString() {
		String res = "Media: ID = " + this.id + ", Titel = " + this.title + "\n" +
		super.toString();
		return res;
	}

	public static void main(String[] args) {
		Media media = new Media(837884976, "En fantastisk värld" );
		String res = media.getTitle() + " är ett '" + media.getClass().getName() +
		"'-objekt" + "\n" + "toString-metoden: " + media.toString(); 
		javax.swing.JOptionPane.showMessageDialog( null, res );
	}
}
