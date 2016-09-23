package MVP.view;

import java.util.Observable;

public class MazeDisplayAdapter extends Observable 
{
	protected MazeDisplayer mazePainter;
	protected boolean in = true;
	
	
	
	public MazeDisplayAdapter(MazeDisplayer md) 
	{
		this.mazePainter = md;
	}
	
	public void setMazePainter(Object o)
	{
		mazePainter.setCanvas(o);
		setChanged();
		notifyObservers();
	}
	
	public MazeDisplayer getMazeDisplayer()
	{
		return mazePainter;
	}
	
	
	public void paintMaze(){
		mazePainter.getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run() {
				if (in) {
					mazePainter.redraw();
					System.out.println("redrawing");
				}
				
				
			}
		});
	}
	

}
