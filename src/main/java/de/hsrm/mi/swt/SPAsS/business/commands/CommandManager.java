package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
	private static CommandManager theCommandManager = null;
	
	List<ICommand> commands = new ArrayList<ICommand>();
	int index = 0;
	
	private CommandManager() {}
	
	public static CommandManager getInstance() {
		if (theCommandManager == null) {
			theCommandManager = new CommandManager();
		}
		return theCommandManager;
	}
	
	public void pushCommand(ICommand cmd) {
		if (index < commands.size()) {
			commands = commands.subList(0, index);
		}
		commands.add(cmd);
		index++;
	}
	
	public void undo() {
		if (index > 0) {
			index--;
			ICommand cmd = commands.get(index);
			cmd.undo();
		} else {
			throw new UndoRedoException("Nothing to undo");
		}
	}
	
	public void redo() {
		if (index < commands.size()) {
			ICommand cmd = commands.get(index);
			cmd.execute();
			index++;
		} else {
			throw new UndoRedoException("Nothing to redo");
		}
	}

	public void execAndPush(ICommand cmd) {
		cmd.execute();
		pushCommand(cmd);
	}
}