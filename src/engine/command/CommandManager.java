package engine.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CommandManager {

	private List<Command> commands;
	
	public CommandManager()
	{
		commands=new ArrayList<Command>();
	}
	
	public boolean addCommand(String commandString,Function<String[],Object> command)
	{
		if(commandString==null || command==null)
			return false;
		for(Command c : commands)
			if(c.getName().equals(commandString))
				return false;
		commands.add(new Command(commandString,command));
		return true;
	}
	
	public Object execute(String command) throws Exception
	{
		if(command.equals("~quit"))
			throw new Exception("Got ~quit command");
		String[] parts=command.split(" ");
		String name=parts[0];
		String[] params=Arrays.copyOfRange(parts, 1, parts.length);
		for(Command c : commands)
			if(c.getName().equals(name))
				return c.getCommand().apply(params);
		
		return null;
	}
	
	private class Command
	{
		private String commandString;
		private Function<String[],Object> command;
		
		public Command(String commandString, Function<String[], Object> command) {
			this.commandString = commandString;
			this.command = command;
		}

		public String getName() {
			return commandString;
		}

		public Function<String[], Object> getCommand() {
			return command;
		}
	
	}
}
