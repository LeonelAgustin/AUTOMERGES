package Logica;

public class Taller {
	private int cod_taller;
	private Mecanico mecanicoDeTurno;
	
	public Taller(int cod_taller, Mecanico mecanicoDeTurno) {
		super();
		this.cod_taller = cod_taller;
		this.mecanicoDeTurno = mecanicoDeTurno;
	}

	public int getCod_taller() {
		return cod_taller;
	}

	public void setCod_taller(int cod_taller) {
		this.cod_taller = cod_taller;
	}

	public Mecanico getMecanicoDeTurno() {
		return mecanicoDeTurno;
	}

	public void setMecanicoDeTurno(Mecanico mecanicoDeTurno) {
		this.mecanicoDeTurno = mecanicoDeTurno;
	}

	@Override
	public String toString() {
		return "Taller [cod_taller=" + cod_taller + ", mecanicoDeTurno=" + mecanicoDeTurno + "]";
	}
	
}
