# Proyecto de Gestión de Empresas y Transferencias

Este proyecto es una aplicación de Spring Boot que gestiona empresas y sus transferencias. Utiliza MongoDB como base de datos y Maven como herramienta de construcción.

## Características

- Registro de empresas
- Registro de transferencias
- Consulta de empresas con transferencias en el último mes
- Consulta de empresas adheridas en el último mes

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- MongoDB

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/LVSMix/challenge_it_patagonia
   cd challenge_it_patagonia
   ```

2. Configura la conexión a MongoDB en el archivo `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/itpatagonia
   ```

3. Construye el proyecto con Maven:
   ```bash
   mvn clean install
   ```

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```
5. Ojo para ejecutar los test y para que la aplicacion funcione correctamente se tiene que ejecutar
   el archivo `docker-compose.yml` que se encuentra en la raiz del proyecto.
  ```bash
   docker-compose up 
  ```


## Endpoints

### EmpresaController

- **GET /empresas/transferencias-mes**: Obtiene las empresas con transferencias en el último mes.
- **GET /empresas/adhesiones-mes**: Obtiene las empresas adheridas en el último mes.
- **POST /empresas/adhesion**: Adhiere una nueva empresa.

### TransferenciaController

- **POST /transferencias**: Registra una nueva transferencia.

## Ejemplos de Uso

### Registrar una Empresa

```bash
curl -X POST http://localhost:8080/empresas/adhesion -H "Content-Type: application/json" -d '{
  "cuit": "123456789",
  "nombre": "Empresa Ejemplo",
  "fechaAdhesion": "2023-10-01"
}'
```

### Registrar una Transferencia

```bash
curl -X POST http://localhost:8080/transferencias -H "Content-Type: application/json" -d '{
  "idEmpresa": "123456789",
  "importe": 1000.00,
  "cuentaDebito": "123-456-789",
  "cuentaCredito": "987-654-321",
  "fechaTransferencia": "2023-10-15"
}'
```

### Obtener Empresas con Transferencias en el Último Mes

```bash
curl http://localhost:8080/empresas/transferencias-mes
```

### Obtener Empresas Adheridas en el Último Mes

```bash
curl http://localhost:8080/empresas/adhesiones-mes
```

## Estructura del Proyecto

- `src/main/java/org/example/challenge/it/patagonia/application/services`: Servicios de la aplicación.
- `src/main/java/org/example/challenge/it/patagonia/domain/model`: Modelos de dominio.
- `src/main/java/org/example/challenge/it/patagonia/infraestructure/controllers`: Controladores REST.
- `src/main/java/org/example/challenge/it/patagonia/infraestructure/repository`: Repositorios de MongoDB.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
```

