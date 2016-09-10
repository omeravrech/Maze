package model;

public interface Model
{

	void generateMaze(String name, int floors, int rows, int columns);
	void displayMaze(String name);
	void getCrossSection(String name, char asix, int index);
	void save(String name, String filepath);
	void load(String name, String filepath);
	void solve (String name);
	void exit();
}
