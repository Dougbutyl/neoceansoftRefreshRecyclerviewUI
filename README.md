# 新海内部UI
## 刷新列表  
## RefreshRecyclerView
![image](https://github.com/Dougbutyl/neoceansoftRefreshRecyclerviewUI/blob/master/screen/devicescreen.gif)
#### 实现对XRecyclerview的封装，添加刷新完成时刷新数据的提示，修改底部加载留白问题处理

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



 
