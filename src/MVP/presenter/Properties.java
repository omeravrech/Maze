package MVP.presenter;

import java.io.Serializable;

public class Properties implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int numOfThreads;
	private String generateMazeAlgorithm;
	private String solveMazeAlgorithm;
	private String solutionMapPath;
	private String mazesMapPath;
	public Properties()
	{
		
	}
	
	public String getSolutionMapPath() 
	{
		return solutionMapPath;
	}

	public void setSolutionMapPath(String solutionMapPath) {
		this.solutionMapPath = solutionMapPath;
	}
			
	public int getNumOfThreads() {
		return numOfThreads;
	}
	public void setNumOfThreads(int numOfThreads) {
		this.numOfThreads = numOfThreads;
	}
	public String getGenerateMazeAlgorithm() {
		return generateMazeAlgorithm;
	}
	public void setGenerateMazeAlgorithm(String generateMazeAlgorithm) {
		this.generateMazeAlgorithm = generateMazeAlgorithm;
	}
	public String getSolveMazeAlgorithm() {
		return solveMazeAlgorithm;
	}
	public void setSolveMazeAlgorithm(String solveMazeAlgorithm) {
		this.solveMazeAlgorithm = solveMazeAlgorithm;
	}

	public String getMazesMapPath() {
		return mazesMapPath;
	}

	public void setMazesMapPath(String mazesMapPath) {
		this.mazesMapPath = mazesMapPath;
	}
}
