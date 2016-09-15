package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.MazeGenerator.RandomChoose;
import Algorithms.Search.MazeAdapter;
import Algorithms.Search.Searchable;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel extends CommonModel
{
	class GenerateMazeRunnable implements Runnable
	{
		private int floors, rows, cols;
		private String name;
		private GrowingTreeGenerator generator;
		
		public GenerateMazeRunnable(String name, int floors, int rows, int cols)
		{
			this. floors = floors;
			this.rows = rows;
			this.cols = cols;
			this.name = name;
		}
		
		@Override
		public void run() {
			generator = new GrowingTreeGenerator(new RandomChoose());
			Maze3D maze = generator.generate(floors, rows, cols);
			mazeMap.put(name, maze);
			
			controller.notify("Maze " + name + " is ready.");			
		}	
	}
	
	@Override
	public Maze3D display(String name) 
	{
		if (mazeMap.containsKey(name))
			return mazeMap.get(name);
		else
			return null;
	}
	@Override
	public Solution<Position> display_solution(String name)
	{
		if (solutionMap.containsKey(name))
			return this.solutionMap.get(name);
		else
			return null;
	}
	@Override
	public int[][] display_cross_section(char asix, int line, String name)
	{
		if (!mazeMap.containsKey(name))
			return null;
		else
			{
				Maze3D maze = this.mazeMap.get(name);
				switch (asix)
				{
					case 88:
						 return maze.getCrossSectionByX(line);
					case 89:
						return maze.getCrossSectionByY(line);
					case 90:
						return maze.getCrossSectionByZ(line);
					default:
						return null;
				}
			}
	}
	public void generate_maze(String name, int floors, int rows, int columns)
	{
		GenerateMazeRunnable generateMaze = new GenerateMazeRunnable(name, floors, rows, columns);
		Thread thread = new Thread(generateMaze);
		thread.start();
		threads.add(thread);		
	}
	@Override
	public File[] dir(String path)
	{
		return new File(path).listFiles();
	}
	@Override
	public void save(String name, String path)
	{
		if (!mazeMap.containsKey(name))
			controller.notify("Maze doesn't exist.");
		else
		{
			Thread thread = new Thread(new Runnable()
			{
				
				private Maze3D maze = mazeMap.get(name);
				private OutputStream out = null;
				
				@Override
				public void run()
				{
					controller.notify("Start to calculation your request...");
					try
					{
						out = new MyCompressorOutputStream(new FileOutputStream(path + "\\" + name + ".maz"));
						byte[] bytes = maze.toByteArray();
						out.write(bytes.length/127);
						out.write(bytes.length%127);
						out.write(bytes);
						out.flush();
						controller.notify("Maze " + name + " is saved");
					}
					catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
							try {
								out.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}
				
				public void terminate()
				{
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
			threads.add(thread);
			
		}
		
	}
	@Override
	public void load(String name, String path)
	{
			Thread thread = new Thread(new Runnable()
			{
				InputStream in;
				@Override
				public void run()
				{
					controller.notify("Start to calculation your request...");
					try
					{
						in = new MyDecompressorInputStream(new FileInputStream(path + "\\" + name + ".maz"));
						byte[] inArr = new byte[in.read() * 127 + in.read()];
						in.read(inArr);
						
						Maze3D maze = new Maze3D(inArr);
						mazeMap.put(name, maze);
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						controller.notify("Maze " + name + " been loaded");
					}
				}
			});
			thread.start();
			threads.add(thread);
	}
	@Override
	public void solve(String name, Searcher<Position> algorithm) throws IOException

	{
			if (!mazeMap.containsKey(name))
				throw new IOException("Maze doesn't exist.");
			else
			{
				Searchable<Position> problem = new MazeAdapter(mazeMap.get(name));
				Thread thread = new Thread(new Runnable() {
		
					@Override
					public void run()
					{
						Solution<Position> solution = algorithm.search(problem);
						solutionMap.put(name,solution);
						controller.notify("Solution for " + name + " is ready.");
					}
				});
				thread.start();
				threads.add(thread);
			}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void exit()
	{
		//TODO: Check if this method will make the program burst into flames
		for (Thread thread : threads) {
			thread.stop();
			
		}		
	}
}
