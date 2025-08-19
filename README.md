# 🏥 Sistema de Gestión de Citas Médicas

## 📋 Descripción

Sistema web desarrollado en **Spring Boot** para la gestión integral de citas médicas. Permite a administradores, médicos y pacientes gestionar citas, historiales médicos y perfiles de usuario de manera eficiente y segura.

## ✨ Características Principales

### 🔐 Sistema de Autenticación
- Registro e inicio de sesión para diferentes tipos de usuario
- Control de acceso basado en roles (Admin, Médico, Paciente)
- Gestión segura de sesiones

### 👨‍⚕️ Gestión de Médicos
- Registro y perfil de médicos
- Visualización de citas asignadas
- Gestión de historiales médicos
- Panel de control personalizado

### 👥 Gestión de Pacientes
- Registro y perfil de pacientes
- Reserva de citas médicas
- Consulta de citas programadas
- Historial de citas anteriores

### 📅 Sistema de Citas
- Reserva de citas con médicos disponibles
- Gestión de horarios y disponibilidad
- Seguimiento del estado de las citas
- Historial completo de citas

### 👨‍💼 Panel de Administración
- Gestión de usuarios del sistema
- Administración de médicos y pacientes
- Supervisión general del sistema
- Estadísticas y reportes

## 🛠️ Tecnologías Utilizadas

- **Backend**: Spring Boot 3.5.4
- **Base de Datos**: MySQL 8.0
- **Frontend**: Thymeleaf + HTML + CSS + JavaScript
- **Java**: Versión 24
- **Build Tool**: Maven
- **ORM**: Hibernate/JPA
- **Arquitectura**: MVC (Model-View-Controller)

## 📁 Estructura del Proyecto

```
GestionCitas/
├── src/
│   ├── main/
│   │   ├── java/cibertec/edu/GestionCitas/
│   │   │   ├── Controller/          # Controladores MVC
│   │   │   ├── Entity/              # Entidades JPA
│   │   │   ├── Repository/          # Repositorios de datos
│   │   │   ├── Service/             # Lógica de negocio
│   │   │   └── GestionCitasApplication.java
│   │   └── resources/
│   │       ├── templates/           # Plantillas Thymeleaf
│   │       ├── static/              # Archivos estáticos
│   │       └── application.properties
│   └── test/                        # Pruebas unitarias
├── pom.xml                          # Configuración Maven
└── README.md
```

## 🚀 Requisitos Previos

- **Java 24** o superior
- **Maven 3.6+**
- **MySQL 8.0** o superior
- **IDE** (recomendado: IntelliJ IDEA, Eclipse, VS Code)

## ⚙️ Configuración e Instalación

### 1. Clonar el Repositorio
```bash
git clone https://github.com/CarloosssDev/GestionCitas.git
cd GestionCitas
```

### 2. Configurar Base de Datos
1. Crear base de datos MySQL:
```sql
CREATE DATABASE gestioncitas_db;
```

2. Configurar credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

### 3. Ejecutar el Proyecto
```bash
# Compilar y ejecutar
mvn spring-boot:run

# O alternativamente
mvn clean install
java -jar target/GestionCitas-0.0.1-SNAPSHOT.jar
```

### 4. Acceder a la Aplicación
- **URL**: http://localhost:8080
- **Puerto**: 8080 (configurable en application.properties)

## 🔧 Configuración de Desarrollo

### Variables de Entorno
- `spring.jpa.hibernate.ddl-auto=create-drop` (desarrollo)
- `spring.jpa.hibernate.ddl-auto=update` (producción)
- `spring.jpa.show-sql=true` (para debugging)

### Base de Datos
- **Driver**: MySQL Connector/J
- **Dialecto**: MySQL8Dialect
- **DDL**: Auto-generación de tablas

## 📱 Funcionalidades por Rol

### 👨‍💼 Administrador
- Gestión completa de usuarios
- Administración de médicos y pacientes
- Supervisión del sistema
- Reportes y estadísticas

