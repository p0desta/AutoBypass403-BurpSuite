# AutoBypass403-BurpSuite
A burpsuite plugin help me automatic bypass 403.

申明：该工具只用于安全自测，禁止用于非法用途

## ChangeLog

#### 2021-12-05

* support multiple messages send to bypass403
* add multiple rules from @Laura_小狮子
* add number of requests to show
* Increase similarity matching(from @pmiaowu HostCollision); if the response is the same, it will not be displayed

#### 2021-12-04

* support multi-threaded concurrency

#### 2021-12-02 

- First public release

## How to Run ##

1. Download Bypass.jar

2. Burpsuite Extender add Bypass.jar

   ![image-20211204120709887](README_picture/image-20211204120709887.png)

   

3. Select the request, right click "send to bypass 403"

   ![image-20211202221317291](README_picture/image-20211202221317291.png)

4. Select the plugin table and analyze the results

   ![image-20211205121741248](README_picture/image-20211205121741248.png)

   

## Thanks

*  https://github.com/iamj0ker/bypass-403
