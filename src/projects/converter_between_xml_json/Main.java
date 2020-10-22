package projects.converter_between_xml_json;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final String fileName;
    private String inputString;

    public Main(String theInputString) {
        this.fileName = theInputString;
        readFile();
    }

    public static void main(String[] args) {

//        String theFileName = "test.txt";
        String theFileName = "test2.txt";
//        String theFileName = "testXml.txt";
        Main obj = new Main(theFileName);
        if (obj.inputString.length() > 0) {
            System.out.println(obj.converter());
        }
    }

    private void readFile() {
        File theFile = new File(this.fileName);

        StringBuilder readStringFromFile = new StringBuilder();
        try {
            Scanner scanner = new Scanner(theFile);
            while (scanner.hasNext()) {
                readStringFromFile.append(scanner.nextLine());
            }
            scanner.close();
            inputString = readStringFromFile.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File " + theFile.getAbsolutePath() + " not found");
        }


    }

    private String converter() {
        String result = inputString.trim();
        char firstChar = result.charAt(0);
        if (firstChar == '<') { // xml -> json
            Converter converter = new ConverterXMLtoJSON(result, null);
            result = converter.convert();
        } else if (firstChar == '{') { //json -> xml
            Converter converter = new ConverterJSONtoXML(result, null);
            result = converter.convert();
        } else {
            result = "unrecognised format";
        }
        return result;
    }
}

interface Converter {
    String convert();
}

class ConverterXMLtoJSON implements Converter {
    private final String inputString;
    private final List<String> parentTagsNames; //list parents tags
    private String wholeTag;
    private String tagName;
    private String tagValue;
    private final Map<String, String> attributesList;// attributes map  attribute1="value1" |  …  | attributeN="valueN"
    private String globalJSON;


    public ConverterXMLtoJSON(String theInputString, List<String> theParentTagsNames) {
        this.inputString = theInputString;
        if (theParentTagsNames == null) {
            theParentTagsNames = new LinkedList<>();
        }
        this.parentTagsNames = theParentTagsNames;
        attributesList = new LinkedHashMap<>();
        tagValue = null;
        globalJSON = "";
    }

    @Override
    public String convert() {

        wholeTag = getWholeTag(inputString);
        tagName = getTagName(wholeTag);
        getAttributes(wholeTag);

        if (!isTagEmpty(wholeTag)) {
            tagValue = getTagValue();
            if (hasChild()) { // tagsValue has inner tags
                String childTags = tagValue;
                tagValue = "hasChild";

                //              result = createJSON();
                globalJSON += createJSONForTest();

                while (childTags.length() > 0) {
                    childTags = parseNextTag(childTags);
                }
            } else {
//              result = createJSON();
                globalJSON += createJSONForTest();
            }
        } else {
//          result = createJSON();
            globalJSON += createJSONForTest();

        }

        return globalJSON;
    }


    private String getWholeTag(String val) {
        String result = "";
        Pattern patternWholeTag = Pattern.compile("<[\\w\\s=\"]+/?>");
        Matcher matcherWholeTag = patternWholeTag.matcher(val);
        if (matcherWholeTag.find()) {
            result = matcherWholeTag.group();
        }
        return result;
    }

    private String getTagName(String val) {
        String result = "";
        Pattern tagNamePattern = Pattern.compile("\\w+");
        Matcher matcherWholeTag = tagNamePattern.matcher(val);
        if (matcherWholeTag.find()) {
            result = matcherWholeTag.group();
        }
        return result;
    }

    private void getAttributes(String val) {
        Pattern pattern = Pattern.compile("\\w*\\s*=\\s*\"\\w+\"");
        Matcher matcher = pattern.matcher(val);
        String[] pairArr;
        while (matcher.find()) {
            String pairStr = matcher.group();
            pairArr = pairStr.split("=");
            attributesList.put(pairArr[0].trim(), pairArr[1].replace("\"", "").trim());
        }
    }

  /*  private String createJSON() {
        String result = "";

        result = "{\"" + tagName + "\" : ";
        if (attributesList.size() > 0) {
            result += "{ ";
            int i = 0;
            for (Map.Entry<String, String> entry : attributesList.entrySet()) {
                result += "\"@" + entry.getKey().trim() + "\" : \"" + entry.getValue().trim() + "\", ";
            }
            result += "\"#" + tagName + "\" : " + (tagValue == null ? "null" : "\"" + tagValue + "\"") + "}";
        } else {
            result += tagValue == null ? "null" : "\"" + tagValue + "\"";
        }
        result += "} ";

        return result;
    }*/

    private String createJSONForTest() {
        StringBuilder result = new StringBuilder();
        result.append("Element:\n");

        result.append("path = ");
        for (String parentTag : parentTagsNames) {
            result.append(parentTag).append(", ");
        }
        result.append(tagName).append("\n");

        if (!"hasChild".equals(tagValue)) {
            result.append("value = ").append(tagValue == null ? "null" : "\"" + tagValue + "\"").append("\n");
        }

        if (attributesList.size() > 0) {
            result.append("attributes:\n");
            attributesList.forEach((key, value) -> result.append(key).append(" = ")
                    .append(value == null ? "null" : "\"" + value + "\"")
                    .append("\n"));
        }

        result.append("\n");

        return result.toString();
    }