### 👨‍⚕️ Médico
- Visualización de citas asignadas
- Gestión de historiales médicos
- Perfil profesional
- Panel de control médico

### 👥 Paciente
- Reserva de citas médicas
- Consulta de citas programadas
- Perfil personal
- Historial de citas

## 🧪 Pruebas

```bash
# Ejecutar pruebas unitarias
mvn test

# Ejecutar pruebas con cobertura
mvn jacoco:report
```

## 📦 Despliegue

### Desarrollo Local
```bash
mvn spring-boot:run
```

### Producción
```bash
mvn clean package
java -jar target/GestionCitas-0.0.1-SNAPSHOT.jar
```

## 🔒 Seguridad

- Autenticación basada en sesiones
- Control de acceso por roles
- Validación de formularios
- Protección contra inyección SQL

## 🚀 Recomendaciones y Mejoras Futuras

### 🔌 Implementación de API REST
- **Desarrollo de API REST** para integración con aplicaciones móviles
- **Endpoints para gestión de citas** (GET, POST, PUT, DELETE)
- **Autenticación JWT** para mayor seguridad en APIs
- **Documentación con Swagger/OpenAPI**

### 📊 Funcionalidades Adicionales
- **Cambio de estado de citas** (Programada, En curso, Completada, Cancelada)
- **Sistema de notificaciones** (email, SMS) para recordatorios de citas
- **Dashboard con estadísticas** y métricas del sistema
- **Reportes exportables** en PDF/Excel
- **Calendario integrado** para visualización de disponibilidad
- **Sistema de pagos** para citas privadas
- **Historial médico completo** con archivos adjuntos
- **Chat en tiempo real** entre médico y paciente

### 🎨 Mejoras de UX/UI
- **Interfaz responsive** para dispositivos móviles
- **Tema oscuro/claro** configurable
- **Notificaciones push** en el navegador
- **Búsqueda avanzada** con filtros múltiples
- **Paginación** para listas largas de datos

## 📊 Base de Datos

### Entidades Principales
- **Usuario**: Información de autenticación
- **Médico**: Perfil profesional médico
- **Paciente**: Información del paciente
- **Cita**: Programación de citas médicas
- **Historial**: Registros médicos

## 🐛 Solución de Problemas

### Problemas Comunes
1. **Error de conexión a MySQL**: Verificar credenciales y estado del servicio
2. **Puerto ocupado**: Cambiar `server.port` en application.properties
3. **Error de compilación**: Verificar versión de Java (requiere Java 24+)

### Logs
- Los logs de SQL se muestran en consola (configurable)
- Logs de Spring Boot disponibles en la consola

## 🤝 Contribución

1. Fork del proyecto
2. Crear rama para nueva funcionalidad
3. Commit de cambios
4. Push a la rama
5. Crear Pull Request

## 📄 Licencia

Este proyecto está bajo la licencia **MIT License** - ver el archivo [LICENSE](LICENSE) para más detalles.

### ¿Por qué MIT License?

La licencia MIT es ideal para proyectos educativos porque:
- ✅ **Permite uso comercial** y personal
- ✅ **Permite modificación** y distribución
- ✅ **Requiere solo atribución** al autor original
- ✅ **Es compatible** con la mayoría de licencias
- ✅ **Es simple** y fácil de entender
- ✅ **Es ampliamente aceptada** por la comunidad open source

## 👨‍💻 Desarrolladores

- [CarloosssDev](https://github.com/CarloosssDev) - jose280207carlos@gmail.com

## 📞 Soporte

Para soporte técnico o consultas:
- **Email**: jose280207carlos@gmail.com
- **Issues**: [https://github.com/CarloosssDev/GestionCitas/issues](https://github.com/CarloosssDev/GestionCitas/issues)

## 🔄 Versiones

- **v0.0.1-SNAPSHOT**: Versión actual en desarrollo

---

**Nota**: Este es un proyecto educativo desarrollado para el curso de Desarrollo de Aplicaciones Web Integradas (DAWI) en Cibertec.
