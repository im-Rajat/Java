# Section 17: Regular Expressions


A **regular expression** (or regex) is a sequence of characters that defines a search pattern. They are commonly used to find or validate specific patterns within a string.

-----

## Basic Regex with the `String` Class

Java's `String` class has built-in methods like `replaceAll()` and `matches()` that accept regular expressions.

```java
String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";

// The dot "." matches any character.
System.out.println(alphanumeric.replaceAll(".", "Y"));
// Result: YYYYYYYYYYYYYYYYYYYYYYYYY

// The caret "^" is an anchor for the start of the string.
System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
// Result: YYYF12Ghhiiiijkl99z

// The matches() method returns true only if the ENTIRE string matches the pattern.
System.out.println(alphanumeric.matches("^abcDeee"));
// Result: false

// The dollar sign "$" is an anchor for the end of the string.
System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
// Result: abcDeeeF12GhhiiiTHE END

// Square brackets "[]" create a character class.
// This replaces all occurrences of 'a', 'e', or 'i'.
System.out.println(alphanumeric.replaceAll("[aei]", "X"));
// Result: XbcDXXXF12GhhXXXXjkl99z

// Match an 'a', 'e', or 'i' that is immediately followed by an 'F' or 'j'.
System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));
// Result: abcDeeeX12Ghhiiiikl99z

// Using "^" inside a character class negates it.
// Replaces every character EXCEPT 'e' and 'j'.
System.out.println(alphanumeric.replaceAll("[^ej]", "X"));
// Result: XeeXeXXjXXXXeej

// You can specify ranges within a character class.
System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
// Result: XXXDXXXF12GhhiiiijklX9z

// Use (?i) for a case-insensitive match.
System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
// Result: XXXDXXXF12GhhiiiijklX9z
```

### Predefined Character Classes

  * `\d`: Replaces all digits (`[0-9]`).
  * `\D`: Replaces all non-digits.
  * `\s`: Replaces all whitespace characters (space, tab, newline).
  * `\S`: Replaces all non-whitespace characters.
  * `\w`: Replaces all word characters (`[a-zA-Z_0-9]`).
  * `\b`: Replaces word boundaries. Each word will be surrounded by 'X'.
    ```java
    String hasWhitespace = "I have a bunch of spaces.";
    System.out.println(hasWhitespace.replaceAll("\\b", "X"));
    // Result: XIX XhaveX XaX XbunchX XofX XspacesX.
    ```

-----

## Quantifiers

**Quantifiers** specify how many times a character, group, or character class must be present in the input for a match to be found.

  * `e{3}`: Matches exactly three `e`'s.
  * `e+`: Matches one or more `e`'s.
  * `e*`: Matches zero or more `e`'s.
  * `e{2,5}`: Matches between 2 and 5 `e`'s.

<!-- end list -->

```java
// Replaces 'h' (one or more times) followed by 'i' (zero or more times)
// followed by 'j' (one or more times).
String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
System.out.println(newAlphanumeric.replaceAll("h+i*j", "Y"));
// Result: abcDeeeF12GYkl99z
```

-----

## `Pattern` and `Matcher` Classes

For more complex regex operations, Java provides the `Pattern` and `Matcher` classes.

  * **`Pattern` Class:** Represents a compiled regular expression.
      * [Pattern Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
  * **`Matcher` Class:** An engine that interprets the pattern and performs match operations on an input string.
      * [Matcher Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html)

### Using `Matcher` Methods

```java
StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
htmlText.append("<h2>Sub-heading</h2>");
htmlText.append("<p>This is a paragraph about something.</p>");
htmlText.append("<p>This is another paragraph about something else.</p>");
htmlText.append("<h2>Summary</h2>");
htmlText.append("<p>Here is the summary.</p>");

// Create a pattern to find h2 tags
String h2Pattern = ".*<h2>.*";
Pattern pattern = Pattern.compile(h2Pattern);
Matcher matcher = pattern.matcher(htmlText);

// The matches() method checks if the entire string matches the pattern
System.out.println(matcher.matches()); // Returns false
```

### Counting Occurrences

You can use a loop with the `find()` method to count all occurrences of a pattern.

```java
// Let's find all individual <h2> tags
Pattern h2TagPattern = Pattern.compile("<h2>");
Matcher h2Matcher = h2TagPattern.matcher(htmlText);

int count = 0;
while(h2Matcher.find()) {
    count++;
}
System.out.println("Count: " + count); // Count: 2
```

### Grouping and Extracting

Parentheses `()` are used to create **capturing groups**, which let you extract specific parts of a match.

```java
// Example 1: Extracting values between curly braces
String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
Pattern pattern11 = Pattern.compile("\\{(.+?)\\}"); // (.+?) is a reluctant group
Matcher matcher11 = pattern11.matcher(challenge11);
while(matcher11.find()) {
    // group(1) refers to the first capturing group
    System.out.println("Occurrence: " + matcher11.group(1));
}
// Occurrence: 0, 2
// Occurrence: 0, 5
// Occurrence: 1, 3
// Occurrence: 2, 4

// Example 2: Matching an optional group
// The pattern matches 5 digits, optionally followed by a hyphen and 4 more digits.
String pattern13 = "^\\d{5}(-\\d{4})?$";
String challenge12 = "11111";
String challenge13 = "11111-1111";

System.out.println(challenge12.matches(pattern13)); // true
System.out.println(challenge13.matches(pattern13)); // true
```
