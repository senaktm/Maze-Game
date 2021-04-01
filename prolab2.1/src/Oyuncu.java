
public abstract class Oyuncu extends Karakter{
	private int oyuncuID;
	private String oyuncuAd;
	private String oyuncuTur;
	private static int skor=20;
	
	public abstract int PuanGoster(int puan);
	
	

	public Oyuncu() {
	
	}


	public Oyuncu(int karakterID, String karakterAd, String karakterTur, Lokasyon lokasyon) {
	    super.getLokasyon();
		oyuncuID=super.getKarakterID();
		oyuncuAd=super.getKarakterAd();
		oyuncuTur=super.getKarakterTur();
		this.skor=skor;
	}


	public Oyuncu(int oyuncuID, String oyuncuAd, String oyuncuTur, int skor) {
		super();
		this.oyuncuID = oyuncuID;
		this.oyuncuAd = oyuncuAd;
		this.oyuncuTur = oyuncuTur;
		this.skor = skor;
	}




	public int getOyuncuID() {
		return oyuncuID;
	}




	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}




	public String getOyuncuAd() {
		return oyuncuAd;
	}




	public void setOyuncuAd(String oyuncuAd) {
		this.oyuncuAd = oyuncuAd;
	}




	public String getOyuncuTur() {
		return oyuncuTur;
	}




	public void setOyuncuTur(String oyuncuTur) {
		this.oyuncuTur = oyuncuTur;
	}




	public int getSkor() {
		return skor;
	}




	public void setSkor(int skor) {
		this.skor = skor;
	}

	
	
	
	
	
	
	

}
