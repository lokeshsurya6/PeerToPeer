package p2p;

/*
 *Class to hold the Common.cfg file
 */
public class Commons {
	private int numberOfPreferredNeighbors;
	private double unchokingInterval;
	private double optimisticUnchokingInterval;
	private String fileName;
	private int fileSize;
	private int pieceSize;
	
	public int getNumberOfPreferredNeighbors() {
		return numberOfPreferredNeighbors;
	}
	public void setNumberOfPreferredNeighbors(int numberOfPreferredNeighbors) {
		this.numberOfPreferredNeighbors = numberOfPreferredNeighbors;
	}
	public double getUnchokingInterval() {
		return unchokingInterval;
	}
	public void setUnchokingInterval(double unchokingInterval) {
		this.unchokingInterval = unchokingInterval;
	}
	public double getOptimisticUnchokingInterval() {
		return optimisticUnchokingInterval;
	}
	public void setOptimisticUnchokingInterval(double optimisticUnchokingInterval) {
		this.optimisticUnchokingInterval = optimisticUnchokingInterval;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public int getPieceSize() {
		return pieceSize;
	}
	public void setPieceSize(int pieceSize) {
		this.pieceSize = pieceSize;
	}

}