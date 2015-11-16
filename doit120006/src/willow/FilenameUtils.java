package willow;

import java.io.File;
import java.util.ArrayList;

/**
 * FilenameUtils.java
 */
@SuppressWarnings("unused")
public class FilenameUtils{
	public static final char 	EXTENSION_SEPARATOR 	= 46;
	public static final String 	EXTENSION_SEPARATOR_STR = new Character('.').toString();
	private static final char	WINDOWS_SEPARATOR 		= 92;
	private static final char	SYSTEM_SEPARATOR 		= File.separatorChar;
	private static final char 	OTHER_SEPARATOR;
        
	static boolean isSystemWindows(){
		return (SYSTEM_SEPARATOR == '\\');
	}
        
	private static boolean isSeparator(char ch){
		return ((ch == '/') || (ch == '\\'));
	}
        
	public static String separatorsToUnix(String path){
		if ((path == null) || (path.indexOf(92) == -1))
			return path;
		return path.replace('\\', '/');
	}
        
	public static String separatorsToWindows(String path){
		if ((path == null) || (path.indexOf(47) == -1))
			return path;
		return path.replace('/', '\\');
	}
        
	public static String separatorsToSystem(String path){
		if(path == null)
			return null;
		if(isSystemWindows())
			return separatorsToWindows(path);
		return separatorsToUnix(path);
	}
	
	public static int getPrefixLength(String filename){
		if (filename == null)
			return -1;
		int len = filename.length();
		
		if (len == 0)
			return 0;
		
		char ch0 = filename.charAt(0);
		if(ch0 == ':')
			return -1;

		if (len == 1){
			if (ch0 == '~')
				return 2;
			return ((isSeparator(ch0)) ? 1 : 0);
		}

		if (ch0 == '~') {
			int posUnix = filename.indexOf(47, 1);
			int posWin = filename.indexOf(92, 1);
			if ((posUnix == -1) && (posWin == -1))
				return (len + 1);

			posUnix = (posUnix == -1) ? posWin : posUnix;
			posWin = (posWin == -1) ? posUnix : posWin;
			return (Math.min(posUnix, posWin) + 1);
		}

		char ch1 = filename.charAt(1);
		if (ch1 == ':') {
			ch0 = Character.toUpperCase(ch0);
			if ((ch0 >= 'A') && (ch0 <= 'Z')) {
				if ((len == 2) || (!(isSeparator(filename.charAt(2)))))
					return 2;
				return 3;
			}
			return -1;
		}

		if ((isSeparator(ch0)) && (isSeparator(ch1))) {
			int posUnix = filename.indexOf(47, 2);
			int posWin = filename.indexOf(92, 2);
			if (((posUnix == -1) && (posWin == -1)) || (posUnix == 2) || (posWin == 2))
				return -1;
			posUnix = (posUnix == -1) ? posWin : posUnix;
			posWin = (posWin == -1) ? posUnix : posWin;
			return (Math.min(posUnix, posWin) + 1);
		}
		return ((isSeparator(ch0)) ? 1 : 0);
	}

	public static int indexOfLastSeparator(String filename){
		if (filename == null)
			return -1;
		int lastUnixPos = filename.lastIndexOf(47);
		int lastWindowsPos = filename.lastIndexOf(92);
		return Math.max(lastUnixPos, lastWindowsPos);
	}

	public static int indexOfExtension(String filename){
		if (filename == null)
			return -1;

		int extensionPos = filename.lastIndexOf(46);
		int lastSeparator = indexOfLastSeparator(filename);
		return ((lastSeparator > extensionPos) ? -1 : extensionPos);
	}

	public static String getPrefix(String filename){
		if (filename == null)
			return null;
		int len = getPrefixLength(filename);
		if (len < 0)
			return null;

		if (len > filename.length())
			return filename + '/';

		return filename.substring(0, len);
	}

	public static String getPath(String filename){
		return doGetPath(filename, 1);
	}

	public static String getPathNoEndSeparator(String filename){
		return doGetPath(filename, 0);
	}

	private static String doGetPath(String filename, int separatorAdd){
		if (filename == null)
			return null;

		int prefix = getPrefixLength(filename);
		if (prefix < 0)
			return null;

		int index = indexOfLastSeparator(filename);
		if ((prefix >= filename.length()) || (index < 0))
			return "";

		return filename.substring(prefix, index + separatorAdd);
	}

	public static String getFullPath(String filename){
		return doGetFullPath(filename, true);
	}

	public static String getFullPathNoEndSeparator(String filename){
		return doGetFullPath(filename, false);
	}

	private static String doGetFullPath(String filename, boolean includeSeparator){
		if (filename == null)
			return null;

		int prefix = getPrefixLength(filename);
		if (prefix < 0)
			return null;

		if (prefix >= filename.length()) {
			if (includeSeparator)
				return getPrefix(filename);
			return filename;
		}

		int index = indexOfLastSeparator(filename);
		if (index < 0)
			return filename.substring(0, prefix);
		int end = index + ((includeSeparator) ? 1 : 0);
		return filename.substring(0, end);
	}

	public static String getName(String filename){
		if (filename == null)
			return null;
		int index = indexOfLastSeparator(filename);
		return filename.substring(index + 1);
	}

	public static String getBaseName(String filename){
		return removeExtension(getName(filename));
	}

	public static String getExtension(String filename){
		if (filename == null)
			return null;
		
		int index = indexOfExtension(filename);
		if (index == -1)
			return "";
		return filename.substring(index + 1);
	}

	public static String removeExtension(String filename){
		if (filename == null)
			return null;
		
		int index = indexOfExtension(filename);
		if (index == -1)
			return filename;

		return filename.substring(0, index);
	}

	public static boolean isExtension(String filename, String extension){
		if (filename == null)
			return false;

		if ((extension == null) || (extension.length() == 0))
			return (indexOfExtension(filename) == -1);

		String fileExt = getExtension(filename);
		return fileExt.equals(extension);
	}

	public static boolean isExtension(String filename, String[] extensions){
		if (filename == null)
			return false;

		if ((extensions == null) || (extensions.length == 0))
			return (indexOfExtension(filename) == -1);

		String fileExt = getExtension(filename);
		for (int i = 0; i < extensions.length; ++i)
			if (fileExt.equals(extensions[i]))
				return true;
		return false;
	}

	static String[] splitOnTokens(String text){
		if ((text.indexOf("?") == -1) && (text.indexOf("*") == -1)) {
			return new String[] { text };
		}

		char[] array = text.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < array.length; ++i)
			if ((array[i] == '?') || (array[i] == '*')) {
				if (buffer.length() != 0) {
					list.add(buffer.toString());
					buffer.setLength(0);
				}
				if (array[i] == '?')
					list.add("?");
				else if ((list.size() == 0) || ((i > 0) && (!(list.get(list.size() - 1).equals("*"))))){
					list.add("*");
				}
			} else {
				buffer.append(array[i]);
			}
		if (buffer.length() != 0) {
			list.add(buffer.toString());
		}
		return ((String[])(String[])list.toArray(new String[list.size()]));
	}

	static{
		if (isSystemWindows())	OTHER_SEPARATOR = '/';
		else	OTHER_SEPARATOR = '\\';
	}
}
