# 新海内部UI
## 刷新列表  
## neoceansoftRefreshRecyclerviewUI
![image](https://github.com/Dougbutyl/neoceansoftRefreshRecyclerviewUI/blob/master/screen/devicescreen.gif)

## Dependency
Add it in your root build.gradle at the end of repositories:
``` Java
 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 and then add dependency
``` Java
 		dependencies {
	        implementation 'com.github.Dougbutyl:neoceansoftRefreshRecyclerviewUI:1.0'
	}


 ```
 ## Usage
 ### Xml
 ```
<com.neocean.app.refreshrecyclerview.RefreshRecyclerView
        android:id="@+id/xr"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
      ></com.neocean.app.refreshrecyclerview.RefreshRecyclerView>
```



 
