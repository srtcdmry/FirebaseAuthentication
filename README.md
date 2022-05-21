# FirebaseAuthentication

Bu projede Android Retrofit, gson kütüphaneleri kullanılarak çekilen Coinlere ait bilgiler alınmıştır. 
Giriş yöntemi olarak Google Firebase entegre edilerek; hem email ve şifre üzerinden, hemde Google Authentication, Facebook Authentication kullanılarak giriş yapılabilmektedir. 
Şifremi unuttum, Login, Sign Up, Coin listeleme ekranları mecvuttur.

# Kullanılan Kütüphaneler

Retrofit

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'    
    implementation 'com.squareup.retrofit2:adapter-rxjava:2.4.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.google.code.gson:gson:2.8.6'
    
Firebase - Firebase Authentication

    implementation platform('com.google.firebase:firebase-bom:30.0.1')
    implementation 'com.google.firebase:firebase-analytics'
    implementation 'com.google.firebase:firebase-auth'
    implementation 'com.google.android.gms:play-services-auth:20.2.0'
    
Facebook Authentication

    implementation 'com.facebook.android:facebook-android-sdk:latest.release'
		
# Login, Forgot Password, Sign Up, Authentication Ekranları

![Screenshot_20220521-142344_Firebase Authentication](https://user-images.githubusercontent.com/74022745/169649737-48fb9026-f591-48f8-a380-14952e1f32b2.jpg)
![Screenshot_20220521-142427_Firebase Authentication](https://user-images.githubusercontent.com/74022745/169649759-ab809563-b241-42b8-955a-6ef02c64bbb3.jpg)
![Screenshot_20220521-142926_Firebase Authentication](https://user-images.githubusercontent.com/74022745/169649763-ea36c2eb-4cdc-4f24-abb3-7d0800221979.jpg)
![Screenshot_20220521-142445_Samsung Internet](https://user-images.githubusercontent.com/74022745/169649765-44ca9a65-f498-4d38-8cbb-4b49adef6246.jpg)

# Coin List Ekranı 

![Screenshot_20220521-220645_Firebase_Authentication 1 jpg](https://user-images.githubusercontent.com/74022745/169665993-a849c54e-b755-4780-990e-faef0ad83805.png)

