#### Swaiot开放平台下帐号SDK库

##### Android-SDK及demo下载地址
https://github.com/swaiot/AccountSDK-Android.git

##### 安装方式
- 1 在开放平台上获得分配到的Swaiot开发者appkey和saltkey;
- 2 在工程的libs中引入swaiot_account_lib_v1.0-xxx.aar ;
- 3 在工程的build.gradle当中增加如下:
~~~ java
   implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])
~~~

- ４ 继承SwaiotAccountActivity类，并实如下４个接口：
~~~java
    protected abstract void onGetTokenFail(int errCode,String errMessage);
    protected abstract void onGetTokenSuccess(TokenInfo token);
    protected abstract void onGetAccountInfoFail(int errCode,String errMessage);
    protected abstract void onGetAccountInfoSuccess(AccountInfo accountInfo);
    protected abstract String appKey();
~~~


详细可见下载地址中的demo工程的配置及代码说明.

##### API说明

###### SwaiotAccountActivity 类API
~~~java
	 /**
     * 在activity当中，调用Swaiot帐号登录接口
     * @param appKey　从swaiot开放平台分配到的appkey
     * @param appSalt　从swaiot开放平台分配到的appsalt
     */
    public void swaiotLogin(String appKey,String appSalt)；
~~~
~~~java
	/**
     * 在activity当中，调用获取用户脱敏信息的接口
     */
    public void getAccountInfo()；
~~~

~~~java
	/**
     * 退出登录
     */
    public void logout()；
~~~
~~~java
	/**
	* 需要继承实现
     * 获取用户访问令牌失败
     * @param errCode　错误码
     * @param errMessage　错误消息
     */
    protected abstract void onGetTokenFail(int errCode,String errMessage)；
~~~
~~~java
	/**
	* 需要继承实现
     * 获取用户访问令牌成功
     * @param token　访问令牌参数
     */
    protected abstract void onGetTokenSuccess(TokenInfo token);
~~~
~~~java
	/**
	*　需要继承实现
     * 获取用户相关脱敏信息失败
     * @param errCode　　错误码
     * @param errMessage　错误信息
     */
    protected abstract void onGetAccountInfoFail(int errCode,String errMessage)；
~~~
~~~java
	/**
     * 需要继承实现
     * 获取用户相关脱敏信息成功
     * @param accountInfo
     */
    protected abstract void onGetAccountInfoSuccess(AccountInfo accountInfo);
~~~

~~~java
	/**
	* 需要继承实现
     * @return 返回从swaiot开放平台分配到的appkey
     */
    protected abstract String appKey();
~~~