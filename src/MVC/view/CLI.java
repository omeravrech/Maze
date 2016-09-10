package MVC.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import MVC.controller.ICommand;

public class CLI extends Thread
{
	HashMap<String,ICommand> commands;
	BufferedReader in;
	PrintWriter out;
	
}
