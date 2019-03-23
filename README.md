# order-service
Microservice order-service
----------------------------------------------------------------------------------------------------------------------------------
POST /orders/save HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 279327fa-c3f3-27b7-32c0-480176b30b9c

REQUEST
{
	"email" : "joao@email.com",
	"fullName" : "João Marcos da Costa",
	"shippingAddress" : "Rua A, 150 - São Paulo",
	"items" : [{
		"description" : "Samsung Galaxy S9",
		"unitPrice" : 2700.0,
		"quantity" : 1
	}],
	"payment" : {
		"transactionId" : "1cf07473-2111-4398-8c1f-147183687567",
		"cardNumber" : "123456789101",
		"expirationDate" : "20/03/2022",
		"flag" : "VISA"
	},
	"totalPrice" : 2700.0,
	"date" : "23/03/2019",
	"status" : "Em processamento"
}
----------------------------------------------------------------------------------------------------------------------------------
GET /orders/findById/39c0c48b-7836-4223-801d-18b9f819a3ac HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: b90df578-d2f5-e922-de17-1d5d62a25adf

RESPONSE
{
    "orderId": "39c0c48b-7836-4223-801d-18b9f819a3ac",
    "email": "joao@email.com",
    "fullName": "João Marcos da Costa",
    "shippingAddress": "Rua A, 150 - São Paulo",
    "items": [
        {
            "description": "Samsung Galaxy S9",
            "unitPrice": 2700,
            "quantity": 1
        }
    ],
    "payment": {
        "transactionId": "1cf07473-2111-4398-8c1f-147183687567",
        "cardNumber": "123456789101",
        "expirationDate": "20/03/2022",
        "flag": "VISA"
    },
    "totalPrice": 2700,
    "date": "23/03/2019",
    "status": "Em processamento"
}
----------------------------------------------------------------------------------------------------------------------------------
PUT /orders/update/39c0c48b-7836-4223-801d-18b9f819a3ac HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 2cc9c70f-9f7d-4772-9a49-6b7d486fe55f

REQUEST
{
    "orderId": "1cf07473-2111-4398-8c1f-147183687567",
    "email": "joaomarcos@email.com",
    "fullName": "João Marcos da Costa",
    "shippingAddress": "Rua C, 420 - São Paulo",
    "items": [
        {
            "description": "Samsung Galaxy S9 Plus",
            "unitPrice": 3200,
            "quantity": 1
        }
    ],
    "payment": {
        "cardNumber": "123456789101",
        "expirationDate": "20/03/2022",
        "flag": "VISA"
    },
    "totalPrice": 3200,
    "date": "23/03/2019",
    "status": "Em processamento"
}

RESPONSE
{
    "orderId": "1cf07473-2111-4398-8c1f-147183687567",
    "email": "joaomarcos@email.com",
    "fullName": "João Marcos da Costa",
    "shippingAddress": "Rua C, 420 - São Paulo",
    "items": [
        {
            "description": "Samsung Galaxy S9 Plus",
            "unitPrice": 3200,
            "quantity": 1
        }
    ],
    "payment": {
        "transactionId": null,
        "cardNumber": "123456789101",
        "expirationDate": "20/03/2022",
        "flag": "VISA"
    },
    "totalPrice": 3200,
    "date": "23/03/2019",
    "status": "Em processamento"
}
----------------------------------------------------------------------------------------------------------------------------------
DELETE /orders/delete/39c0c48b-7836-4223-801d-18b9f819a3ac HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: fa66bdf1-72cb-1bac-68b4-69a9f8a43726
