# SeleniumDemo
Demo project in JAVA using Selenium WebDriver. The application logs into the **GMail** account specified by the user.

## Run the application
1. Open a command prompt/terminal.
2. Navigate to the directory where the executable application jar is present.
3. Verify that the **chromedriver.exe** and the **credentialsDataFile.txt** are present in the same directory.
4. Run the following command:

```
$ java -jar <executable jar name>.jar
```
5. The application would login all the users into separate **incognito** windows on the **Chrome** browser.
  
### Prerequisites
1. Verify that the **chromedriver.exe** and the **credentialsDataFile.txt** are present in the same directory as the executable jar. The application would not run if these files are missing.
2. Use the proper executable for the **chromedriver**. **chromedriver.exe** would only work on Windows. For **Linux/Mac** use the appropriate executable. Acquire the same from [ChromeDriver Downloads Page](http://chromedriver.chromium.org/downloads).
3. Change the **chromedriver** executable name in code in class com.seleniumdemo.handlers.WorkFlowController.java
4. Verify that the **credentialsDataFile.txt** contains usersnames/emails and password separated by a single space, of the users who intend to login to the **GMail** account. The list of the usernames must be separated with a new line as demonstrated below:

```
user1@gmail.com passworduser1
user2@gmail.com passworduser2
user3@gmail.com passworduser3
```

## Authors and contributors
**Anant Chaturvedi** - *Java development*
