package your.package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class OptifineUtils {
	
	public static File config = new File(Minecraft.getMinecraft().mcDataDir, "optionsof.txt");
	
	public static boolean isUseOptifine() {
		
		if(config.exists()) {
			return true;
		}
		return false;
	}
	
	public static boolean isFastRender() {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(config));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (String s : lines) {
			if(s.equals("ofFastRender:true")) {
				return true;
			}
		}		
		return false;
	}
}