
public abstract class Karakter {
	private int karakterID;
	private String karakterAd;
	private String karakterTur;
	
	private Lokasyon lokasyon=new Lokasyon();

	
	public abstract void enKisaYol(int Y,int X);
	public abstract void hareketEt(int xBirim,int yBirim);
	
	
	public Karakter() {

	}

	public Karakter(int karakterID, String karakterAd, String karakterTur, Lokasyon lokasyon) {
		super();
		this.karakterID = karakterID;
		this.karakterAd = karakterAd;
		this.karakterTur = karakterTur;
		this.lokasyon = lokasyon;
	}

	public int getKarakterID() {
		return karakterID;
	}

	public void setKarakterID(int karakterID) {
		this.karakterID = karakterID;
	}

	public String getKarakterAd() {
		return karakterAd;
	}

	public void setKarakterAd(String karakterAd) {
		this.karakterAd = karakterAd;
	}

	public String getKarakterTur() {
		return karakterTur;
	}

	public void setKarakterTur(String karakterTur) {
		this.karakterTur = karakterTur;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}
	
	public int getLokasyon_x() {
		return lokasyon.getX();
	}
	public void setLokasyon_x(int x) {
		lokasyon.setX(x);
	}
	

	public int getLokasyon_y() {
		return lokasyon.getY();
	}
	public void setLokasyon_y(int y) {
		lokasyon.setY(y);
	}
	
	

}
