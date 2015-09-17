package mykiddie.sqlite.helper;

public class Jadwal {

	private int _id;
	private String _jadwal;
	private String _waktu;
	
	public Jadwal (int _id, String _jadwal, String _waktu) {
		super();
		this._id = _id;
		this._jadwal = _jadwal;
		this._waktu = _waktu;
	}
	
	public int get_id() {
		return _id;
	}
	
	public void set_id() {
		this._id = _id;
	}
	
	public String get_jadwal() {
		return _jadwal;
	}
	
	public void set_jadwal() {
		this._jadwal = _jadwal;
	}
	
	public String get_waktu() {
		return _waktu;
	}
	
	public void set_waktu() {
		this._waktu = _waktu;
	}
	
}
