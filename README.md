# parcial3
# 🏡 Sistema de Control Domótico Inteligente — Parcial 3

Sistema de simulación y gestión de dispositivos domóticos desarrollado en **Java** con interfaz gráfica en **JavaFX**. El proyecto implementa una arquitectura modular **MVC (Modelo-Vista-Controlador)** junto con **5 patrones de diseño de software** para garantizar un sistema desacoplado, escalable y mantenible.

---

## 📋 Tabla de Contenidos
- [Tecnologías y Herramientas](#-tecnologías-y-herramientas)
- [Arquitectura del Sistema](#-arquitectura-del-sistema)
- [Patrones de Diseño Implementados](#-patrones-de-diseño-implementados)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Funcionalidades Principales](#-funcionalidades-principales)
- [Instrucciones de Ejecución](#-instrucciones-de-ejecución)
- [Autores](#-autores)

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje de Programación:** Java 17+
* **Interfaz Gráfica:** JavaFX (FXML, Scene Builder)
* **Gestor de Dependencias y Construcción:** Maven
* **Entorno de Desarrollo (IDE):** IntelliJ IDEA
* **Control de Versiones:** Git & GitHub / GitHub Desktop

---

## 🏛️ Arquitectura del Sistema

El proyecto sigue el patrón arquitectónico **MVC (Modelo-Vista-Controlador)** para separar la lógica de negocio, la presentación visual y la gestión de eventos:

* **Modelo:** Contiene las entidades principales como `Dispositivo`, `Habitacion`, `Cerradura`, `Luz`, `Termostato` y la lógica de los patrones de diseño.
* **Vista:** Archivos FXML (`inicio.fxml`, `cerraduras.fxml`) definidos para una interfaz gráfica intuitiva y reactiva.
* **Controlador:** Clases `InicioController` y `CerradurasController` que capturan las interacciones del usuario, coordinan la lógica entre pantallas y actualizan los componentes visuales.

---

## 🎨 Patrones de Diseño Implementados

Para dar cumplimiento estricto a los requerimientos académicos del curso, se integraron **5 patrones de diseño**:

### 1. Command (Comando)
Encapsula las solicitudes de control sobre las cerraduras (`BloquearCerraduraCommand`, `DesbloquearCerraduraCommand`, `ReiniciarCerraduraCommand`) como objetos independientes.
* **Utilidad:** Facilita la parametrización de peticiones y permite mantener un historial interactivo con soporte para operaciones de **Deshacer (Undo)** y **Rehacer (Redo)**.

### 2. State (Estado)
Representa los estados operativos cambiantes de las cerraduras inteligetes (p. ej., *Bloqueado*, *Desbloqueado*, *Intento Fallido*, *Alarma Activa*).
* **Utilidad:** Evita el uso excesivo de condicionales anidados (`if/else`) delegando el comportamiento específico a cada clase de estado.

### 3. Strategy (Estrategia)
Define una familia de algoritmos interconectados para el control térmico de los termostatos (como el modo de ahorro energético `EcoStrategy`).
* **Utilidad:** Permite intercambiar el comportamiento o la regla de climatización del termostato en tiempo de ejecución sin modificar su estructura base.

### 4. Observer (Observador)
Establece una relación de dependencia uno-a-muchos entre los dispositivos del hogar y los paneles de notificación.
* **Utilidad:** Notifica a la interfaz gráfica en tiempo real cuando un dispositivo cambia su estado (encendido, apagado, alerta), garantizando la sincronización del panel de eventos.

### 5. Mediator (Mediador)
Centraliza las comunicaciones entre las diferentes habitaciones y sus dispositivos asociados.
* **Utilidad:** Evita que los dispositivos se comuniquen o dependan directamente entre sí, reduciendo drásticamente el acoplamiento del sistema.

## Funcionalidades Principales

# Gestión de Habitaciones y Dispositivos:

### Selección dinámica en listViewHabitaciones y listViewDispositivos.

# Seguridad y Control de Cerraduras:

### Autenticación de PIN, contador de intentos fallidos, bloqueo preventivo e historial de comandos (Undo/Redo).

# Panel de Registro de Eventos en Tiempo Real:

### Componente TxtEventos que captura e imprime logs detallados de interacción con Luces, Sensores y Termostatos.

# Puente de Comunicación entre Controladores:

### Transferencia transparente de instancias entre InicioController y CerradurasController mediante loader.getController().


Pasos

Clona este repositorio localmente:
git clone https://github.com/ivandrinconb/parcial3.git

Abre el proyecto en IntelliJ IDEA.

Asegurate de sincronizar las dependencias de Maven (Reload All Maven Projects).

Ejecuta la aplicacion desde la terminal del proyecto con:
mvn clean javafx:run
O ejecuta directamente la clase Main.java desde IntelliJ.
