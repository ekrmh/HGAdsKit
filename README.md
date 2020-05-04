# HGAdsKit
[ ![Download](https://api.bintray.com/packages/ekrmh/HGAdsKit/com.github.ekrmh/images/download.svg?version=1.1) ](https://bintray.com/ekrmh/HGAdsKit/com.github.ekrmh/1.1/link)

**HGAdsKit** includes Google Ads(Firebase) and Huawei Ads capabilities. Google Ads doesn't avaliable on nonGMS devices. This situation affected most developers who want to publish their apps on Huawei App Gallery.  

### Goal
Google and Huawei ads can show to users in the app using  the HGAdsKit. You will have completed both integrations using only HGAdsKit.



|Type|HMS|GMS|
|-|:-:|:-:|
|Banner|:heavy_check_mark:|:heavy_check_mark:|
|Interstitial|:heavy_check_mark:|:heavy_check_mark:|
|Rewarded|:heavy_check_mark:|:heavy_check_mark:|
|Splash|:hourglass:|:x:|
|Native|:hourglass:|:hourglass:|

## Getting Started
Integrate HMS and GMS before adding the library to your project. Otherwise HGAdsKit won't work.

[GMS Integration Guide](https://developers.google.com/admob/android/quick-start)
[HMS Integration Guide](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/agc-get-started "HMS Integration Guide")
### Including in your project
   
Gradle:
```groovy
implementation 'com.github.ekrmh:hgadskit:1.0'
```
Maven:
```xml
<dependency>
  <groupId>com.github.ekrmh</groupId>
  <artifactId>hgadskit</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```
### Usage

Test Ids

|Type| Banner | Intersitital | Intersititital Video | Rewarded |
|--|:-:|:-:|:-:|:-:|
| Huawei | testw6vs28auh3 | teste9ih9j0rc3 | testb4znbuh3n2 |  testx9dtjwj8hp| 
| Google | ca-app-pub-3940256099942544/6300978111 | ca-app-pub-3940256099942544/1033173712 | ca-app-pub-3940256099942544/8691691433 | ca-app-pub-3940256099942544/5224354917 |
#### Service Type

Get currently running service ( HUAWEI or GOOGLE)
```kotlin
val type = AdsCreator.getServiceType(this)
```


#### Banner

Add **HGBannerView** to the XML layout file
```xml
<com.ekrmh.hgadskit.ads.banner.HGBannerView  
  android:id="@+id/bannerAd"  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content" />
```

Configure banner ad ids and size

```kotlin
bannerAd.initializeAd(  
  HUAWEI_AD_ID,  
  GOOGLE_AD_ID,  
  BannerSize.BANNER_SIZE_SMART
)  
```
Load Ad
```kotlin
bannerAd.loadAd()
```
#### Interstitial

Configure
```kotlin
val interstitialAd = HGInterstitialAd(this)  
  
interstitialAd.initializeAd(  
  HUAWEI_AD_ID,  
  GOOGLE_AD_ID,  
)
```
Set AdListener (Optional)
```kotlin
interstitialAd.setAdListener(object: InterstitialListener {  
    override fun onAdFailed(errorCode: Int) {   }  
  
    override fun onAdClosed() {  }  
  
    override fun onAdClicked() {  }  
  
    override fun onAdLeave() {  }  
  
    override fun onAdOpened() {  }  
  
    override fun onAdImpression() {  }  
  
    override fun onAdLoaded() {  
        // Ad loaded 
        // You can show ad
    }  
})
```
Show
```kotlin
interstitialAd.showAd()  
```
  



#### Rewarded
Configure
```kotlin
val rewardedAd = HGRewardedAd(this)  
rewardedAd.initializeAd(  
  HUAWEI_AD_ID,  
  GOOGLE_AD_ID,
)
```
Load
```kotlin
rewardedAd.loadAd({  
  // Load Success
  // You can show ad
}, {  
  // Load Failure
})
```
Show Ad with Listener(Optional)
```kotlin
rewardedAd.showAd(object: RewardedListener {  
        override fun onRewardAdClosed() {  }  
        override fun onRewardAdOpened() {  }  
        override fun onRewarded(reward: Reward?) {  
	        // Reward success
	        val name = reward?.name
	        val amount = reward?.amount
        }  
        override fun onRewardAdFailedToShow(e: Int) {  }  
    })  
```

## Licence
```
Copyright 2020 Ekrem Hatipoglu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
