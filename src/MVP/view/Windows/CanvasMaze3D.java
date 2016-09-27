package MVP.view.Windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;

public class CanvasMaze3D extends Canvas
{
	
	protected Maze3D maze;
	
	protected Image wallImg, welcomeImg, fieldImg, characterImg, endImg, downImg, upImg;
	protected boolean drawMap;
	protected CurrentPosition currentPosition;
	
	public void updateActiveMaze(Maze3D maze)
	{
		this.maze = maze;
		currentPosition = new CurrentPosition(maze.getStartPosition());
		getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run()
			{
				setEnabled(true);
				redraw();
			}
		});
	}
	
	CanvasMaze3D(Composite parent, int style)
	{
		super(parent, style);
		
		maze = null;
		currentPosition = null;
		drawMap = true;
		welcomeImg = new Image(null,	"Resources/Graphics/welcomeImage.jpg");
		wallImg = new Image(null,		"Resources/Graphics/wall.png");
		fieldImg = new Image(null,		"Resources/Graphics/field.png");
		characterImg = new Image(null,	"Resources/Graphics/char1.png");
		upImg = new Image(null,			"Resources/Graphics/goingUpImg.png");
		downImg = new Image(null,		"Resources/Graphics/goingDownImg.png");
		endImg = new Image(null,		"Resources/Graphics/pikaImg.gif");
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent p)
			{
				if (maze == null)
				{
					setBackgroundImage(welcomeImg);
				}
				else
				{
					
					p.gc.drawImage(fieldImg, 0, 0, fieldImg.getBounds().width, fieldImg.getBounds().height,0,0,getSize().x,getSize().y);
					
					int[][] mazeData = maze.getCrossSectionByZ(currentPosition.floor());
					
					
					int width = getSize().x;
	
					int depth = getSize().y;
	
	
	
					int w = width / mazeData[0].length;// the width of a cell
	
					int h = depth / mazeData.length; // the height of a cell
	
	
	
					// for calculating the size of the maze floor
	
					int lengthWidth = mazeData[0].length;// z axis length
	
					int lengthDepth = mazeData.length;// y axis length
	
	
					for (int i = 0; i < lengthDepth; i++)
					{
						for (int j = 0; j < lengthWidth; j++)
						{

							System.out.print(mazeData[i][j] + " ");
							int pixelX = w * j;
							int pixelY = h * i;
							if (mazeData[i][j] == Maze3D.WALL)
								p.gc.drawImage(wallImg, 0, 0, wallImg.getBounds().width,wallImg.getBounds().height,pixelX,pixelY ,w ,h);	//draw walls
							if (mazeData[i][j] == Maze3D.END)
								p.gc.drawImage(endImg, 0, 0, endImg.getBounds().width,endImg.getBounds().height,pixelX,pixelY ,w ,h);	//draw character
							if(maze.positionStatus(new Position(currentPosition.floor()-1, i, j)) == Maze3D.PATH)	
								p.gc.drawImage(downImg, 0, 0, downImg.getBounds().width,downImg.getBounds().height,pixelX,pixelY ,w ,h);
							if(maze.positionStatus(new Position(currentPosition.floor()+1, i, j)) == Maze3D.PATH)	
									p.gc.drawImage(upImg, 0, 0, upImg.getBounds().width,downImg.getBounds().height,pixelX,pixelY ,w ,h);
							if ((i == currentPosition.row()) && (j == currentPosition.column()))
								p.gc.drawImage(characterImg, 0, 0, characterImg.getBounds().width,characterImg.getBounds().height,pixelX,pixelY ,w ,h);
						}
						System.out.println("");
					}
				}
			}
		});
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				switch (e.keyCode)
				{
				case SWT.ARROW_UP:
					if (maze.positionStatus(new Position(currentPosition.floor(), currentPosition.row()+1, currentPosition.column())) != Maze3D.WALL)
						currentPosition.moveForward();
					break;
				case SWT.ARROW_DOWN:
					if (maze.positionStatus(new Position(currentPosition.floor(), currentPosition.row()-1, currentPosition.column())) != Maze3D.WALL)
						currentPosition.moveBackward();
					break;
				case SWT.ARROW_LEFT:
					if (maze.positionStatus(new Position(currentPosition.floor(), currentPosition.row(), currentPosition.column()+1)) != Maze3D.WALL)
						currentPosition.moveLeft();
					break;
				case SWT.ARROW_RIGHT:
					if (maze.positionStatus(new Position(currentPosition.floor(), currentPosition.row(), currentPosition.column()-1)) != Maze3D.WALL)
					currentPosition.moveRight();
					break;
				case SWT.PAGE_UP:
					if (maze.positionStatus(new Position(currentPosition.floor()+1, currentPosition.row(), currentPosition.column())) != Maze3D.WALL)
					currentPosition.moveUp();
					break;
				case SWT.PAGE_DOWN:
					if (maze.positionStatus(new Position(currentPosition.floor()-1, currentPosition.row(), currentPosition.column())) != Maze3D.WALL)
					currentPosition.moveDown();
					break;
				}
				
				getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run()
					{
						setEnabled(true);
						redraw();
					}
				});
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	//private void DrawMaze()
	
}
