package org.usfirst.frc.team2642.robot.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.usfirst.frc.team2642.robot.RobotMap;

public class RoboRioLogger 
{
	PrintWriter printWriter;
	
	String logDirectory = RobotMap.logDirectory;
	String fileName = RobotMap.logFileName;
	String fullyQualifiedFileName = logDirectory + fileName;
	public RoboRioLogger()
	{
		File log = new File(fullyQualifiedFileName);
		Path logDirectoryPath = Paths.get(logDirectory);
		Path fullPath = Paths.get(log.toURI());
		try
		{
			if (Files.notExists(fullPath, LinkOption.NOFOLLOW_LINKS))
			{
				if (Files.notExists(logDirectoryPath, LinkOption.NOFOLLOW_LINKS))
				{
					Files.createDirectories(logDirectoryPath);
				}
				Files.createFile(fullPath);
			}
			printWriter = new PrintWriter(new BufferedWriter(new FileWriter(log, true)));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void log(String toLog)
	{
		printWriter.println(toLog);
	}
	
	public void flush()
	{
		printWriter.flush();
	}
	  
	public void close()
	{
		printWriter.close();
	}
}
