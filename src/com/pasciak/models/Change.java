package com.pasciak.models;

public class Change {
	private long twentiesNeeded;
	private long tensNeeded;
	private long fivesNeeded;
	private long onesNeeded;
	private long quartersNeeded;
	private long dimesNeeded;
	private long nickelsNeeded;
	private long penniesNeeded;

	// Constructor
	public Change(long twentiesNeeded, long tensNeeded, long fivesNeeded, long onesNeeded, long quartersNeeded,
			long dimesNeeded, long nickelsNeeded, long penniesNeeded) {
		this.twentiesNeeded = twentiesNeeded;
		this.tensNeeded = tensNeeded;
		this.fivesNeeded = fivesNeeded;
		this.onesNeeded = onesNeeded;
		this.quartersNeeded = quartersNeeded;
		this.dimesNeeded = dimesNeeded;
		this.nickelsNeeded = nickelsNeeded;
		this.penniesNeeded = penniesNeeded;
	}

	// Getters and setters
	public long getTwentiesNeeded() {
		return twentiesNeeded;
	}

	public void setTwentiesNeeded(long twentiesNeeded) {
		this.twentiesNeeded = twentiesNeeded;
	}

	public long getTensNeeded() {
		return tensNeeded;
	}

	public void setTensNeeded(long tensNeeded) {
		this.tensNeeded = tensNeeded;
	}

	public long getFivesNeeded() {
		return fivesNeeded;
	}

	public void setFivesNeeded(long fivesNeeded) {
		this.fivesNeeded = fivesNeeded;
	}

	public long getOnesNeeded() {
		return onesNeeded;
	}

	public void setOnesNeeded(long onesNeeded) {
		this.onesNeeded = onesNeeded;
	}

	public long getQuartersNeeded() {
		return quartersNeeded;
	}

	public void setQuartersNeeded(long quartersNeeded) {
		this.quartersNeeded = quartersNeeded;
	}

	public long getDimesNeeded() {
		return dimesNeeded;
	}

	public void setDimesNeeded(long dimesNeeded) {
		this.dimesNeeded = dimesNeeded;
	}

	public long getNickelsNeeded() {
		return nickelsNeeded;
	}

	public void setNickelsNeeded(long nickelsNeeded) {
		this.nickelsNeeded = nickelsNeeded;
	}

	public long getPenniesNeeded() {
		return penniesNeeded;
	}

	public void setPenniesNeeded(long penniesNeeded) {
		this.penniesNeeded = penniesNeeded;
	}

	// toString method
	@Override
	public String toString() {
		return "\nChange \n[twentiesNeeded=" + twentiesNeeded + ", \ntensNeeded=" + tensNeeded + ", \nfivesNeeded="
				+ fivesNeeded + ", \nonesNeeded=" + onesNeeded + ", \nquartersNeeded=" + quartersNeeded
				+ ", \ndimesNeeded=" + dimesNeeded + ", \nnickelsNeeded=" + nickelsNeeded + ", \npenniesNeeded="
				+ penniesNeeded + "]";
	}

	public Double getTotal() {
		return (double) (twentiesNeeded * 20 + tensNeeded * 10 + fivesNeeded * 5 + onesNeeded + quartersNeeded * 0.25
				+ dimesNeeded * 0.10 + nickelsNeeded * 0.05 + penniesNeeded * 0.01);
	}

}
