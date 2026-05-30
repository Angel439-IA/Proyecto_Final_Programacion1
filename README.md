# Sistema de Administración de Condominio "Vista Verde"

## Descripción del proyecto

El Sistema de Administración de Condominio "Vista Verde" es una aplicación de escritorio desarrollada en Java que permite administrar de forma organizada un conjunto de casas dentro de un condominio.

El sistema está diseñado para apoyar al administrador en el control de propietarios, registro de pagos de cuota, configuración del monto mensual, consulta de estados de cuenta, generación de reportes generales y detección de casas morosas.

El proyecto fue desarrollado como parte del curso de Programación I, aplicando conceptos de programación orientada a objetos, interfaces gráficas con Java Swing, conexión a base de datos, control de versiones con GitHub y organización del trabajo en equipo.

## Contexto del condominio

- Nombre del condominio: Vista Verde
- Cantidad de casas: 30 casas
- Cuota mensual inicial: Q1,500.00
- Tipo de sistema: aplicación de escritorio
- Usuario principal: administrador del condominio

## Tecnologías utilizadas

- Java
- Java Swing
- NetBeans
- SQLite
- Maven
- GitHub
- Jira

## Funcionalidades principales

### Login del administrador

Permite el acceso al sistema únicamente al administrador del condominio mediante usuario y contraseña.

### Pantalla de inicio

Muestra el menú principal del sistema, el listado general de propietarios y los botones de acceso a los diferentes módulos.

### Registro de propietarios

Permite registrar propietarios con su nombre, apellido, número de casa, teléfono y correo electrónico. El sistema evita que dos propietarios sean registrados en la misma casa.

### Registro de pago de cuota

Permite registrar el pago mensual de una casa seleccionando número de casa, mes, año, fecha de pago y monto correspondiente. El sistema valida los pagos para evitar registros duplicados.

### Configuración de cuota

Permite modificar el monto actual de la cuota de mantenimiento. El nuevo monto se aplica para los pagos registrados a partir de ese momento.

### Estado de cuenta por casa

Permite consultar los pagos realizados por una casa específica, mostrando el nombre del propietario, los meses pagados, el estado del pago y el total pagado.

### Reporte general

Muestra un resumen general de las casas registradas, incluyendo propietario, teléfono, correo, estado del mes actual, monto pagado y fecha de pago. También muestra totales como el total recaudado, el total esperado y el pendiente por recaudar.

### Casas morosas

Permite consultar las casas que no han realizado el pago correspondiente, mostrando el número de casa, propietario y teléfono para facilitar el contacto.

## Capturas de pantalla

### Login del administrador

![Login del administrador](src/main/resources/IMGreadme/Login.png)

### Pantalla de inicio

![Pantalla de inicio](src/main/resources/IMGreadme/Home.png)

### Registro de propietarios

![Registro de propietarios](src/main/resources/IMGreadme/Regpropietarios.png)

### Registro de pago de cuota

![Registro de pago de cuota](src/main/resources/IMGreadme/Regcuota.png)

### Configuración de cuota

![Configuración de cuota](src/main/resources/IMGreadme/Configcouta.png)

### Notificación de actualización de cuota

![Notificación de configuración de cuota](src/main/resources/IMGreadme/Noticonfigcuota.png)

### Estado de cuenta por casa

![Estado de cuenta por casa](src/main/resources/IMGreadme/Estadodecuentaporcasa.png)

### Reporte general

![Reporte general](src/main/resources/IMGreadme/Repgeneral.png)

### Casas morosas

![Casas morosas](src/main/resources/IMGreadme/Repcasasmororsas.png)

### Notificación de edición de propietario

![Notificación de edición de propietario](src/main/resources/IMGreadme/Notiregpropietarios.png)

## Instrucciones para ejecutar el proyecto

### Opción 1: Ejecutar desde NetBeans

1. Descargar o clonar el repositorio desde GitHub.
2. Abrir NetBeans.
3. Seleccionar la opción de abrir proyecto.
4. Buscar la carpeta del proyecto `VistaVerde`.
5. Verificar que las dependencias de Maven se carguen correctamente.
6. Ejecutar la clase principal del sistema.
7. Iniciar sesión con las credenciales del administrador.

### Opción 2: Ejecutar mediante archivo .exe

1. Descargar el proyecto o la carpeta donde se encuentra el ejecutable.
2. Buscar el archivo `.exe` del sistema.
3. Ejecutar el archivo.
4. Iniciar sesión con las credenciales del administrador.

## Credenciales de acceso

```text
Usuario: iusr_vistaverde
Contraseña: R3sidencial2026%
```

## Estructura del proyecto
VistaVerde/
├── src/
│   └── main/
│       ├── com.vistaverde.vistaverde/   # Punto de entrada y configuración de íconos
│       │   ├── VistaVerde.java
│       │   └── VistaVerdeIconos.java
│       │
│       ├── logic/                       # Lógica de negocio y acceso a datos
│       │   ├── ConexionDB.java
│       │   ├── ConfiguracionCuotaDB.java
│       │   ├── EmailSender.java
│       │   ├── MorososDB.java
│       │   ├── PagoDB.java
│       │   ├── PropietariosDB.java
│       │   ├── Sesion.java
│       │   └── Validaciones.java
│       │
│       ├── model/                       # Modelos / entidades del dominio
│       │   ├── Casa.java
│       │   ├── Condominio.java
│       │   └── Pago.java
│       │   └── Propietario.java
│       │
│       └── ui/                          # Interfaces gráficas (vistas)
│           ├── CasasMorosas.java
│           ├── ConfiguracionCuota.java
│           ├── EstadoDeCuenta.java
│           ├── Estadocuenta.java
│           ├── Inicio.java
│           ├── Login.java
│           ├── Propietarios.java
│           ├── Registro_de_cuota.java
│           └── Rep_general.java
│
└── resources/
    ├── IMGreadme/
    └── Iconos/
    └── Imagenes
```

## Base de datos

El sistema utiliza SQLite como base de datos local para almacenar la información relacionada con casas, propietarios y pagos. Esto permite conservar los datos aunque el programa sea cerrado y abierto nuevamente.

## Gestión del proyecto

El proyecto fue trabajado usando GitHub para el versionamiento del código y Jira para la organización de tareas del equipo.

Link del tablero de Jira:
https://equipoprogra1.atlassian.net/jira/software/projects/SCRUM/boards/1

## Integrantes del equipo

| Nombre | Carné | Rol |
|--------|-------|-----|
| Jenner Alberto Vasquez Barrios | 0900-25-18899 | Integrante del equipo |
| Angel Emanuel Sotoy Pelicó | 0900-24-19016 | Integrante del equipo |
| Rudy Danilo Perebal Velasquez | 0900-25-6398 | Integrante del equipo |
| Naomi Patricia de León Xulú | 0900-25-26143 | Integrante del equipo |
| César Luis Aguilón Pascual | 0900-25-2730 | Integrante del equipo |

## Estado del proyecto

Proyecto académico desarrollado como entrega final del curso de Programación I.

## Autoría

Sistema desarrollado por el equipo de trabajo del proyecto final de Programación I.
