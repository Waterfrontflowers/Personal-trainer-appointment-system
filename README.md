# Personal-trainer-appointment-system

> v1.0.0

# 用户侧/用户操作

## GET 个人信息查询

GET /ptas/userInfo

用于查询个人信息

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|header|string| 是 |鉴权|

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": {
    "openId": "oSBcm5IMj7BoutOSdNNo4GUumPBQ",
    "userName": "Ginger",
    "createTime": "2022-09-08T15:29:01.000+00:00",
    "updateTime": "2022-09-13T07:00:36.000+00:00"
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
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|

## GET 登录

GET /ptas/wx/onLogin

用于用户登录，需要微信code码

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|code|query|string| 否 |微信登录码|

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
|» data|object|true|none||none|
|»» openId|string|true|none||none|
|»» userName|string|true|none||none|
|»» email|string|false|none||none|
|»» phone|string|false|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|

## POST 改名

POST /ptas/rename

用户修改名字

> Body 请求参数

```json
{
  "userName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|header|string| 是 |鉴权|
|body|body|object| 否 |none|
|» userName|body|string| 是 |用户希望改成的名字|

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
|» data|[object]|false|none||none|
|»» picId|integer|true|none||none|
|»» url|string|true|none||none|
|»» used|boolean|true|none||none|

# 用户侧/课程、订单

## GET 获取当前可预约课程/教练分类

GET /ptas/courseSortByCoach

获取当前可预约课程/教练分类

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "coachName": "A0001",
      "phone": "123456789101213",
      "course": [
        {
          "id": 1,
          "coachId": 1,
          "name": "B01",
          "subtitle": "功能性拳课",
          "price": 200,
          "stock": 10,
          "status": 1,
          "courseTime": "2022-11-06T07:28:01.000+00:00",
          "createTime": "2022-09-13T07:28:01.000+00:00",
          "updateTime": "2022-09-16T06:51:58.000+00:00"
        },
        {
          "id": 7,
          "coachId": 1,
          "name": "B07",
          "subtitle": "3M骨关节康复",
          "price": 200,
          "stock": 40,
          "status": 1,
          "courseTime": "2022-10-02T07:17:19.000+00:00",
          "createTime": "2022-09-15T07:17:19.000+00:00",
          "updateTime": "2022-09-16T06:53:00.000+00:00"
        },
        {
          "id": 13,
          "coachId": 1,
          "name": "B13",
          "subtitle": "心肺耐力训练",
          "price": 75,
          "stock": 42,
          "status": 1,
          "courseTime": "2022-10-08T07:22:46.000+00:00",
          "createTime": "2022-09-15T07:22:46.000+00:00",
          "updateTime": "2022-09-16T06:52:24.000+00:00"
        },
        {
          "id": 19,
          "coachId": 1,
          "name": "B19",
          "subtitle": "悬挂训练",
          "price": 85,
          "stock": 2,
          "status": 1,
          "courseTime": "2022-10-09T07:25:18.000+00:00",
          "createTime": "2022-09-15T07:25:18.000+00:00",
          "updateTime": "2022-09-16T06:53:13.000+00:00"
        }
      ],
      "id": 1,
      "email": "123456",
      "url": "/image/coach/9ee0e11f04ba646182265e87ef6e0f03521bad473501b396f818d9b77fe4c3a3.jpg"
    },
    {
      "coachName": "A0002",
      "phone": "123456789101112",
      "course": [
        {
          "id": 2,
          "coachId": 2,
          "name": "B02",
          "subtitle": "体能训练绳",
          "price": 400,
          "stock": 6,
          "status": 1,
          "courseTime": "2022-10-09T07:29:07.000+00:00",
          "createTime": "2022-09-13T07:29:07.000+00:00",
          "updateTime": "2022-09-16T06:52:32.000+00:00"
        },
        {
          "id": 8,
          "coachId": 2,
          "name": "B08",
          "subtitle": "孕产康复",
          "price": 450,
          "stock": 20,
          "status": 1,
          "courseTime": "2022-10-09T07:17:43.000+00:00",
          "createTime": "2022-09-15T07:17:43.000+00:00",
          "updateTime": "2022-09-16T06:53:19.000+00:00"
        },
        {
          "id": 14,
          "coachId": 2,
          "name": "B14",
          "subtitle": "柔韧性训练",
          "price": 77,
          "stock": 10,
          "status": 1,
          "courseTime": "2022-10-09T07:23:08.000+00:00",
          "createTime": "2022-09-15T07:23:08.000+00:00",
          "updateTime": "2022-09-16T06:52:48.000+00:00"
        }
      ],
      "id": 2,
      "url": "/image/coach/64b224e20ae4a1d30c715f4ec1ecd24e98a6a7253677efc933592a9deb2f5565.jpg"
    },
    {
      "coachName": "A0003",
      "phone": "123456789111214",
      "course": [
        {
          "id": 3,
          "coachId": 3,
          "name": "B03",
          "subtitle": "波速球训练",
          "price": 600,
          "stock": 5,
          "status": 1,
          "courseTime": "2022-10-09T07:29:33.000+00:00",
          "createTime": "2022-09-13T07:29:33.000+00:00",
          "updateTime": "2022-09-16T06:52:55.000+00:00"
        },
        {
          "id": 9,
          "coachId": 3,
          "name": "B09",
          "subtitle": "肌力训练",
          "price": 200,
          "stock": 59,
          "status": 1,
          "courseTime": "2022-11-06T07:20:44.000+00:00",
          "createTime": "2022-09-15T07:20:44.000+00:00",
          "updateTime": "2022-09-16T06:52:18.000+00:00"
        },
        {
          "id": 15,
          "coachId": 3,
          "name": "B15",
          "subtitle": "运动营养及评估",
          "price": 77,
          "stock": 12,
          "status": 1,
          "courseTime": "2022-10-09T07:23:34.000+00:00",
          "createTime": "2022-09-15T07:23:34.000+00:00",
          "updateTime": "2022-09-16T06:53:09.000+00:00"
        }
      ],
      "id": 3,
      "url": "/image/coach/277044bae8fcd3627dd367c604db5949ddac5ae3c30368640c03af4dbcdd8e18.jpg"
    },
    {
      "coachName": "A0004",
      "phone": "123456789121314",
      "course": [
        {
          "id": 4,
          "coachId": 4,
          "name": "B04",
          "subtitle": "软组织放松",
          "price": 200,
          "stock": 4,
          "status": 1,
          "courseTime": "2022-10-09T07:15:42.000+00:00",
          "createTime": "2022-09-15T07:15:42.000+00:00",
          "updateTime": "2022-09-16T06:53:16.000+00:00"
        },
        {
          "id": 10,
          "coachId": 4,
          "name": "B10",
          "subtitle": "肌肥大训练",
          "price": 50,
          "stock": 12,
          "status": 1,
          "courseTime": "2022-10-09T07:21:08.000+00:00",
          "createTime": "2022-09-15T07:21:08.000+00:00",
          "updateTime": "2022-09-16T06:52:39.000+00:00"
        },
        {
          "id": 16,
          "coachId": 4,
          "name": "B16",
          "subtitle": "健康状态分析评估",
          "price": 71,
          "stock": 25,
          "status": 1,
          "courseTime": "2022-10-09T07:23:59.000+00:00",
          "createTime": "2022-09-15T07:23:59.000+00:00",
          "updateTime": "2022-09-16T06:53:32.000+00:00"
        }
      ],
      "id": 4,
      "url": "/image/coach/bcfdd1197b3a5d9f4b018a14d6a9be36824cb1e4dce34434974934df7c650ff0.jpg"
    },
    {
      "coachName": "A0005",
      "phone": "123456789111516",
      "course": [
        {
          "id": 5,
          "coachId": 5,
          "name": "B05",
          "subtitle": "康复普拉提",
          "price": 100,
          "stock": 100,
          "status": 1,
          "courseTime": "2022-11-06T07:16:15.000+00:00",
          "createTime": "2022-09-15T07:16:15.000+00:00",
          "updateTime": "2022-09-16T06:52:05.000+00:00"
        },
        {
          "id": 11,
          "coachId": 5,
          "name": "B11",
          "subtitle": "肌耐力训练",
          "price": 45,
          "stock": 50,
          "status": 1,
          "courseTime": "2022-10-09T07:21:51.000+00:00",
          "createTime": "2022-09-15T07:21:51.000+00:00",
          "updateTime": "2022-09-16T06:53:04.000+00:00"
        },
        {
          "id": 17,
          "coachId": 5,
          "name": "B17",
          "subtitle": "FMS",
          "price": 252,
          "stock": 32,
          "status": 1,
          "courseTime": "2022-10-08T07:24:30.000+00:00",
          "createTime": "2022-09-15T07:24:30.000+00:00",
          "updateTime": "2022-09-16T06:52:28.000+00:00"
        }
      ],
      "id": 5,
      "url": "/image/coach/ed7cc81a2ab7b7971996379f4cb71e17a67aeb35c0a083a2ea07fe9c1ccedb5b.jpg"
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
|»» coachName|string|true|none||none|
|»» phone|string|true|none||none|
|»» course|[object]|true|none||none|
|»»» id|integer|true|none||none|
|»»» coachId|integer|true|none||none|
|»»» name|string|true|none||none|
|»»» subtitle|string|true|none||none|
|»»» price|integer|true|none||none|
|»»» stock|integer|true|none||none|
|»»» status|integer|true|none||none|
|»»» courseTime|string|true|none||none|
|»»» createTime|string|true|none||none|
|»»» updateTime|string|true|none||none|
|»» id|integer|true|none||none|
|»» email|string|false|none||none|
|»» url|string|true|none||none|

## POST 取消订单

POST /ptas/cancelOrder

> Body 请求参数

```json
{
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|header|string| 是 |鉴权|
|body|body|object| 否 |none|
|» id|body|integer| 是 |none|

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

## GET 查询订单明细

GET /ptas/orderItemList

查询订单明细

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|cookie|string| 是 |鉴权|
|orderId|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 101,
  "msg": "越权访问"
}
```

```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "coachName": "A0001",
      "courseName": "B01",
      "quantity": 1,
      "orderId": 35,
      "totalPrice": 200,
      "createTime": "2022-09-15T14:03:08",
      "currentUnitPrice": 200,
      "updateTime": "2022-09-15T14:03:08",
      "id": 23,
      "courseId": 1,
      "coachId": 1
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
|» data|[object]|false|none||none|
|»» coachName|string|false|none||none|
|»» courseName|string|false|none||none|
|»» quantity|integer|false|none||none|
|»» orderId|integer|false|none||none|
|»» totalPrice|integer|false|none||none|
|»» createTime|string|false|none||none|
|»» currentUnitPrice|integer|false|none||none|
|»» updateTime|string|false|none||none|
|»» id|integer|false|none||none|
|»» courseId|integer|false|none||none|
|»» coachId|integer|false|none||none|

