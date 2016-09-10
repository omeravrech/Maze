package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI extends Thread
{
	HashMap<String,Command> commands;
	BufferedReader in;
	PrintWriter out;
	
}
