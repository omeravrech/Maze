package MVP.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class GameCharacter extends Canvas 
{
	protected int axisX, axisY, width, height;
	public int getaxisX() 
	{
		return axisX;
	}

	public void setaxisX(int axisX) {
		this.axisX = axisX;
	}
	public int getaxisY() {
		return axisY;
	}
	public void setaxisY(int axisY) {
		this.axisY = axisY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	protected int previousaxisX, previousaxisY;
	public GameCharacter(Composite parent, int style) 
	{
		super(parent, SWT.DOUBLE_BUFFERED);
		
		parent.addPaintListener(new PaintListener() 
		{
			
			@Override
			public void paintControl(PaintEvent pe) 
			{
				pe.gc.setAntialias(SWT.ON);
				pe.gc.setInterpolation(SWT.HIGH);
				drawCharacter(pe.gc, getaxisX(), getaxisY(), getWidth(), getHeight());
				
			}
		});
		
	}
	public abstract void drawCharacter (GC gc,int axisX, int axisY, int width, int height);

}
