package com.yis.lms.utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeSet;

public abstract class StringUtils {
    private static final String FOLDER_SEPARATOR = "/";
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
    private static final String TOP_PATH = "..";
    private static final String CURRENT_PATH = ".";
    private static final char EXTENSION_SEPARATOR = '.';

    public StringUtils() {
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean hasLength(CharSequence str) {
        return str != null && str.length() > 0;
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence)str);
    }

    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        } else {
            int strLen = str.length();

            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean hasText(String str) {
        return hasText((CharSequence)str);
    }

    public static boolean containsWhitespace(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        } else {
            int strLen = str.length();

            for(int i = 0; i < strLen; ++i) {
                if (Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence)str);
    }

    public static String trimWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder(str);

            while(sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
                sb.deleteCharAt(0);
            }

            while(sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }
    }

    public static String trimAllWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        } else {
            int len = str.length();
            StringBuilder sb = new StringBuilder(str.length());

            for(int i = 0; i < len; ++i) {
                char c = str.charAt(i);
                if (!Character.isWhitespace(c)) {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    public static String trimLeadingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder(str);

            while(sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
                sb.deleteCharAt(0);
            }

            return sb.toString();
        }
    }

    public static String trimTrailingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder(str);

            while(sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }
    }

    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (!hasLength(str)) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder(str);

            while(sb.length() > 0 && sb.charAt(0) == leadingCharacter) {
                sb.deleteCharAt(0);
            }

            return sb.toString();
        }
    }

    public static String trimTrailingCharacter(String str, char trailingCharacter) {
        if (!hasLength(str)) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder(str);

            while(sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingCharacter) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }
    }

    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str != null && prefix != null) {
            if (str.startsWith(prefix)) {
                return true;
            } else if (str.length() < prefix.length()) {
                return false;
            } else {
                String lcStr = str.substring(0, prefix.length()).toLowerCase();
                String lcPrefix = prefix.toLowerCase();
                return lcStr.equals(lcPrefix);
            }
        } else {
            return false;
        }
    }

    public static boolean endsWithIgnoreCase(String str, String suffix) {
        if (str != null && suffix != null) {
            if (str.endsWith(suffix)) {
                return true;
            } else if (str.length() < suffix.length()) {
                return false;
            } else {
                String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
                String lcSuffix = suffix.toLowerCase();
                return lcStr.equals(lcSuffix);
            }
        } else {
            return false;
        }
    }

    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        for(int j = 0; j < substring.length(); ++j) {
            int i = index + j;
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static int countOccurrencesOf(String str, String sub) {
        if (str != null && sub != null && str.length() != 0 && sub.length() != 0) {
            int count = 0;

            int idx;
            for(int pos = 0; (idx = str.indexOf(sub, pos)) != -1; pos = idx + sub.length()) {
                ++count;
            }

            return count;
        } else {
            return 0;
        }
    }

    public static String replace(String inString, String oldPattern, String newPattern) {
        if (hasLength(inString) && hasLength(oldPattern) && newPattern != null) {
            StringBuilder sb = new StringBuilder();
            int pos = 0;
            int index = inString.indexOf(oldPattern);

            for(int patLen = oldPattern.length(); index >= 0; index = inString.indexOf(oldPattern, pos)) {
                sb.append(inString.substring(pos, index));
                sb.append(newPattern);
                pos = index + patLen;
            }

            sb.append(inString.substring(pos));
            return sb.toString();
        } else {
            return inString;
        }
    }

    public static String delete(String inString, String pattern) {
        return replace(inString, pattern, "");
    }

    public static String deleteAny(String inString, String charsToDelete) {
        if (hasLength(inString) && hasLength(charsToDelete)) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < inString.length(); ++i) {
                char c = inString.charAt(i);
                if (charsToDelete.indexOf(c) == -1) {
                    sb.append(c);
                }
            }

            return sb.toString();
        } else {
            return inString;
        }
    }

    public static String quote(String str) {
        return str != null ? "'" + str + "'" : null;
    }

    public static Object quoteIfString(Object obj) {
        return obj instanceof String ? quote((String)obj) : obj;
    }

    public static String unqualify(String qualifiedName) {
        return unqualify(qualifiedName, '.');
    }

    public static String unqualify(String qualifiedName, char separator) {
        return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    private static String changeFirstCharacterCase(String str, boolean capitalize) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder(str.length());
            if (capitalize) {
                sb.append(Character.toUpperCase(str.charAt(0)));
            } else {
                sb.append(Character.toLowerCase(str.charAt(0)));
            }

            sb.append(str.substring(1));
            return sb.toString();
        } else {
            return str;
        }
    }

    public static String getFilename(String path) {
        if (path == null) {
            return null;
        } else {
            int separatorIndex = path.lastIndexOf("/");
            return separatorIndex != -1 ? path.substring(separatorIndex + 1) : path;
        }
    }

    public static String getFilenameExtension(String path) {
        if (path == null) {
            return null;
        } else {
            int extIndex = path.lastIndexOf(46);
            if (extIndex == -1) {
                return null;
            } else {
                int folderIndex = path.lastIndexOf("/");
                return folderIndex > extIndex ? null : path.substring(extIndex + 1);
            }
        }
    }

    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        } else {
            int extIndex = path.lastIndexOf(46);
            if (extIndex == -1) {
                return path;
            } else {
                int folderIndex = path.lastIndexOf("/");
                return folderIndex > extIndex ? path : path.substring(0, extIndex);
            }
        }
    }

    public static String applyRelativePath(String path, String relativePath) {
        int separatorIndex = path.lastIndexOf("/");
        if (separatorIndex != -1) {
            String newPath = path.substring(0, separatorIndex);
            if (!relativePath.startsWith("/")) {
                newPath = newPath + "/";
            }

            return newPath + relativePath;
        } else {
            return relativePath;
        }
    }

    public static Locale parseLocaleString(String localeString) {
        String[] parts = tokenizeToStringArray(localeString, "_ ", false, false);
        String language = parts.length > 0 ? parts[0] : "";
        String country = parts.length > 1 ? parts[1] : "";
        validateLocalePart(language);
        validateLocalePart(country);
        String variant = "";
        if (parts.length > 2) {
            int endIndexOfCountryCode = localeString.indexOf(country, language.length()) + country.length();
            variant = trimLeadingWhitespace(localeString.substring(endIndexOfCountryCode));
            if (variant.startsWith("_")) {
                variant = trimLeadingCharacter(variant, '_');
            }
        }

        return language.length() > 0 ? new Locale(language, country, variant) : null;
    }

    private static void validateLocalePart(String localePart) {
        for(int i = 0; i < localePart.length(); ++i) {
            char ch = localePart.charAt(i);
            if (ch != '_' && ch != ' ' && !Character.isLetterOrDigit(ch)) {
                throw new IllegalArgumentException("Locale part \"" + localePart + "\" contains invalid characters");
            }
        }

    }

    public static String toLanguageTag(Locale locale) {
        return locale.getLanguage() + (hasText(locale.getCountry()) ? "-" + locale.getCountry() : "");
    }

    public static TimeZone parseTimeZoneString(String timeZoneString) {
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneString);
        if ("GMT".equals(timeZone.getID()) && !timeZoneString.startsWith("GMT")) {
            throw new IllegalArgumentException("Invalid time zone specification '" + timeZoneString + "'");
        } else {
            return timeZone;
        }
    }



    public static String[] toStringArray(Collection<String> collection) {
        return collection == null ? null : (String[])collection.toArray(new String[collection.size()]);
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        } else {
            List<String> list = Collections.list(enumeration);
            return (String[])list.toArray(new String[list.size()]);
        }
    }


    public static String[] split(String toSplit, String delimiter) {
        if (hasLength(toSplit) && hasLength(delimiter)) {
            int offset = toSplit.indexOf(delimiter);
            if (offset < 0) {
                return null;
            } else {
                String beforeDelimiter = toSplit.substring(0, offset);
                String afterDelimiter = toSplit.substring(offset + delimiter.length());
                return new String[]{beforeDelimiter, afterDelimiter};
            }
        } else {
            return null;
        }
    }



    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {
        if (str == null) {
            return null;
        } else {
            StringTokenizer st = new StringTokenizer(str, delimiters);
            ArrayList tokens = new ArrayList();

            while(true) {
                String token;
                do {
                    if (!st.hasMoreTokens()) {
                        return toStringArray((Collection)tokens);
                    }

                    token = st.nextToken();
                    if (trimTokens) {
                        token = token.trim();
                    }
                } while(ignoreEmptyTokens && token.length() <= 0);

                tokens.add(token);
            }
        }
    }

    public static String[] delimitedListToStringArray(String str, String delimiter) {
        return delimitedListToStringArray(str, delimiter, (String)null);
    }

    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        if (str == null) {
            return new String[0];
        } else if (delimiter == null) {
            return new String[]{str};
        } else {
            List<String> result = new ArrayList();
            int pos;
            if ("".equals(delimiter)) {
                for(pos = 0; pos < str.length(); ++pos) {
                    result.add(deleteAny(str.substring(pos, pos + 1), charsToDelete));
                }
            } else {
                int delPos;
                for(pos = 0; (delPos = str.indexOf(delimiter, pos)) != -1; pos = delPos + delimiter.length()) {
                    result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                }

                if (str.length() > 0 && pos <= str.length()) {
                    result.add(deleteAny(str.substring(pos), charsToDelete));
                }
            }

            return toStringArray((Collection)result);
        }
    }

    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, ",");
    }

    public static Set<String> commaDelimitedListToSet(String str) {
        Set<String> set = new TreeSet();
        String[] tokens = commaDelimitedListToStringArray(str);
        String[] var3 = tokens;
        int var4 = tokens.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String token = var3[var5];
            set.add(token);
        }

        return set;
    }


}
