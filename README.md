# Photo Editor

## Config Gradle

Add it in your root build.gradle at the end of repositories:
```
  allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
  }
```
Add the dependency in gradle file of app module like this
```
implementation 'com.github.Davidcep:PhotoEdit:1.2'
```
Add the compatibility with Java 1.8:
```
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}
```

## Setting the PhotoEditor activity:
Add this constant to your activity class with your preferred request code:
```
private final int PHOTO_EDITOR_REQUEST_CODE = 231;// Any integer value as a request code.
```

Use the following code to build and launch the photo editor:
```
 try {
  Intent intent = new ImageEditorIntentBuilder(this, sourceImagePath, outputFilePath)
         .withAddText() // Add the features you need
         .withPaintFeature()
         .withFilterFeature()
         .withRotateFeature()
         .withCropFeature()
         .withBrightnessFeature()
         .withSaturationFeature()
         .withBeautyFeature()
         .withStickerFeature()
         .forcePortrait(true)  // Add this to force portrait mode (It's set to false by default)
         .build();

 EditImageActivity.start(activity, intent, PHOTO_EDITOR_REQUEST_CODE);
 } catch (Exception e) {
     Log.e("Demo App", e.getMessage()); // This could throw if either `sourcePath` or `outputPath` is blank or Null
 }
```

## Receiving the output image
You can receive the new processed image path and it's edit status like this:
```
 @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PHOTO_EDITOR_REQUEST_CODE) { // same code you used while starting
            String newFilePath = data.getStringExtra(EditImageActivity.OUTPUT_PATH);
            boolean isImageEdit = data.getBooleanExtra(EditImageActivity.IMAGE_IS_EDIT, false);
        }
    }
```
