# Personal-trainer-appointment-system

> v1.0.0

# 用户侧/用户操作

## GET 登录

GET /ptas/wx/onLogin

用于用户登录，需要微信code码

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|code|query|string| 否 |none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» msg|string|true|none||none|
|» data|object|false|none||none|
|»» openId|string|true|none||none|
|»» token|string|true|none||none|

## POST 个人信息查询

POST /ptas/userInfo

用于查询个人信息

> Body 请求参数

```json
{
  "openId": "string",
  "token": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» openId|body|string| 是 |none|
|» token|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": {
    "openId": "oSBcm5IMj7BoutOSdNNo4GUumPBQ",
    "userName": "Ginger",
    "createTime": 1662650941000,
    "updateTime": 1663052436000
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» msg|string|true|none||none|
|» data|object|false|none||none|
|»» openId|string|true|none||none|
|»» userName|string|true|none||none|
|»» email|string|false|none||none|
|»» phone|string|false|none||none|
|»» createTime|integer|true|none||none|
|»» updateTime|integer|true|none||none|

## POST 改名

POST /ptas/rename

用户修改名字

> Body 请求参数

```json
{
  "openId": "string",
  "token": "string",
  "userName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» openId|body|string| 是 |none|
|» token|body|string| 是 |none|
|» userName|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": {
    "openId": "oSBcm5IMj7BoutOSdNNo4GUumPBQ",
    "userName": "Ginger"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» msg|string|true|none||none|
|» data|object|false|none||none|
|»» openId|string|true|none||none|
|»» userName|string|true|none||none|

# 用户侧/图片数据

## GET 获取轮播图（banner）

GET /ptas/image/slideshow

用于获取图片路径

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "picId": 1,
      "url": "https://harmonyosnchu.com/image/slideshow/9e648c6b33a3809abc58d258e21a3c88ae76449302404971736c16f956ae56f3.jpg",
      "used": true
    },
    {
      "picId": 2,
      "url": "https://harmonyosnchu.com/image/slideshow/859a294f107f08310a21ec2f18b62ce990fc76089608aaa1b4a7908d1942db20.jpg",
      "used": true
    },
    {
      "picId": 3,
      "url": "https://harmonyosnchu.com/image/slideshow/4b4b16eb5e17f4f91d6e32c8b3cb7ec18aa409ae7a3e676e513ebba631ad8f80.jpg",
      "used": true
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» msg|string|true|none||none|
|» data|[object]|true|none||none|
|»» picId|integer|true|none||none|
|»» url|string|true|none||none|
|»» used|boolean|true|none||none|

# 数据模型

