package MVP.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;

public class Maze2D extends MazeDisplayer
{

	
	public Maze2D(Composite parent, int style)
	{
		super(parent, SWT.DOUBLE_BUFFERED);
		String filePath = "Resources/Graphics/";
    	Image background = new Image(getDisplay(),filePath+ "field.png");
    	Image charecter = new Image(getDisplay(),filePath+ "char1.png");
    	Image misty = new Image(getDisplay(),filePath+ "misty.png");
    	Image winningImg = new Image(getDisplay(),filePath+ "winningImg.png");
    	Image wall = new Image(getDisplay(),filePath+ "wall.png");
    	Image goingUpImg = new Image(getDisplay(),filePath+ "goingUpImg.png");
    	Image goingDownImg = new Image(getDisplay(),filePath+ "goingDownImg.png");
    	
		setBackgroundImage(background);
		
		addPaintListener(new PaintListener()
		{
			
			@Override
			public void paintControl(PaintEvent e)
			{
				try 
				{
					if (maze!=null && currentPosition !=null && startPosition!=null && goalPosition!=null)
					{
						if (currentPosition.equals(goalPosition))
						{
							setBackgroundImage(winningImg);
							return;
						}
				   
				   e.gc.setForeground(new Color(null,255,255,255));
				   e.gc.setBackground(new Color(null,0,0,0));
				   int width = getSize().x;
				   int height = getSize().y;
			       int[][] currentFloor = maze.getCrossSectionByZ(currentPosition.floor());
				   int w = width/maze.getRows(); //getMaze3d()[1][1].length;
				   int h = height/maze.getColumns(); //getMaze3d()[1].length;
				   for (int i=1; i<currentFloor.length-1; i++)
				      for (int j=1;j<currentFloor[i].length-1;j++)
				      {
				          int x = j * w;
				          int y = i * h;
				          
				          if (currentFloor[i][j] == Maze3D.WALL)
				               e.gc.drawImage(wall, 0, 0, wall.getBounds().width, wall.getBounds().height, x, y,w,h);
				          else
				          {
					          if (i == currentPosition.row() && j == currentPosition.column())
					          {
					        		e.gc.drawImage(charecter, 0, 0, charecter.getBounds().width, charecter.getBounds().height, x, y,w,h);
					          }
					            
					          if (i == goalPosition.row() && j == goalPosition.column() && currentPosition.floor() == goalPosition.floor())
					          {
					        	  e.gc.drawImage(winningImg, 0, 0, winningImg.getBounds().width, winningImg.getBounds().height, x, y,w,h);
					          }
				          }
					 		if (maze.positionStatus(new Position(currentPosition.floor() + 1, i, j)) != Maze3D.WALL)
					 		{
					 			e.gc.drawImage(goingUpImg, 0, 0, goingUpImg.getBounds().width, goingUpImg.getBounds().height, x +(2*(w/3)), y + (h/2),w/3,h/3);
							}
							if (maze.positionStatus(new Position(currentPosition.floor() - 1, i, j)) != Maze3D.WALL)
							{
								e.gc.drawImage(goingDownImg, 0, 0, goingDownImg.getBounds().width, goingDownImg.getBounds().height, x, y+(h/2),w/3,h/3);
							}
				        	
				         

				          	  
				      }
				
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}
		});
 }

	

	@Override
	public void setCharacterPosition(Maze3D maze) 
	{
		Position p = maze.getStartPosition();
		p.setRows(startPosition.column()+1);
		moveCharacter(p);

	}

	@Override
	public void moveCharacterUp() 
	{
		checker = currentPosition;
		checker.moveUp();
		if(	maze.getPossibleMoves(checker.getPosition()).contains(checker.getPosition()))
		{
			currentPosition = checker;
			moveCharacter(currentPosition.getPosition());
		}

	}

	@Override
	public void moveCharacterDown() 
	{
		checker = currentPosition;
		checker.moveDown();
		if(	maze.getPossibleMoves(checker.getPosition()).contains(checker.getPosition()))
		{
			currentPosition = checker;
			moveCharacter(currentPosition.getPosition());
		}
	}

	@Override
	public void moveCharacterLeft()
	{
		checker = currentPosition;
		checker.moveLeft();
		if(	maze.getPossibleMoves(checker.getPosition()).contains(checker.getPosition()))
		{
			currentPosition = checker;
			moveCharacter(currentPosition.getPosition());
		}
	}

	@Override
	public void moveCharacterRight() 
	{
		checker = currentPosition;
		checker.moveRight();
		if(	maze.getPossibleMoves(checker.getPosition()).contains(checker.getPosition()))
		{
			currentPosition = checker;
			moveCharacter(currentPosition.getPosition());
		}
	}

	@Override
	public void moveCharacterForward() 
	{
		checker = currentPosition;
		checker.moveForward();
		if(	maze.getPossibleMoves(checker.getPosition()).contains(checker.getPosition()))
		{
			currentPosition = checker;
			moveCharacter(currentPosition.getPosition());
		}
	}

	@Override
	public void moveCharacterBackward() 
	{
		checker = currentPosition;
		checker.moveBackward();
		if(	maze.getPossibleMoves(checker.getPosition()).contains(checker.getPosition()))
		{
			currentPosition = checker;
			moveCharacter(currentPosition.getPosition());
		}
	}
	
	private void moveCharacter(Position move) 
	{
		redraw();
	}

}
