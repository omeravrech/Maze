package MVP.model;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import Algorithms.MazeGenerator.GrowingTreeGenerator;
import Algorithms.MazeGenerator.Maze3D;
import Algorithms.MazeGenerator.Position;
import Algorithms.MazeGenerator.RandomChoose;
import Algorithms.Search.MazeAdapter;
import Algorithms.Search.Searcher;
import Algorithms.Search.Solution;

public class MyModel extends CommonModel
{

	@Override
	public void generate_3d_maze(String name, int floors, int rows, int columns)  throws IOException
	{
		try
		{
			if (mazes.containsKey(name))
			{
				this.setChanged();
				this.notifyObservers("Another maze already exist under this name");
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
					this.setChanged();
					this.notifyObservers("Maze is ready");
				}
		}
		catch (InterruptedException | ExecutionException e) {
			throw new IOException(e);
		}
	}
	@Override
	public void solve(String name, Searcher<Position> algorithm) throws IOException
	{
		try
		{
			if (solutions.containsKey(name))
			{
				
				this.setChanged();
				this.notifyObservers("Solution is already exist under this name");
			}
			else
			{
				if (!mazes.containsKey(name))
				{
					this.setChanged();
					this.notifyObservers("Can't find a maze under the requested name");
				}
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
					this.setChanged();
					this.notifyObservers("Solution is ready");
				}
			}
		}
		catch (InterruptedException | ExecutionException e)
		{
			throw new IOException(e);
		}
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

		this.setChanged();
		this.notifyObservers(string);
	}
	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void save(String name, String path) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void load(String name, String path) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display_cross_section(char asix, int line, String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display_solution(String name) 
	{
		StringBuilder string = new StringBuilder();
		if (!mazes.containsKey(name))
			string.append("Maze " + name + " doesn't exist");
		else
		{
			Solution<Position> solution = solutions.get(name);
				
			this.setChanged();
			this.notifyObservers(solution.toString());
			}
		
		
	}
	@Override
	public void dir(String path) {
		// TODO Auto-generated method stub
		
	}
}