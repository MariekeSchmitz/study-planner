package de.hsrm.mi.swt.SPAsS.business.commands;

/**
 * Interface with command execution and undo-features. 
 * A command represents a certain change caused by User Input.
 */
public interface ICommand {
	/**
 * executes command
 */
	public void execute(); 
	
	/**
 undo command
 */
	public void undo(); 
	
	public String describe();
}
