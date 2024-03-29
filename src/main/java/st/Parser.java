package st;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This modified class file is used for Task 3 
// DEVELOPER NOTE: Uses ASCII value of character
// Notes: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

public class Parser {
	public static final int INTEGER = 1;
	public static final int BOOLEAN = 2;
	public static final int STRING = 3;
	public static final int CHAR = 4;
	public static final int CHARLIST =5;//TDD
	
	private OptionMap optionMap;
	
	public Parser() {
		optionMap = new OptionMap();
	}
	
	public void add(String option_name, String shortcut, int value_type) {
		optionMap.store(option_name, shortcut, value_type);
	}
	
	public void add(String option_name, int value_type) {
		optionMap.store(option_name, "", value_type);
	}

	public int getInteger(String option) {
		String value = getString(option);
		int type = getType(option);
		int result;
		switch (type) {
		case INTEGER:
			try {
				result = Integer.parseInt(value);
			} catch (Exception e) {
		        try {
		            new BigInteger(value);
		        } catch (Exception e1) {
		            result = 0;
		        }
		        result = 0;
		    }
			break;
		case BOOLEAN:
			if (getBoolean(option) == false) {
				result = 0;
			} else {
				result = 1;
			}
			break;
		case STRING:
		    int power = 1;
		    result = 0;
		    char c;
		    for (int i = value.length() - 1; i >= 0; --i){
		        c = value.charAt(i);
		        if (!Character.isDigit(c)) return 0;
		        result = result + power * (c - '0');
		        power *= 10;
		    }
		    break;
		case CHAR:
			result = (int)getChar(option);
			break;
		default:
			result = 0;
		}
		return result;
	}
	
	public boolean getBoolean(String option) {
		String value = getString(option);
		boolean result;
		if (value.toLowerCase().equals("false") || value.equals("0") || value.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	
	public String getString(String option) {
		String result = optionMap.getValue(option);
		return result;
	}
	
	public char getChar(String option) {
		String value = getString(option);
		char result;
		if (value.equals("")) {
			result = '\0';
		} else {
			result = value.charAt(0);
		}
		return result;
	}
	
	// DEVELOPER NOTE: New function specified in Specification
	public List<Character> getCharacterList(String option) {
		
		// Obtain String value
		String str = getString(option);
		List<Character> list = new ArrayList<Character>();
		
		int validHyphens = 0;
					
		// Initial parsing
		for (int i = 0; i < str.toCharArray().length; i++) {
			
			Character ch = str.charAt(i);
			// If value starts with hyphen, return empty list
			if ((ch.equals('-')) && (i == 0)) {
				return new ArrayList<Character>();
			}
			// Check other indices for hyphen [VERY IMPORTANT]
			else if (ch.equals('-') && (i >= 1) && (i <= str.length() - 2)) {
				Character beforeCh = str.toLowerCase().charAt(i-1);
				Character afterCh = str.toLowerCase().charAt(i+1);
				// Check conditions for hyphen
				// Both characters / digits
				if ((Character.isLetterOrDigit(beforeCh)) && (Character.isLetterOrDigit(afterCh))) {
					
					list.remove(beforeCh);
					
					int asciiValue = beforeCh;
					int targetedAsciiValue = afterCh;
					
					if (validHyphens >= 1) {
						list.add(beforeCh);
					}
					
					// Range from ASCII values 48-57 (0-9) and 97-122 (a-z)
					while (asciiValue != targetedAsciiValue) {
						
						if (asciiValue < targetedAsciiValue) {
							list.add((char) asciiValue);
							if (asciiValue == 57) {
								asciiValue = 97;
							}
							else if (asciiValue == 122) {
								asciiValue = 48;
							}
							else {
								asciiValue++;
							}
						}

						if (targetedAsciiValue < asciiValue) {
							list.add((char) asciiValue);
							if (asciiValue == 48) {
								asciiValue = 122;
							}
							else if (asciiValue == 97) {
								asciiValue = 57;
							}
							else {
								asciiValue--;
							}
						}
						
					}
					
					validHyphens++;
					
				}
			}
			else if ((ch.equals('-') && (i == str.toCharArray().length))) {
				// Do nothing
			}
			
			else if (Character.isUpperCase(ch)) {
				list.add(Character.toLowerCase(ch));
			}
			else if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch.equals('.')) {
				list.add(ch);
			}
		}
		
		// Secondary parsing needed??
				
		return list;
	}
	
	// DEVELOPER NOTE: Also will need to modify
	public int parse(String command_line_options) {
		if (command_line_options == null) {
			return -1;
		}
		int length = command_line_options.length();
		if (length == 0) {
			return -2;
		}
		
		int char_index = 0;
		while (char_index < length) {
			char current_char = command_line_options.charAt(char_index);

			while (char_index < length) {
				current_char = command_line_options.charAt(char_index);
				if (current_char != ' ') {
					break;
				}
				char_index++;
			}
			
			boolean isShortcut = true;
			String option_name = "";
			String option_value = "";
			if (current_char == '-') {
				char_index++;
				current_char = command_line_options.charAt(char_index);
				if (current_char == '-') {
					isShortcut = false;
					char_index++;
				}
			} else {
				return -3;
			}
			current_char = command_line_options.charAt(char_index);
			
			while (char_index < length) {
				current_char = command_line_options.charAt(char_index);
				if (Character.isLetterOrDigit(current_char) || current_char == '_') {
					option_name += current_char;
					char_index++;
				} else {
					break;
				}
			}
			
			boolean hasSpace = false;
			if (current_char == ' ') {
				hasSpace = true;
				while (char_index < length) {				
					current_char = command_line_options.charAt(char_index);
					if (current_char != ' ') {
						break;
					}
					char_index++;
				}
			}

			if (current_char == '=') {
				char_index++;
				current_char = command_line_options.charAt(char_index);
			}
			if ((current_char == '-'  && hasSpace==true ) || char_index == length) {
				if (getType(option_name) == BOOLEAN) {
					option_value = "true";
					if (isShortcut) {
						optionMap.setValueWithOptioShortcut(option_name, option_value);
					} else {
						optionMap.setValueWithOptionName(option_name, option_value);
					}
				} else {
					return -3;
				}
				continue;
			} else {
				char end_symbol = ' ';
				current_char = command_line_options.charAt(char_index);
				if (current_char == '\'' || current_char == '\"') {
					end_symbol = current_char;
					char_index++;
				}
				while (char_index < length) {
					current_char = command_line_options.charAt(char_index);
					if (current_char != end_symbol) {
						option_value = option_value + current_char;
						char_index++;
					} else {
						break;
					}
				}
			}
			
			if (isShortcut) {
				optionMap.setValueWithOptioShortcut(option_name, option_value);
			} else {
				optionMap.setValueWithOptionName(option_name, option_value);
			}
			char_index++;
		}
		return 0;
	}
	
	private int getType(String option) {
		int type = optionMap.getType(option);
		return type;
	}
	
	@Override
	public String toString() {
		return optionMap.toString();
	}

}
