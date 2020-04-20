package filehandler;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import leveleditor.actors.Player;

import engine.Engine;

public class Filehandler {

	public static void save()
	{
		String filename="";
		FileDialog f = new FileDialog(new Frame(), "Save game", FileDialog.SAVE);
		f.setVisible(true);
		filename=f.getDirectory()+f.getFile();
		if (!filename.substring(filename.length()-4).equals(".toz"))
		{
			filename+=".toz";
		}
		if (filename!=null)
		{
			try {
				FileOutputStream fOut = new FileOutputStream(filename);
				try {
					ObjectOutputStream oOut = new ObjectOutputStream(fOut);
					oOut.writeObject(Engine.engine.getPlayer());
					oOut.close();
					fOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Engine.engine.getNavigateWindow().write("Game saved!\n");
		}
	}

	public static boolean load()
	{
		FileDialog f = new FileDialog(new Frame(), "Load game", FileDialog.LOAD);
		f.setVisible(true);
		String filename = f.getDirectory()+f.getFile();
		if (f.getFile() != null)
		{
			try {
				FileInputStream fis = new FileInputStream(filename);
				try {
					ObjectInputStream ois = new ObjectInputStream(fis);
					try {
						Engine.engine.setPlayer((Player) ois.readObject());
						ois.close();
						fis.close();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
