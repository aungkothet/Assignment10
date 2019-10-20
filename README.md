# Assignment10
Assignment from PADC Adnroid Course.

Focused on 
<ul>
<li>Used AdnroidX</li>
<li>MVP (Modal, view, presenter)</li>
<li>LiveData with Room Database</li>
<li>RecyclerView viewType</li>
<li>YouTube Video player</li>
<li>TMDB ( the movie db) api calls</li>
<li>Coil-kt Image loading library</li>
<li>Used WorkManager (Both OneTime and Periodically (every 30 minutes)) to load new data from network</li>
<li>Used BuildConfig to hide the tmdb api key</li>
</ul>

## Release APK

Download apk [here](https://bit.ly/35EiY6h)

## Bugs ( Need To Fix )

`` 
At search page, first 2 search work well, after that it overwrite with the old data ( I guess it because of LiveData from db )
``
## Dependencies 
```java

    apply plugin: 'kotlin-kapt'

    android{
        ....
        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }

        tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    dependencies {
        .......

        //material components
        implementation 'com.google.android.material:material:1.0.0'

        //Gson
        implementation 'com.google.code.gson:gson:2.8.5'

        //coil-kt
        implementation("io.coil-kt:coil:0.7.0")

        //retrofit
        implementation 'com.squareup.retrofit2:retrofit:2.6.1'
        implementation 'com.squareup.retrofit2:converter-gson:2.5.0'

        //ROOM Library
        implementation "android.arch.persistence.room:runtime:1.1.1"
        implementation 'androidx.legacy:legacy-support-v4:1.0.0'
        kapt "android.arch.persistence.room:compiler:1.1.1"

        //live data
        implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'

        //youtube player
        implementation 'com.pierfrancescosoffritti.androidyoutubeplayer:core:10.0.4'

        //work manager
        implementation "androidx.work:work-runtime:2.2.0"

        ........
    }


```
## Reference Image

![Reference](https://github.com/aungkothet/bookstore/blob/master/assignment10-ref-1.png)
![Reference](https://github.com/aungkothet/bookstore/blob/master/assignment10-ref-2.png)
![Reference](https://github.com/aungkothet/bookstore/blob/master/assignment10-ref-3.png)

## Screenshots 

![Screenshot](https://github.com/aungkothet/bookstore/blob/master/assignment10-ss1.png)
![Screenshot](https://github.com/aungkothet/bookstore/blob/master/assignment10-ss2.png)
![Screenshot](https://github.com/aungkothet/bookstore/blob/master/assignment10-ss3.png)
![Screenshot](https://github.com/aungkothet/bookstore/blob/master/assignment10-ss4.png)
![Screenshot](https://github.com/aungkothet/bookstore/blob/master/assignment10-ss5.png)





