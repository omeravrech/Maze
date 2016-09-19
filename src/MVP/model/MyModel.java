package MVP.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.MazeGenerator.RandomChoose;
import Algorithms.Search.MazeAdapter;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel extends CommonModel
{
	@Override
	public void generate_3d_maze(String name, int floors, int rows, int columns)  throws IOException
	{
		try
		{
			if (mazes.containsKey(name))
			{
				this.commandOutput += "Another maze already exist under this name\n";
			}
			else
			{
				Future<Maze3D> future = this.pool.submit(new Callable<Maze3D>() 
				{
					private GrowingTreeGenerator generator;
					
					@Override
					public Maze3D call() throws Exception
					{
						generator = new GrowingTreeGenerator(new RandomChoose());
						return generator.generate(floors, rows, columns);
					}
				});
					
				mazes.put(name, future.get());
				this.commandOutput += "Maze " + name + " has been generated\n";
			
			}
		}
		catch (Exception e) {
			this.commandOutput += e.getMessage() + "\n";
		}
		this.setChanged();
		this.notifyObservers();
	}
	@Override
	public void solve(String name, Searcher<Position> algorithm) throws IOException
	{
		try
		{
			if (solutions.containsKey(name))
				this.commandOutput += "Solution is already exist under this name";
			else
			{
				if (!mazes.containsKey(name))
					this.commandOutput += "Can't find a maze under the requested name";
				else
				{
					Future<Solution<Position>> future = this.pool.submit(new Callable<Solution<Position>>()
					{
		
						@Override
						public Solution<Position> call() throws Exception
						{
							Maze3D maze = mazes.get(name); 
							return algorithm.search(new MazeAdapter(maze));
						}
					});
					solutions.put(name,future.get());
					this.commandOutput += "Solution is ready\n";
				}
			}
		}
		catch (InterruptedException | ExecutionException e)
		{
			this.commandOutput += e.getMessage() + "\n";
		}
		this.setChanged();
		this.notifyObservers();
	}
	public void display(String name)
	{
		StringBuilder string = new StringBuilder();
		if (!mazes.containsKey(name))
		{
			string.append("Maze doesn't exist");
		}
		else
		{
			Maze3D maze = mazes.get(name);
			string.append("*Start Position* :" + maze.getStartPosition().toString() + "\n");
			string.append("*Goal Position* :" + maze.getGoalPosition().toString() + "\n");
			string.append("\n" + maze.toString());
		}
		this.commandOutput += string.toString();
		this.setChanged();
		this.notifyObservers();
	}
	@Override
	public void exit() 
	{
		pool.shutdownNow();
		//TODO: exit
	}
	@Override
	public void save(String name, String path)
	{
		if (!mazes.containsKey(name))
			this.commandOutput += "Can't found an existing maze under this name";
		else
		{
			StringBuilder result = new StringBuilder();
			try
			{
				pool.submit(new Runnable()
				{
					private Maze3D maze = mazes.get(name);
					private OutputStream out;
					
					@Override
					public void run()
					{
						try
						{
							String string = path + "/" + name + ".maze";
							out = new MyCompressorOutputStream(new FileOutputStream(string));
							byte[] bytes = maze.toByteArray();
							out.write(bytes.length/128);
							out.write(bytes.length%128);
							out.write(bytes);
							out.flush();
							result.append("Maze " + name + " is saved\n");
							result.append("File save into " + string);
							out.close();
						}
						catch (Exception e)
						{
							result.append(e.getMessage() + "\n");
						}
					}
				}).get();
				this.commandOutput += result.toString();
			}
			catch (ExecutionException | InterruptedException e)
			{
				this.commandOutput += e.getMessage() + "\n";
			}
			this.setChanged();
			this.notifyObservers();
		}
	}
	@Override
	public void load(String name, String fileName) 
	{
		File file = new File(fileName);
		if (file.exists())
		{
			Future<Maze3D> future = pool.submit(new Callable<Maze3D>()
			{
				InputStream in;
				@Override
				public Maze3D call() throws Exception
				{
						in = new MyDecompressorInputStream(new FileInputStream(fileName));
						byte[] inArr = new byte[(in.read() & 0xff) * 128 + (in.read() & 0xff)];
						in.read(inArr);
						in.close();
						return new Maze3D(inArr);
				}
			});
			try
			{
				mazes.put(name, future.get());
				this.commandOutput += "Maze " + name + " been added from file\n";
			}
			catch (InterruptedException | ExecutionException e)
			{
				this.commandOutput += e.getMessage() + "\n";
			}
		}
		else
			this.commandOutput += "File '" + fileName + "' not exist\n";
		
		this.setChanged();
		this.notifyObservers();
		
	}
	@Override
	public void display_cross_section(String asix, int line, String name)
	{
		try
		{
			if (mazes.containsKey(name))
			{
				Maze3D maze = mazes.get(name);
				Pattern crossByX = Pattern.compile("[Xx]");
				Pattern crossByY = Pattern.compile("[Yy]");
				Pattern crossByZ = Pattern.compile("[Zz]");
				Matcher columns = crossByX.matcher(asix);
				Matcher rows = crossByY.matcher(asix);
				Matcher floors = crossByZ.matcher(asix);
				
				int[][] maze2d = null;
				if (columns.lookingAt())
					maze2d = maze.getCrossSectionByX(line);
				if (rows.lookingAt())
					maze2d = maze.getCrossSectionByY(line);
				if (floors.lookingAt())
					maze2d = maze.getCrossSectionByZ(line);
				
				for (int i=0;i<maze2d.length;i++)
				{
					for (int j=0;j<maze2d[i].length;j++)
						this.commandOutput += maze2d[i][j] + " ";
					this.commandOutput += "\n";
				}
			}
			else
				this.commandOutput += "The maze does not exist\n";
		}
		catch (IndexOutOfBoundsException e) {
			this.commandOutput += e.getMessage() + "\n";
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	@Override
	public void display_solution(String name) 
	{
		if (!mazes.containsKey(name))
			this.commandOutput += "Maze " + name + " doesn't exist\n";
		else
		{
			Solution<Position> solution = solutions.get(name);
			this.commandOutput += solution.toString() + "\n";	
		}
		this.setChanged();
		this.notifyObservers();
	}
	@Override
	public void dir(String path)
	{
		StringBuilder display = new StringBuilder();
		try
		{
			File[] fileList = new File(path).listFiles();

			if (fileList == null)
				display.append("File Not Found");
			else
			{
				display.append(path + "\n");
				for (File file : fileList)
				{
					if(file.isDirectory()==true)
						display.append("\t|- DIR");
						else
							display.append("\t|- ---");
					display.append("\t" + file.toString().substring(file.toString().lastIndexOf("\\") +1));
					display.append("\n");
				}
			}
		}
		catch (Exception e)
		{
			display.append(e.getMessage());
		}
		display.append("\n");
		this.commandOutput += display.toString();
		this.setChanged();
		this.notifyObservers();
	}		
}