    private String getTagValue() {
        return inputString.replace("</" + tagName + ">", "")
                .replace(wholeTag, "").trim();
    }

    private boolean hasChild() {
        return tagValue.startsWith("<");
    }

    private String parseNextTag(String childTags) {
        ConverterXMLtoJSON nextTag;

        List<String> parentList = new LinkedList<>(this.parentTagsNames);
        parentList.add(tagName);

        String wholeBeginTag = getWholeTag(childTags);
        if (isTagEmpty(wholeBeginTag)) { // tag without value
            nextTag = new ConverterXMLtoJSON(wholeBeginTag, parentList);
            globalJSON += nextTag.convert();
            return childTags.substring(wholeBeginTag.length()).trim();
        } else { // tag with value
            String wholeEndTag = "</" + getTagName(wholeBeginTag) + ">";
            String wholeTag = childTags.substring(0, childTags.indexOf(wholeEndTag) + wholeEndTag.length());
            nextTag = new ConverterXMLtoJSON(wholeTag, parentList);
            globalJSON += nextTag.convert();
            return childTags.substring(wholeTag.length()).trim();
        }
    }

    private Boolean isTagEmpty(String val) {
        return val.contains("/");
    }


}

class ConverterJSONtoXML implements Converter {
    private String inputString;
    private final List<String> parentTagsNames; //list parents tags
    private String tagName;
//    private final String tagValue;
    private final Map<String, String> descriptionList;
    private String globalXML;

    public ConverterJSONtoXML(String theInputString, List<String> theParentTagsNames) {
        this.inputString = removeFirstAndLastBraces(theInputString);
        this.inputString = this.inputString.replace(" ", "");

        if (theParentTagsNames == null) {
            theParentTagsNames = new LinkedList<>();
        }
        this.parentTagsNames = theParentTagsNames;
        this.descriptionList = new LinkedHashMap<>();
//        tagValue = null;
        this.globalXML = "";
    }

    private String removeFirstAndLastBraces(String inputString) {
        if (inputString.startsWith("{")) {
            return inputString.substring(1, inputString.length() - 1);
        } else {
            return inputString;
        }
    }

    @Override
    public String convert() {
        String currInputString = this.inputString;

        while (currInputString.length() > 0) {
//            System.out.println("INPUT: " + currInputString);
            tagName = getJSONTagName(currInputString);

//            System.out.println("tagName= " + tagName);
            int beginIndexDescription = getBeginIndexOfInnerTag(currInputString);
            if (beginIndexDescription == -1) {  // don`t has description

                int endPosision = getEndPositionJSONTagEmpty(currInputString);
                if (endPosision != -1) {
                    descriptionList.put("#" + tagName, null);
//                    System.out.println(currInputString.substring(0, endPosision));
                    currInputString = currInputString.substring(endPosision);
                    globalXML += createJSONForTest();
                    descriptionList.clear();
                } else {
                    endPosision = getEndPosisionJSONTagValueWithOutDescription(currInputString);
                    if (endPosision != -1) {
//                        System.out.println(currInputString.substring(0, endPosision));
                        currInputString = currInputString.substring(endPosision);
                        globalXML += createJSONForTest();
                        descriptionList.clear();
                    }
                }
            } else { // has description
                int endIndex = getEndIndex(currInputString);
//                System.out.println("beginIndexDescription = "+ beginIndexDescription);
//                System.out.println("fillDescriptionTags: " + currInputString.substring(beginIndexDescription, endIndex));

                fillDescriptionTags(currInputString.substring(beginIndexDescription, endIndex));


                currInputString = currInputString.substring(endIndex + 1);
            }
        }
//        System.out.println("---------------------------------------------------");
//        descriptionList.forEach((key, val)-> System.out.println(key+" : "+val) );
//        return createXML();
        return globalXML;
    }

    private int getEndIndex(String currInputString) {
        Character curChar;
        boolean valueFlag = false; // if enter in value flag = true

        int fromIndex = currInputString.indexOf('{');

        int counterOfBraches = 0;

        for (int i = fromIndex; i < currInputString.length(); i++) {
            curChar = currInputString.charAt(i);
            if (curChar.equals('"')) {
                valueFlag = !valueFlag;
            } else if (curChar.equals('{') && !valueFlag) {
                counterOfBraches++;
            } else if (curChar.equals('}') && !valueFlag) {
                counterOfBraches--;
            }
            if (counterOfBraches == 0) {
                return i;
            }
        }
        return 0;
    }

