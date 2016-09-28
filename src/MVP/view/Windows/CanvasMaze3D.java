package MVP.view.Windows;

import java.util.ArrayList;
import java.util.Stack;

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
import Algorithms.Search.Solution;

public class CanvasMaze3D extends Canvas
{
	
	protected Maze3D maze;
	protected Image wallImg, welcomeImg, fieldImg, characterImg, endImg, downImg, upImg,finishImg,goingUpAndDown;
	protected boolean drawMap;
	protected CurrentPosition currentPosition;
	protected boolean gameStatus;
	
	public void updateActiveMaze(Maze3D maze)
	{
		this.maze = maze;
		this.gameStatus = true;
		currentPosition = new CurrentPosition(maze.getStartPosition());
		redrawCanvas();
	}
	
	CanvasMaze3D(Composite parent, int style)
	{
		super(parent, style);
		
		maze = null;
		currentPosition = null;
		drawMap = true;
		welcomeImg = new Image(null,	"Resources/Graphics/welcomeImage.jpg");
		finishImg = new Image(null,		"Resources/Graphics/winningImg.png");
		wallImg = new Image(null,		"Resources/Graphics/wall.png");
		fieldImg = new Image(null,		"Resources/Graphics/field.png");
		characterImg = new Image(null,	"Resources/Graphics/char1.png");
		upImg = new Image(null,			"Resources/Graphics/goingUpImg.png");
		downImg = new Image(null,		"Resources/Graphics/goingDownImg.png");
		endImg = new Image(null,		"Resources/Graphics/pikaImg.gif");
		goingUpAndDown = new Image(null,"Resources/Graphics/goingUpAndDown.png");
		
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent p)
			{
				if (maze == null)
				{
					setBackgroundImage(welcomeImg);
					gameStatus = false;
				}
				else
				{
					if (!currentPosition.getPosition().equals(maze.getGoalPosition()))
					{
						setBackgroundImage(fieldImg);
						
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
								int pixelX = w * j;
								int pixelY = h * i;
								if (mazeData[i][j] == Maze3D.WALL)
								{
									p.gc.drawImage(wallImg, 0, 0, wallImg.getBounds().width,wallImg.getBounds().height,pixelX,pixelY ,w ,h);//draw walls
									System.out.print(mazeData[i][j] + " ");
								}
								else
								{
									int up = maze.positionStatus(new Position(currentPosition.floor()-1, i, j));
									int down = maze.positionStatus(new Position(currentPosition.floor()+1, i, j));
									
									if(up == Maze3D.PATH)
									{
										p.gc.drawImage(downImg, 0, 0, downImg.getBounds().width,downImg.getBounds().height,pixelX,pixelY ,w ,h);
									}
									if(down == Maze3D.PATH)	
									{
											p.gc.drawImage(upImg, 0, 0, upImg.getBounds().width,downImg.getBounds().height,pixelX,pixelY ,w ,h);
									}
									if (up == down && up == Maze3D.PATH)
									{
										p.gc.drawImage(goingUpAndDown, 0, 0, goingUpAndDown.getBounds().width, goingUpAndDown.getBounds().height, pixelX, pixelY, w, h);
									}
									if (mazeData[i][j] == Maze3D.END)
									{
										p.gc.drawImage(endImg, 0, 0, endImg.getBounds().width,endImg.getBounds().height,pixelX,pixelY ,w ,h);	//draw character
									}
									if ((i == currentPosition.row()) && (j == currentPosition.column()))
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
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				if (gameStatus)
				{
					ArrayList<Position> possibleMoves = maze.getPossibleMoves(currentPosition.getPosition());
					
					switch (e.keyCode)
					{
					case SWT.ARROW_UP:
						if (possibleMoves.contains(new Position(currentPosition.floor(), currentPosition.row()-1, currentPosition.column())))
							currentPosition.moveForward();
						break;
					case SWT.ARROW_DOWN:
						if (possibleMoves.contains(new Position(currentPosition.floor(), currentPosition.row()+1, currentPosition.column())))
							currentPosition.moveBackward();
						break;
					case SWT.ARROW_LEFT:
						if (possibleMoves.contains(new Position(currentPosition.floor(), currentPosition.row(), currentPosition.column()-1)))
							currentPosition.moveLeft();
						break;
					case SWT.ARROW_RIGHT:
						if (possibleMoves.contains(new Position(currentPosition.floor(), currentPosition.row(), currentPosition.column()+1)))
						currentPosition.moveRight();
						break;
					case SWT.PAGE_UP:
						if (possibleMoves.contains(new Position(currentPosition.floor()+1, currentPosition.row(), currentPosition.column())))
						currentPosition.moveUp();
						break;
					case SWT.PAGE_DOWN:
						if (possibleMoves.contains(new Position(currentPosition.floor()-1, currentPosition.row(), currentPosition.column())))
						currentPosition.moveDown();
						break;
						
					default:
							System.out.print("Wrong move");
					}
					
					redrawCanvas();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	public void updateSolution(Solution<Position> solution)
	{
		{
			new Thread(new Runnable() {	
				@Override
				public void run()
				{
					Stack<Position> pathToGoal = solution.getResult();
					Position pos;
					while (!pathToGoal.isEmpty())
					{
						pos = pathToGoal.pop();
						currentPosition.setPoistion(pos);
						redrawCanvas();
					}
					//timer.cancel();
				}
				
			}).start();
		}
	}
	
	private void redrawCanvas()
	{
		getDisplay().syncExec(new Runnable()
		{
		
		@Override
			public void run()
			{
				setEnabled(true);
				redraw();
			}
		});
	}
	
	public CurrentPosition getCurrentPosition()
	{
		return currentPosition;
	}
	
}
