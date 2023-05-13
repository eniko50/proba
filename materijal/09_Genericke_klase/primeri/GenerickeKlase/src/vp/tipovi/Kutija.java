package vp.tipovi;

public class Kutija<T> {

	private T sadrzaj;

	Kutija(T t){
		this.sadrzaj = t;
	}
	public T getSadrzaj(){
		return sadrzaj;
	}
}
