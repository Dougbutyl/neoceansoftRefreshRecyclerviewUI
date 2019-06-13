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
### 设置刷新监听
```
  mRefreshRecyclerView.setLoadingListener(new RefreshRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
	   	 //TODO 完成刷新操作
               
            }

            @Override
            public void onLoadMore() {
		//TODO 完成刷新操作
               
            }
        });
```
```
	setPullRefreshEnabled(true);//设置下拉刷新
	setLoadingMoreEnabled(true);//设置加载更多
	refresh();//刷新完成
	refreshComplete("此次更新10条数据");//设置刷新完成时数据提示
	loadMoreComplete();//刷新完成
	setNoMore(true);
	setNoMore(true,"我是有底线的");//设置底部文字
	refresh();//主动刷新需要设置在刷新监听之后
```



 
