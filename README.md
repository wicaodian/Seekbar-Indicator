[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14) [![](https://jitpack.io/v/wicaodian/Seekbar-Indicator.svg)](https://jitpack.io/#wicaodian/Seekbar-Indicator)

# IndicatorSeekBar

A customizable Android SeekBar with adjustable size, color, thumb, tick marks, and indicator. Supports dynamic styling via XML or code, gradient tracks, animated tick marks, and a progress indicator with customizable text and appearance.


## Overview
<img src="https://github.com/wicaodian/Seekbar-Indicator/blob/master/gif/overview.png?raw=true" width = "392" height = "115"/>

## Screenshots
<img src="https://github.com/wicaodian/Seekbar-Indicator/blob/master/gif/continuous.gif?raw=true" width = "264" height = "464"/><img src="https://github.com/wicaodian/Seekbar-Indicator/blob/master/gif/discrete_1.gif?raw=true" width = "264" height = "464"/>

## Setup

```gradle
implementation 'com.github.wicaodian:Seekbar-Indicator:$latest'
```

## Usage
#### xml

```xml
<com.wicaodian.widget.IndicatorSeekBar
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:isb_max="100"
    app:isb_min="-1.0"
    app:isb_progress="25"
    app:isb_seek_smoothly="true"
    app:isb_ticks_count="5"
    app:isb_show_tick_marks_type="oval"
    app:isb_tick_marks_size="13dp"
    app:isb_tick_marks_drawable="@mipmap/ic_launcher"
    app:isb_show_tick_texts="true"
    app:isb_tick_texts_size="15sp"
    app:isb_tick_texts_color="@color/color_blue"
    app:isb_thumb_color="@color/color_green"
    app:isb_thumb_size="20dp"
    app:isb_show_indicator="rounded_rectangle"
    app:isb_indicator_color="@color/color_gray"
    app:isb_indicator_text_color="@color/colorAccent"
    app:isb_indicator_text_size="18sp"
    app:isb_track_background_color="@color/color_gray"
    app:isb_track_background_size="2dp"
    app:isb_track_progress_color="@color/color_blue"
    app:isb_track_progress_size="4dp"
    app:isb_only_thumb_draggable="false"/>
```
#### Java

```Java

 IndicatorSeekBar seekBar = IndicatorSeekBar
                .with(getContext())
                .max(110)
                .min(10)
                .progress(53)
                .tickCount(7)
                .showTickMarksType(TickMarkType.OVAL)
                .tickMarksColor(getResources().getColor(R.color.color_blue, null))
                .tickMarksSize(13)//dp
                .showTickTexts(true)
                .tickTextsColor(getResources().getColor(R.color.color_pink))
                .tickTextsSize(13)//sp
                .tickTextsTypeFace(Typeface.MONOSPACE)
                .showIndicatorType(IndicatorType.ROUNDED_RECTANGLE)
                .indicatorColor(getResources().getColor(R.color.color_blue))
                .indicatorTextColor(Color.parseColor("#ffffff"))
                .indicatorTextSize(13)//sp
                .thumbColor(getResources().getColor(R.color.colorAccent, null))
                .thumbSize(14)
                .trackProgressColor(getResources().getColor(R.color.colorAccent,null))
                .trackProgressSize(4)
                .trackBackgroundColor(getResources().getColor(R.color.color_gray))
                .trackBackgroundSize(2)
		.onlyThumbDraggable(false)
                .build();

```

## Indicator stay always

Put IndicatorSeekBar into a IndicatorStayLayout can make the indicator stayed always.
By the way, make sure you had called the attr to show the indicator before.

#### Xml

```xml
<com.wicaodian.widget.IndicatorStayLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <!--your layout-->
    <com.wicaodian.widget.IndicatorSeekBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:isb_show_indicator="rectangle" <!--show indicator can not be NONE-->
        ....../>
    <!--your layout-->
</com.wicaodian.widget.IndicatorStayLayout>
```

#### Java

```Java
IndicatorSeekBar seekBar = IndicatorSeekBar
                .with(getContext())
                .max(50)
                .min(10)
                .showIndicatorType(IndicatorType.RECTANGLE) //show indicator can not be NONE
                ...
                .build();

new IndicatorStayLayout(getContext()).attachTo(seekBar);
```
## Custom indicator's View

You can custom the indicator View by below way:

If you want to replace the indicator's View on top part, you can call:
```Java
 seekBar.getIndicator().setTopContentView(yourTopView);
```

or want to custom the indicator's View you want , you can call:
```Java
seekBar.getIndicator().setContentView(yourView);
```

## Custom indicator's text

Set a format string with placeholder `${PROGRESS}` or `${TICK_TEXT}` to IndicatorSeekBar, the indicator's text would change.
For example:
If you want to show the progress with suffix: `%` ，the code like：

```Java
seekBar.setIndicatorTextFormat("${PROGRESS} %")

Kotlin:
seekBar.setIndicatorTextFormat("\${PROGRESS} %")
```

or want to show the tick text with prefix: `I am` ，the code like：

```Java
seekBar.setIndicatorTextFormat("I am ${TICK_TEXT}")

Kotlin:
seekBar.setIndicatorTextFormat("I am \${TICK_TEXT}")
```

## Custom section tracks color
The color of every block of seek bar can also be custom.

```Java
seekBar.customSectionTrackColor(new ColorCollector() {
    @Override
    public boolean collectSectionTrackColor(int[] colorIntArr) {
        //the length of colorIntArray equals section count
        colorIntArr[0] = getResources().getColor(R.color.color_blue, null);
        colorIntArr[1] = getResources().getColor(R.color.color_gray, null);
        colorIntArr[2] = Color.parseColor("#FF4081");
        ...
        return true; //True if apply color , otherwise no change
    }
});
```

## Selector drawable&color were supported

You can set the StateListDrawable or ColorStateList for the thumb, tickMarks;
 also, ColorStateList for tickTexts is supported, too. Usage's format according to:

Thumb selector drawable:

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!--this drawable is for thumb when pressing-->
    <item android:drawable="@mipmap/ic_launcher_round" android:state_pressed="true" />
    <!--for thumb in normal-->
    <item android:drawable="@mipmap/ic_launcher" />
</selector>
```

Thumb selector color:

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!--this color is for thumb which is at pressing status-->
    <item android:color="@color/colorAccent" android:state_pressed="true" />
    <!--for thumb which is at normal status-->
    <item android:color="@color/color_blue" />
</selector>
```

TickMarks selector drawable：

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!--this drawable is for tickMarks those are at start side of thumb-->
    <item android:drawable="@mipmap/ic_launcher_round" android:state_selected="true" />
    <!--for tickMarks in normal-->
    <item android:drawable="@mipmap/ic_launcher" />
</selector>
```

TickMarks selector color：

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!--this color is for marks those are at start side of thumb-->
    <item android:color="@color/colorAccent" android:state_selected="true" />
    <!--for marks those are at right side of thumb-->
    <item android:color="@color/color_gray" />
</selector>
```

TickTexts selector color：

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!--this color is for texts those are at start side of thumb-->
    <item android:color="@color/colorAccent" android:state_selected="true" />
    <!--for tick text which is stopped under thumb -->
    <item android:color="@color/color_blue" android:state_hovered="true" />
    <!--for texts those are at right side of thumb-->
    <item android:color="@color/color_gray" />
</selector>
```

## Listener
```Java
seekBar.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {
                Log.i(TAG, seekParams.seekBar);
                Log.i(TAG, seekParams.progress);
                Log.i(TAG, seekParams.progressFloat);
                Log.i(TAG, seekParams.fromUser);
                //when tick count > 0
                Log.i(TAG, seekParams.thumbPosition);
                Log.i(TAG, seekParams.tickText);
            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
            }
        });
```
## Attributes

[ attr.xml ](https://github.com/wicaodian/Seekbar-Indicator/blob/master/seekbarindicator/src/main/res/values/attr.xml)

### Credit

This library was originally developed by [Chuang Guangquan](https://github.com/warkiz). His contributions laid the foundation for this project, and his work is greatly appreciated.

**Note:** The original author is no longer actively maintaining this library. Additionally, the latest version of the library has issues with downloading, which may affect its usability.

We encourage the community to contribute improvements or fork the project if needed.
