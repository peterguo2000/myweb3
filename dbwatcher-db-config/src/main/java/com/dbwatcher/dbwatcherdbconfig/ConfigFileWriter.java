package com.dbwatcher.dbwatcherdbconfig;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigFileWriter {
	public static void appendToFile(String fileName, String content) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

}
