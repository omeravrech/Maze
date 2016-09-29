package MVP.view.Windows;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;

/**
* <h1>CanvasMaze3D class</h1>
*<br> This class represents the maze itself in the view<br>
* it will extend Canvas class and control the maze itself <br>
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   28/09/2016 
*
*/
public class CanvasMaze3D extends MazeDisplay
{
	protected Image wallImg, welcomeImg, fieldImg, characterImg, goalImg, downImg, upImg, finishImg, goingUpAndDown;
	protected boolean gameStatus;
	
	
	/**
	 * Constructor <br>
	 * Builds the maze and control the user's command (arrows, page up&down)
	 * @param parent Composite
	 * @param style int
	 */
	CanvasMaze3D(Composite parent, int style)
	{
		super(parent, style);
		
		welcomeImg = new Image(null,	getClass().getClassLoader().getResourceAsStream("Resources/Graphics/welcomeImage.jpg"));
		finishImg = new Image(null,		getClass().getClassLoader().getResourceAsStream("Resources/Graphics/winningImg.png"));
		wallImg = new Image(null,		getClass().getClassLoader().getResourceAsStream("Resources/Graphics/wall.png"));
		fieldImg = new Image(null,		getClass().getClassLoader().getResourceAsStream("Resources/Graphics/field.png"));
		characterImg = new Image(null,	getClass().getClassLoader().getResourceAsStream("Resources/Graphics/char1.png"));
		upImg = new Image(null,			getClass().getClassLoader().getResourceAsStream("Resources/Graphics/goingUpImg.png"));
		downImg = new Image(null,		getClass().getClassLoader().getResourceAsStream("Resources/Graphics/goingDownImg.png"));
		goingUpAndDown = new Image(null,getClass().getClassLoader().getResourceAsStream("Resources/Graphics/goingUpAndDown.png"));
		goalImg = new Image(null,		getClass().getClassLoader().getResourceAsStream("Resources/Graphics/char2.png"));
		
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent p)
			{
				if (maze == null)
				{
					setBackgroundImage(welcomeImg);
					return;
				}
				else
				{
					if (!character.equals(maze.getGoalPosition()))
					{
						setBackgroundImage(fieldImg);
							
						int[][] mazeData = maze.getCrossSectionByZ(character.floor());
						
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
								int pixelX = w * j;
								int pixelY = h * i;
								if (mazeData[i][j] == Maze3D.WALL)
								{
									p.gc.drawImage(wallImg, 0, 0, wallImg.getBounds().width,wallImg.getBounds().height,pixelX,pixelY ,w ,h);//draw walls
									System.out.print(mazeData[i][j] + " ");
								}
								else
								{
									int up = maze.positionStatus(new Position(character.floor()-1, i, j));
									int down = maze.positionStatus(new Position(character.floor()+1, i, j));
									
									if (up == down && up == Maze3D.PATH)
										p.gc.drawImage(goingUpAndDown, 0, 0, goingUpAndDown.getBounds().width, goingUpAndDown.getBounds().height, pixelX, pixelY, w, h);
									else if(up == Maze3D.PATH)
										p.gc.drawImage(downImg, 0, 0, downImg.getBounds().width,downImg.getBounds().height,pixelX,pixelY ,w ,h);
									else if(down == Maze3D.PATH)	
											p.gc.drawImage(upImg, 0, 0, upImg.getBounds().width,downImg.getBounds().height,pixelX,pixelY ,w ,h);
									if (mazeData[i][j] == Maze3D.END)
										p.gc.drawImage(goalImg, 0, 0, goalImg.getBounds().width,goalImg.getBounds().height,pixelX,pixelY ,w ,h);	//draw character
									if ((i == character.row()) && (j == character.column()))
									{
										p.gc.drawImage(characterImg, 0, 0, characterImg.getBounds().width,characterImg.getBounds().height,pixelX,pixelY ,w ,h);
										System.err.print(mazeData[i][j] + " ");
									}
									else
										System.out.print(mazeData[i][j] + " ");
								}
							}
							System.out.println("");
						}
						System.out.println("\n");
					}
					else
					{
						setBackgroundImage(finishImg);
						gameStatus = false;
					}
				}
			}
		});
	}

	@Override
	/** Moving the user one floor up */
	public void moveUp()
	{ 
		Position temp = new Position(character.floor(), character.row(), character.column());
		temp.move(1, 0, 0);
		if (maze.positionStatus(temp) != Maze3D.WALL)
		{
			character.move(2,0,0);
			redraw();
		}
	}
	
	/** Moving the user one floor down */
	public void moveDown()
	{
		Position temp = new Position(character.floor(), character.row(), character.column());
		temp.move(-1, 0, 0);
		if (maze.positionStatus(temp) != Maze3D.WALL)
		{
			character.move(-2,0,0);
			redraw();
		}
	}
	
	/** Moving the user one step forward */
	public void moveForward()
	{
		Position temp = new Position(character.floor(), character.row(), character.column());
		temp.move(0, -1, 0);
		if (maze.positionStatus(temp) != Maze3D.WALL)
		{
			character.move(0,-1,0);
			redraw();
		}
	}
	
	/** Moving the user one step backwards */
	public void moveBackward()
	{ 
		Position temp = new Position(character.floor(), character.row(), character.column());
		temp.move(0, 1, 0);
		if (maze.positionStatus(temp) != Maze3D.WALL)
		{
			character.move(0,1,0);
			redraw();
		}
		
	}
	
	/** Moving the user one step to the left */
	public void moveLeft()
	{
		Position temp = new Position(character.floor(), character.row(), character.column());
		temp.move(0, 0, -1);
		if (maze.positionStatus(temp) != Maze3D.WALL)
		{
			character.move(0,0,-1);
			redraw();
		}
	}
	
	
	/** Moving the user one step to the right */
	public void moveRight()	
	{
		Position temp = new Position(character.floor(), character.row(), character.column());
		temp.move(0, 0, 1);
		if (maze.positionStatus(temp) != Maze3D.WALL)
		{
			character.move(0,0,1);
			redraw();
		}
	}

	@Override
	public void setCharacterPosition(int floor, int row, int column) {
		{
			character = new Position(floor,row,column);
			this.redraw();
		}
	}
}
