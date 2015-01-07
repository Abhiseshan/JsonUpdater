App update checker via Json
===========================

Files Required
1. AsyncTaskParseJson.java
2. JsonParser.java
3. MainActivity.java
4. version_control.json

Steps to use
1. Place the AsyncTaskParseJson.java and JsonParser.java into your Android App library.
2. Add the code from the MainActivity.java to the java file you want to use updater with.
3. Upload the version_control.json onto your webaddress.
4. Change the webaddress in the AsyncTaskParseJson.java to the one you uploaded the file in.
5. Add the toasts, imageViews, etc for notifiying the user.
6. Profit.

Please note:
      If you do not want your App to crash, please make sure you handle when the app is offline, since calling the Json Activity       without an active internet connection force closes the app.

This can be used to do any operation to notify the user from the server.

Screenshots
============
![Screenshot1](Abhiseshan.github.com/JsonUpdater/Screenshots/scr1.png)
![Screenshot2](Abhiseshan.github.com/JsonUpdater/Screenshots/scr2.png)

Issues
=======
None till now. Please tell me if there are any. 
