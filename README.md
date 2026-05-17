# 💾 Simulador de Administración de Memoria - First Fit

## 📌 Descripción

Este proyecto simula la administración de memoria de un sistema operativo utilizando el algoritmo **First Fit (Primer Ajuste)** y **partición dinámica**.  

La aplicación fue desarrollada en **Java con Swing**, permitiendo visualizar gráficamente la asignación y liberación de memoria en tiempo real mediante una interfaz moderna e interactiva.

---

# 🚀 Características

✅ Algoritmo First Fit  
✅ Partición dinámica real  
✅ Compactación de memoria  
✅ Liberación de bloques  
✅ Barra de progreso de memoria  
✅ Porcentaje de uso de memoria  
✅ Estadísticas en tiempo real  
✅ Historial de procesos  
✅ Interfaz gráfica moderna  
✅ Dark Mode 🌙  
✅ Colores modernos estilo Windows 11/macOS  
✅ Reinicio de simulación  
✅ Menú superior  
✅ Visualización de bloques libres y ocupados  

---

# 🖥️ Tecnologías utilizadas

- Java
- Java Swing
- Programación Orientada a Objetos (POO)

---

# ⚙️ Funcionamiento

La simulación genera bloques de memoria aleatorios y permite crear procesos indicando el tamaño de memoria requerido.

El sistema utiliza:

## 🧠 First Fit

Busca el primer bloque libre con espacio suficiente para almacenar el proceso.

## 📦 Partición Dinámica

Si un bloque libre es más grande que el proceso solicitado, el bloque se divide automáticamente:

Ejemplo:

```text
Bloque libre: 100 MB
Proceso: 40 MB

Resultado:
[40 MB ocupado] [60 MB libre]
```
