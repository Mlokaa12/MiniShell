**************(How to create a directory in Java?)**************

תיקיה נוצרת באמצעות הפקודה mkdir בטרמינל. הפקודה יוצרת תיקיה חדשה במיקום הנוכחי.

דוגמה ב-Java:
File folder = new File("NewFolder");
boolean created = folder.mkdir();
if (created) {
System.out.println("התיקיה נוצרה בהצלחה.");
} else {
System.out.println("יצירת התיקיה נכשלה.");
}
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#mkdir--
******************(How to create a file in Java?)******************

ניתן ליצור קובץ חדש באמצעות המתודה createNewFile מהמחלקה File. יש להשתמש ב־try-catch כדי לטפל בשגיאות.

דוגמה:
try {
File file = new File("example.txt");
if (file.createNewFile()) {
System.out.println("הקובץ נוצר בהצלחה.");
} else {
System.out.println("הקובץ כבר קיים.");
}
} catch (IOException e) {
e.printStackTrace();
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#createNewFile--
******************(How to check if a file or folder exists?)******************

כדי לבדוק אם קובץ או תיקיה קיימים, משתמשים במתודה exists() מתוך File.

דוגמה:
File file = new File("example.txt");
if (file.exists()) {
System.out.println("הקובץ קיים.");
} else {
System.out.println("הקובץ לא קיים.");
}
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#exists--
**************(How to get the contents of a directory?)**************

ניתן להשתמש ב־list() או listFiles() כדי להציג את תכולת התיקיה.

דוגמה:
public void listDirectory() {
File[] files = currentDirectory.listFiles();
if (files != null) {
for (int i = 0; i < files.length; i++) {
System.out.println(files[i].getName());
}
} else {
System.out.println("فشل في قراءة محتويات المجلد.");
}
}
https://docs.oracle.com/javase/8/docs/api/java/io/File.html#listFiles--

************(What is the difference between File and Path?)************

File היא מחלקה ישנה מהספריה הקלאסית של Java.
Path היא חלק מהספריה החדשה NIO ומאפשרת שליטה מתקדמת יותר.

דוגמה:
// File
File file = new File("example.txt");

// Path
Path path = Paths.get("example.txt");
System.out.println("הנתיב המוחלט: " + path.toAbsolutePath());
https://www.baeldung.com/java-file-vs-path

