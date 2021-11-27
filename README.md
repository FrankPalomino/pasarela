# pasarela
Análisis de pasarela de pago

# Descripción
Este es un proyecto desarrollado para el Hackathon de Barcelona Digital Talent. Se trata de una API REST que registra producto a vender, los tickets de cada venta y el análisis de estos ticket.

# Tecnología utilizada
La tecnología que se ha utilizado para desarrollar esta aplicación es Spring Boot, debido a su facilidad de utilización y lo adecuadamente diseñado para la función demandada.

# Distribución de carpetas
La carpeta principal de la aplicación es la de "pasarela" encontrada en el paquete com.main.pasarela. Dentro de esta encontramos los diferentes paquetes, como son "controllers", "entities", "repositories" y "utils".
En controllers encontramos definidos los diferentes controladores para las diferentes funciones de la aplicación, como son el ProductController, TicketController y AnalyticsControlles.
En la carpeta "entities" encontramos definidas las clases que se utilizan en la aplicación: "Product", "Ticket", "PaymentType", "ProductType" y "Analytics".
En la carpeta Repositories se encuentran las clases de acceso a base de datos.

# Base de datos
Para una mejor prueba de la aplicación se ha utilizado una base de datos imbuida, en este caso la base de datos H2, está se inicializa gracias a la clase LoadDatabase con datos sobre ProductTypes y PaymentTypes.
El acceso a esta base de datos se encuentra definido en el archivo application.properties.
Los Product_Type son:
| ID | TYPE |
| -- | -- |
| 1 | LAPTOPS |
| 2 | PCS |
| 3 | PHONES |
| 4 | TABLETS |
| 5 | OTHER |

Los Payment_type son:
| ID | TYPE |
| -- | -- |
| 1 | VISA |
| 2 | MASTERCARD |

# EndPoints
El programa consta de 2 principales endpoints
## Product
Este endpoint nos permite:
### GET "/product"
Nos devuelve una lista con todos los productos en la base de datos.
### POST "/product"
Nos permite guardar un producto, en este caso necesitamos enviarle en el body de la petición un archivo json con lo siguientes datos
```json
{
"name":"String",
"price":400,
"description":"Este producto es muy guay",
"productType":{"id":3}
}
```
### DELETE "/product/{id}"
Con este endpoint eliminamos un producto donde id es el número de id del producto, por ejemplo "/product/1"

### PUT "/product/{id}"
Finalmente también podemos editar un producto, en el endpoint pondremos el id del producto a editar y en el body de la petición pondremos un json parecido al de crear un producto en el cual indicaremos los nuevos valores.

## Ticket
Este endpoint nos permite:
### GET "/ticket"
Nos devuelve una lista con todos los tickets en la base de datos.
### POST "/ticket"
Nos permite guardar un ticket, en este caso necesitamos enviarle en el body de la petición un archivo json con lo siguientes datos
```json
{
"amount":5,
"product":{"id":1},
"paymentType":{"id":1}
}
```
### DELETE "/ticket/{id}"
Con este endpoint eliminamos un ticket donde id es el número de id del producto, por ejemplo "/ticket/1"

### GET "/ticket/analytics"
Finalmente tenemos el apartado de analytics, el cual tiene un controlador separado debido a que requiere un poco más de complejidad.

# Instalación
Para su instalación solo se requiere tener Java 11 instalado en el ordenador o contenedor.
