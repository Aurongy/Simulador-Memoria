# Simulador de Administración de Memoria - First Fit

## Descripción

Este proyecto simula la administración de memoria de un sistema operativo utilizando el algoritmo **First Fit (Primer Ajuste)** y **partición dinámica**.  

La aplicación fue desarrollada en **Java con Swing**, permitiendo visualizar gráficamente la asignación y liberación de memoria en tiempo real mediante una interfaz moderna e interactiva.

---

# Características

✅ Algoritmo First Fit  
✅ Partición dinámica real  
✅ Compactación de memoria  
✅ Liberación de bloques  
✅ Barra de progreso de memoria  
✅ Porcentaje de uso de memoria  
✅ Estadísticas en tiempo real  
✅ Historial de procesos  
✅ Interfaz gráfica
✅ Visualización de bloques libres y ocupados 

---

# Tecnologías utilizadas

- Java
- Java Swing
- Programación Orientada a Objetos (POO)

---

# Funcionamiento

La simulación genera bloques de memoria aleatorios y permite crear procesos indicando el tamaño de memoria requerido.

El sistema utiliza:

## First Fit

Busca el primer bloque libre con espacio suficiente para almacenar el proceso.

## Partición Dinámica

Si un bloque libre es más grande que el proceso solicitado, el bloque se divide automáticamente:

Ejemplo:

```text
Bloque libre: 100 MB
Proceso: 40 MB

Resultado:
[40 MB ocupado] [60 MB libre]
```

# 📷 Capturas del sistema

## 🟢 Memoria inicial

<img width="1470" height="743" alt="image" src="https://github.com/user-attachments/assets/a27f70db-b936-4432-adc8-a5247f13d864" />


---

## 🔴 Procesos agregados

<img width="1455" height="711" alt="image" src="https://github.com/user-attachments/assets/113247f4-def2-42ea-89e6-6ad4da61d991" />


---

## ⚠️ Error por falta de espacio

<img width="1455" height="727" alt="image" src="https://github.com/user-attachments/assets/5427c04c-6d10-490f-80a9-c7ac001b665c" />

