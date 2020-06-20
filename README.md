
# flutterappziloofferwall  
  
Non-official flutter plugin for Appzilo Offer Wall  
Fell free to help :)  
## Getting Started  
Initialize the Appzilo plugin with an App key and an User ID.  
  
```dart  
AppziloOfferwall().init(appKey: 'yourappkey', userId: 'youruserid');  
```  
## Show Panel  
  
```dart  
AppziloOfferwall().show();  
```  
  
## Possible Errors  
You may face some errors during build phase. 
Here's how to solve it:
If it shows the following error:
```
attribute android:foregroundServiceType not found
```
You'll have to set the compileSdkVersion to 29.
Go to *android/app/build.gradle* into your app and set *compileSdkVersion 29* also set *minSdkVersion 17*

There might be an error related to
```
Could not find PersistentCookieJar.jar
```
To solve it, add on *android/build.gradle* the following code
```
buildscript {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
	...
}
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```