## POST 新建订单

POST /ptas/newOrder

创建一个订单

> Body 请求参数

```json
[
  {
    "id": 0
  }
]
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|header|string| 是 |鉴权|
|body|body|array[object]| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": {
    "id": 42,
    "orderNo": 0,
    "userId": 8,
    "payment": 200,
    "paymentType": 0,
    "status": 10,
    "createTime": "2022-09-15T06:34:17.000+00:00",
    "updateTime": "2022-09-15T06:34:17.000+00:00"
  }
}
```

```json
{
  "code": 201,
  "msg": "部分商品超出库存",
  "data": {
    "id": 42,
    "orderNo": 0,
    "userId": 8,
    "payment": 400,
    "paymentType": 0,
    "status": 10,
    "createTime": "2022-09-15T06:34:17.000+00:00",
    "updateTime": "2022-09-15T06:34:17.000+00:00"
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
|»» id|integer|true|none||none|
|»» orderNo|integer|true|none||none|
|»» userId|integer|true|none||none|
|»» payment|integer|true|none||none|
|»» paymentType|integer|true|none||none|
|»» status|integer|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|

## GET 查询订单列表

GET /ptas/orderList

查询订单列表

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|header|string| 是 |鉴权|

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
|» data|[object]|false|none||none|
|»» id|integer|true|none||none|
|»» orderNo|integer|true|none||none|
|»» userId|integer|true|none||none|
|»» payment|number|true|none||none|
|»» paymentType|integer|true|none||none|
|»» status|integer|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|

## POST 支付

POST /ptas/pay

支付接口

> Body 请求参数

```json
{
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Cookie|header|string| 是 |鉴权|
|body|body|object| 否 |none|
|» id|body|integer| 是 |订单编号|

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success"
}
```

```json
{
  "code": 110,
  "msg": "请勿重复支付或在非等待支付的订单上进行支付操作"
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

## GET 获取当前可预约课程

GET /ptas/course

获取当前在售课程

> 返回示例

> 成功

```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "coachName": "A0001",
      "name": "B01",
      "price": 200,
      "stock": 10,
      "status": 1,
      "imageUrl": "/image/slideshow/0d19ef2a66c9d6adb4824401ae104ce8359958a173a97b3666fbf82e99921d4a.jpg",
      "courseTime": "2022-09-13T07:28:01.000+00:00",
      "createTime": "2022-09-13T07:28:01.000+00:00",
      "updateTime": "2022-09-13T07:28:01.000+00:00"
    },
    {
      "id": 2,
      "coachName": "A0002",
      "name": "B02",
      "price": 400,
      "stock": 6,
      "status": 1,
      "imageUrl": "/image/slideshow/105d6330e6084893ba3eb806ce2e4f448e90b302e8bb063160ad68b56a285549.jpg",
      "courseTime": "2022-09-13T07:29:07.000+00:00",
      "createTime": "2022-09-13T07:29:07.000+00:00",
      "updateTime": "2022-09-13T07:29:07.000+00:00"
    },
    {
      "id": 3,
      "coachName": "A0003",
      "name": "B03",
      "price": 600,
      "stock": 5,
      "status": 1,
      "imageUrl": "/image/slideshow/db96db2ec822a2c5d13ff3df5d70c4bd9f88460ab02fc28faa93272ed79a5330.jpg",
      "courseTime": "2022-09-13T07:29:33.000+00:00",
      "createTime": "2022-09-13T07:29:33.000+00:00",
      "updateTime": "2022-09-13T07:29:33.000+00:00"
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
|» data|[object]|false|none||none|
|»» id|integer|true|none||none|
|»» coachName|string|true|none||none|
|»» name|string|true|none||none|
|»» subTitle|string|false|none||none|
|»» imageUrl|string|false|none||none|
|»» detail|string|false|none||none|
|»» price|number|true|none||none|
|»» stock|integer|true|none||none|
|»» status|integer|true|none||none|
|»» courseTime|string|true|none||none|
|»» createTime|string|true|none||none|
|»» updateTime|string|true|none||none|

# 数据模型

