
public abstract class Dusman extends Karakter {

	private int dusmanID;
	private String dusmanAd;
	private String dusmanTur;
	
	public Dusman() {
		super();
	
	}
	

	
	
	public Dusman(int dusmanID, String dusmanAd, String dusmanTur) {
		super();
		this.dusmanID = dusmanID;
		this.dusmanAd = dusmanAd;
		this.dusmanTur = dusmanTur;
	}
	
	public Dusman(int karakterID, String karakterAd, String karakterTur, Lokasyon lokasyon) {
		super(karakterID, karakterAd, karakterTur, lokasyon);
		 dusmanID=super.getKarakterID();
		 dusmanAd=super.getKarakterAd();
		 dusmanTur=super.getKarakterTur();

	}



	public int getDusmanID() {
		return dusmanID;
	}



	public void setDusmanID(int dusmanID) {
		this.dusmanID = dusmanID;
	}



	public String getDusmanAd() {
		return dusmanAd;
	}



	public void setDusmanAd(String dusmanAd) {
		this.dusmanAd = dusmanAd;
	}



	public String getDusmanTur() {
		return dusmanTur;
	}



	public void setDusmanTur(String dusmanTur) {
		this.dusmanTur = dusmanTur;
	}
	

	
	
	
	
	
}
