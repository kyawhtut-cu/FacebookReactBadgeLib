
# FacebookReactBadgeLib

Reference from -> [Shashank02051997:FancyFacebookBadge-Android ](https://github.com/Shashank02051997/FancyFacebookBadge-Android)

Just for fun library.

How to add to your project
--------------

1. Add jitpack.io to your root build.gradle file:

     ```groovy
       allprojects {
         repositories {
           ...
           maven { url 'https://jitpack.io' }
         }
       }

2. Add library to your app build.gradle file then sync

   Release version - [![Download](https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/download.svg?sanitize=true)](https://github.com/kyawhtut-cu/FacebookReactBadgeLib/releases/)

   ```groovy
   dependencies {
      ...
      implementation 'com.github.kyawhtut-cu:FacebookReactBadgeLib:<version-release>'
   }
   ```

#Usage
--------------

ပထမဆုံး XML မှာ Component ကိုထည့်ပေးပါ။

        <com.kyawhtut.fbReact.ReactBadge
          android:id="@+id/reactBadge"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          app:enableNumberConvert="true"
          app:reactCount="1"
          app:srcReact="like"
          app:textColor="@color/colorPrimary" />

Java

       ReactBadge reactBadge = findViewById(R.id.reactBadge);
       reactBadge.setReactCount(1); // to change react count
       reactBadge.setReact(Emoji.LOVE); // to change react icon [Emoji.LIKE, Emoji.LOVE, Emoji.HAHA, Emoji.WOW, Emoji.SAD, Emoji.ANGRY]
       reactBadge.animationDuration = 500; // animation duration default is 500
       reactBadge.setAnimationEnabled(true); // animation enabled default is true
       reactBadge.setNumberConvertEnabled(true); // to show number count like as 1.2k default is true
       reactBadge.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
       reactBadge.setTextSize(24f); // to change count value size default is 16sp
       reactBadge.show(); // dynamic show
       reactBadge.clear(); // dynamic clear and close

Kotlin

       reactBadge.apply {
            reactCount = 1 // to change react count
            react = Emoji.LOVE // to change react icon [Emoji.LIKE, Emoji.LOVE, Emoji.HAHA, Emoji.WOW, Emoji.SAD, Emoji.ANGRY]
            animationDuration = 500 // animation duration default is 500
            animationEnabled = true // animation enabled default is true
            isNumberConvertEnabled = true // to show number count like as 1.2k default is true
            textColor = ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
            textSize = 24f // to change count value size default is 16sp
            show() // dynamic show
            clear() // dynamic clear and close
        }


Screenshoot
--------
  <img alt="English Unicdoe Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/like.jpg" width="300"/> <img alt="English Unicdoe" src="https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/love.jpg" width="300"/>

   <img alt="English Zawgyi Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/haha.jpg" width="300"/> <img alt="English Zawgyi" src="https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/wow.jpg" width="300"/>

   <img alt="Myanmar Unicdoe Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/sad.jpg" width="300"/> <img alt="Myanmar Unicdoe" src="https://raw.githubusercontent.com/kyawhtut-cu/FacebookReactBadgeLib/master/screenshoot/angry.jpg" width="300"/>


References
--------

Shashank02051997:FancyFacebookBadge-Android [https://github.com/Shashank02051997/FancyFacebookBadge-Android](https://github.com/Shashank02051997/FancyFacebookBadge-Android)

License
--------

    Copyright 2019 kyawhtut-cu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
