# Build-it-Bigger
[![GitHub license](https://img.shields.io/crates/l/rustc-serialize.svg)](https://github.com/GaganGupta19/Build-it-Bigger/blob/master/license.)

<img width = "70%" src = "https://lh3.googleusercontent.com/cJQtO_A08shKWZ1NEJxpvdYcfXxoHH87HYldIx_gOoGcoqnnZDTP3ycVqAnZSUMYzHygxhb-nEE_Yv_QmZY=s0#w=1920&h=1080" />
<img width = "40%" src = "https://github.com/GaganGupta19/Build-it-Bigger/blob/master/Screenshots/device-2016-10-14-121852.png" />
<img width = "40%" src = "https://github.com/GaganGupta19/Build-it-Bigger/blob/master/Screenshots/device-2016-10-14-122038.png" />


# How Did I Complete this Project?
## Step 0: Starting Point

This is the starting point for the final project, which is provided to you in the course repository.

It contains an activity with a banner ad and a button that purports to tell a joke, but actually just complains. The banner ad was set up following the instructions here.

You may need to download the Google Repository from the Extras section of the Android SDK Manager.

When you can build an deploy this starter code to an emulator, you're ready to move on.
## Step 1: Create a Java library

Your first task is to create a Java library that provides jokes. Create a new Gradle Java project either using the Android Studio wizard, or by hand. Then introduce a project dependency between your app and the new Java Library. If you need review, check out demo 4.01 from the course code.

Make the button display a toast showing a joke retrieved from your Java joke telling library.
## Step 2: Create an Android Library

Create an Android Library containing an Activity that will display a joke passed to it as an intent extra. Wire up project dependencies so that the button can now pass the joke from the Java Library to the Android Library.

For review on how to create an Android library, check out demo 4.03. For a refresher on intent extras, check out this documentation.
## Step 3: Create GCE Module

This next task will be pretty tricky. Instead of pulling jokes directly from our Java library, we'll set up a GCE development server, and pull our jokes from there. Follow the instructions in this tutorial to add a GCE module to your project:

Introduce a project dependency between your Java library and your GCE module, and modify the GCE starter code to pull jokes from your Java library. Create an Async task to retrieve jokes. Made the button kick off a task to retrieve a joke, then launch the activity from your Android Library to display it.
## Step 4: Add Functional Tests

Add code to test that your Async task successfully retrieves a non-empty string. For a refresher on setting up Android tests, check out demo 4.09.
## Step 5: Add a Paid Flavor

Add free and paid product flavors to your app. Remove the ad (and any dependencies you can) from the paid flavor. IMPORTANT: You do not need Google AdMob in the Manifest of the paid version of the app. Make sure to include this only with the free/ manifest. Also make sure to add Google Play Services only to the free version of the app in Gradle.
Optional Tasks

## Optional tasks
For extra practice to make my project stand out, I completed the following tasks.
Add Interstitial Ad

Follow these instructions to add an interstitial ad to the free version. Display the ad after the user hits the button, and before the joke is shown.
Add Loading Indicator

Add a loading indicator that is shown while the joke is being retrieved, and disappears when the joke is ready. This tutorial is a good place to start.
Configure Test Task

To tie it all together, create a Gradle task that:

    Launches the GCE local development server
    Runs all tests
    Shuts the server down again

# LICENSE

   Copyright 2016 Gagan Gupta

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
