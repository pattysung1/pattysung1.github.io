---
title: "ObjectMapper- Java Object和JSON之間的相互轉換"
date: 2023-06-17
draft: false

# post thumb
image: "images/java.png"

# meta description
description: "this is meta description"

# taxonomies
categories:
  - "Programming"
tags:
  - "Java"
  - "ObjectMapper"
  
# post type
type:  "featured"
---

目前在幫ShinyBear品牌做電商網站，在前後端的傳遞資訊時，時常使用到Json，而使用ObjectMapper，可以將Json字串及Java Object互相作轉換。

但注意，要記得在pom.xql中加上spring-boot-starter-web
```java

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### 說明
ObjectMapper是一個Java庫，用於處理Java對象和JSON之間的相互轉換。它提供了一種簡單而靈活的方法，可將Java對象序列化為JSON格式的字符串，並將JSON字符串反序列化為Java對象。使用ObjectMapper能夠在處理JSON數據時變得更加便捷。

### 以下是ObjectMapper的一些常見用法(1.2較常用)：
1. 將Java對象轉換為JSON字符串：(writeValueAsString())
```java

ObjectMapper objectMapper = new ObjectMapper();
YourObject obj = new YourObject();
String jsonString = objectMapper.writeValueAsString(obj);
```

2.將JSON字符串轉換為Java對象：(readValue())
```java

ObjectMapper objectMapper = new ObjectMapper();
String jsonString = "{\"name\":\"John\",\"age\":30}";
YourObject obj = objectMapper.readValue(jsonString, YourObject.class);
```

3.格式化JSON輸出：
```java

ObjectMapper objectMapper = new ObjectMapper();
YourObject obj = new YourObject();
String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
```
可以使用ObjectMapper生成格式化的JSON字符串，以提高可讀性。

4.處理特殊情況：
```JAVA

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
YourObject obj = new YourObject();
String jsonString = objectMapper.writeValueAsString(obj);
```
ObjectMapper提供了處理日期格式、處理集合類型、自定義序列化和反序列化等特殊情況的功能。
可以依照要規劃的功能做使用，不過主要還是前兩者使用的多。