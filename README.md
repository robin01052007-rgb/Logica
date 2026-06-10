# DOCUMENTACIÓN LÓGICA
MÓDULO DE LÓGICA DE ACCESO Y VALIDACIÓN
Descripción General
El módulo de Lógica de Acceso y Validación es el encargado de gestionar el proceso de autenticación dentro del sistema de control de acceso. Su función principal consiste en verificar si la secuencia numérica ingresada por el usuario coincide con el patrón autorizado almacenado en el sistema.
Este módulo actúa como el núcleo de toma de decisiones del proyecto, coordinando la interacción entre los dispositivos de hardware, la base de datos y el sistema de reportes. Además, implementa mecanismos de seguridad que limitan el número de intentos permitidos para evitar accesos no autorizados.

Clase ControlAcceso
Descripción
La clase ControlAcceso representa la clase principal del sistema y constituye el punto de entrada de la aplicación. Su responsabilidad es coordinar todo el proceso de autenticación, desde la detección de movimiento hasta la generación de reportes y el almacenamiento de eventos.
Esta clase integra componentes desarrollados por los distintos equipos del proyecto, permitiendo la comunicación entre el hardware, la lógica de validación, la base de datos y el dashboard de reportes.

Funcionalidades Principales
Detectar movimiento mediante un sensor PIR.
Solicitar una contraseña de siete dígitos.
Capturar los valores ingresados desde el teclado físico.
Validar la contraseña utilizando el patrón registrado.
Activar indicadores visuales de acceso permitido o denegado.
Registrar eventos en la base de datos.
Generar información para reportes estadísticos.
Bloquear el sistema después de tres intentos fallidos consecutivos.
Componentes Utilizados

Hardware
SensorPir: Detecta la presencia de personas mediante movimiento.
Boton: Simula el teclado físico utilizado para introducir la contraseña.
Led: Proporciona retroalimentación visual sobre el resultado de la autenticación.

Base de Datos
ConexionBd: Gestiona la conexión con la base de datos.
ConsultaBd: Ejecuta operaciones de almacenamiento de eventos.
Dashboard y Reportes
Dashboard: Analiza los eventos registrados y genera reportes.
ReporteEventos: Representa cada evento almacenado para análisis posterior.

Funcionamiento
Al iniciar el sistema, se establece la conexión con la base de datos y se espera la detección de movimiento mediante el sensor PIR.
Una vez detectada la presencia de un usuario, el sistema solicita una contraseña de siete dígitos. Cada número ingresado es capturado mediante el teclado físico y almacenado temporalmente para formar la secuencia completa.
Posteriormente, la secuencia capturada es encapsulada en un objeto de tipo IntentoAcceso y enviada al módulo de validación.
Si la contraseña coincide con el patrón correcto:
Se concede el acceso.
Se activa el LED indicador.
Se registra el evento en la base de datos.
Se almacena el evento para el dashboard.
Si la contraseña es incorrecta:
Se reduce el número de intentos disponibles.
El LED parpadea para indicar error.
Se registra el intento fallido.
Cuando se alcanzan tres intentos fallidos consecutivos, el sistema se bloquea y registra el evento correspondiente.
Finalmente, todos los eventos generados durante la ejecución son enviados al dashboard para su análisis y generación de reportes.

Clase IntentoAcceso
Descripción
La clase IntentoAcceso representa un intento de autenticación realizado por un usuario. Su objetivo es almacenar la secuencia numérica capturada durante el proceso de ingreso al sistema.
Esta clase permite encapsular la información relacionada con la contraseña introducida, facilitando su posterior validación.
Atributos
secuenciaIngresada
Variable de tipo entero que almacena la secuencia numérica introducida por el usuario durante un intento de acceso.
Constructor
IntentoAcceso(int secuencia)
Recibe como parámetro la secuencia capturada durante el proceso de autenticación y la almacena dentro del objeto.
Este constructor permite crear una representación estructurada de cada intento realizado por un usuario.
Métodos
getSecuenciaIngresada()
Devuelve la secuencia almacenada dentro del objeto.
Este método es utilizado por las clases encargadas de la validación para comparar la contraseña ingresada con el patrón autorizado.

Clase PatronAcceso
Descripción
La clase PatronAcceso representa el patrón válido de autenticación del sistema.
Su función principal es almacenar la secuencia correcta que debe ingresar un usuario para obtener acceso autorizado.
Esta clase actúa como referencia durante el proceso de validación, proporcionando la contraseña registrada dentro del sistema.
Atributos
secuenciaCorrecta
Variable de tipo entero que almacena la contraseña válida configurada en el sistema.
Actualmente la secuencia autorizada es:
2311321
Métodos
getSecuenciaCorrecta()
Devuelve la secuencia correcta almacenada.
Este método es utilizado por la clase de validación para comparar la contraseña ingresada por el usuario con la contraseña autorizada.

Integración Dentro del Proyecto
El módulo de Lógica de Acceso y Validación funciona como enlace entre los diferentes componentes del sistema.
La interacción entre módulos se realiza de la siguiente manera:
1-El hardware detecta la presencia de un usuario.
2-El usuario introduce una contraseña mediante el teclado físico.
3-La clase IntentoAcceso almacena la secuencia ingresada.
4-La clase PatronAcceso proporciona la secuencia autorizada.
5-La validación determina si ambas secuencias coinciden.
6-El resultado activa los indicadores visuales correspondientes.
7-El evento se almacena en la base de datos.
8-La información se envía al dashboard para la generación de reportes.

Conclusión
El módulo de Lógica de Acceso y Validación constituye la parte central del sistema de control de acceso desarrollado para Raspberry Pi 5. Mediante la implementación de clases especializadas y el uso de Programación Orientada a Objetos, se logró diseñar una solución modular capaz de autenticar usuarios, registrar eventos y coordinar la comunicación con el resto de los componentes del proyecto. Su estructura facilita el mantenimiento, la escalabilidad y la integración con futuros mecanismos de seguridad.