    private void fillDescriptionTags(String currString) {

        Pattern patternPair = Pattern.compile("\"[a-zA-Z0-9@#]+\":(\"[a-zA-Z0-9@#]*\"|null)");
        Matcher matcherPair = patternPair.matcher(currString);
        Pattern patternVal = Pattern.compile("(\"[a-zA-Z0-9@#]*\"|null)");
        Matcher matcherVal;
        String key;
        String val;
        int innerBegin = currString.indexOf('{');
        int currStringLen = currString.length();

        while (matcherPair.find()) {
            if (matcherPair.start() < (innerBegin != -1 ? innerBegin : currStringLen)) {
                matcherVal = patternVal.matcher(matcherPair.group());
                if (matcherVal.find()) {
                    key = matcherVal.group().replace("\"", "");
                    if (matcherVal.find()) {
                        val = matcherVal.group().replace("\"", "");
                        descriptionList.put(key, val);

                        currString = currString.replace(matcherPair.group(), "");
                    }
                }
            } else {
                break;
            }
        }
        //remove first ","
        while (currString.startsWith(",")) {
            currString = currString.substring(1);
        }
        globalXML += createJSONForTest();
        descriptionList.clear();

        List<String> listForChildren = new LinkedList<>(parentTagsNames);
        listForChildren.add(tagName);
        currString = peelWrapper(currString);

        globalXML += new ConverterJSONtoXML(currString, listForChildren).convert();
        descriptionList.clear();
    }

    private String peelWrapper(String currString) {
        String result = currString;
        int beginIndex = result.indexOf("{");
        int endIndex = result.lastIndexOf("}");
        if (beginIndex != -1) {
            result = result.substring(beginIndex + 1, endIndex);
            return result;
        } else {
            return currString;
        }
    }

    private int getBeginIndexOfInnerTag(String currString) {
        int isIndex = currString.indexOf("\"" + tagName + "\":{");
        if (isIndex != -1) {
            return isIndex + ("\"" + tagName + "\":{").length();
        } else {
            return isIndex;
        }
    }


    private String getJSONTagName(String currString) {
        int beginIndex = currString.indexOf("\"");
        int endIndex = currString.indexOf("\"", beginIndex + 1);
        return currString.substring(beginIndex + 1, endIndex);
    }

    private int getEndPositionJSONTagEmpty(String currString) {
        int beginIndex = currString.indexOf("\"" + tagName + "\":null");
        if (beginIndex == -1)
            return -1;
        else
            return beginIndex + ("\"" + tagName + "\":null").length();
    }

    private int getEndPosisionJSONTagValueWithOutDescription(String currString) {
        Pattern patternPair = Pattern.compile(",?\"" + tagName + "\":\"[a-zA-Z0-9]*\"");
        Matcher matcherPair = patternPair.matcher(currString);
        Pattern patternVal = Pattern.compile("\"[a-zA-Z0-9@#]*\"");

        if (matcherPair.matches()) {
            String substring;
            substring = matcherPair.group();
            Matcher matcherVal = patternVal.matcher(substring);
            if (matcherVal.find()) {  //find key
                if (matcherVal.find()) { //find value
                    String tagValue = matcherVal.group()
                            .replace("\"", "");
                    descriptionList.put("#" + tagName, tagValue);
                    return matcherVal.end(0);
                }
            }


        }
        return -1;
    }

  /*  private String createXML() {
        String tagValue = descriptionList.get("#" + tagName);
        StringBuilder result = new StringBuilder("<" + tagName);

        // add descriptions
        for (Map.Entry<String, String> entry : descriptionList.entrySet()) {
            if (entry.getKey().charAt(0) == '@') {
                result.append(" ").append(entry.getKey().substring(1)).append(" = \"").append(entry.getValue()).append("\"");
            }
        }

        if (tagValue.isEmpty() || "null".equals(tagValue)) {
            result.append("/>");
        } else {
            result.append(">").append(tagValue).append("</").append(tagName).append(">");
        }
        return result.toString();
    }*/

    private String createJSONForTest() {
        StringBuilder result = new StringBuilder();
        result.append("Element:\n");

        result.append("path = ");
        for (String parentTag : parentTagsNames) {
            result.append(parentTag).append(", ");
        }
        result.append(tagName).append("\n");

        if (descriptionList.containsKey("#" + tagName)) {
            result.append("value = ").append(descriptionList.get("#" + tagName).equals("null") ? "null" : "\"" + descriptionList.get("#" + tagName) + "\"").append("\n");
        }

//        if (descriptionList.size() > 0) {
//        if (descriptionList.keySet().stream().filter(c -> c.startsWith("@")).count() > 0) {
        if (descriptionList.keySet().stream().anyMatch(c -> c.startsWith("@"))) {
            result.append("attributes:\n");
            descriptionList.forEach((key, value) -> {
                if (key.startsWith("@")) {
                    result.append(key.substring(1)).append(" = ")
                            .append(value.equals("null") ? "\"\"" : "\"" + value + "\"")
                            .append("\n");
                }
            });
        }

        result.append("\n");

        return result.toString();
    }

}
