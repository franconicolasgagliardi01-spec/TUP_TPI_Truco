# Trabajo Práctico Final: Baraja de Cartas Españolas y Aplicación de Juego utilizando ArrayList

## Materia
Programación II - POO (Tecnicatura Universitaria en Programación - UTN FRM)

## Integrantes
* Franco Gagliardi
* Ramiro Quiroga
* Ciro Cattáneo

---

## Ubicación del Proyecto y Consignas
* El Trabajo Práctico se encuentra desarrollado en esta sección. Las consignas completas proporcionadas por el profesor se encuentran en la siguiente carpeta: [Acceder al TP en Google Drive](https://drive.google.com/drive/folders/1vv5Y_8KEqxxDpxvloJoG1gTVVaLVmSOr)

---

## Descripción General
El objetivo de este proyecto integrado es diseñar e implementar una aplicación en Java aplicando el paradigma de **Programación Orientada a Objetos (POO)** y la reutilización de código. El desarrollo se estructuró en dos etapas complementarias:

* **Parte 1 (Estructura Base):** Modelado de una Baraja Española de 40 cartas (números del 1 al 12, excluyendo 8 y 9) utilizando colecciones dinámicas (`ArrayList`) para la gestión eficiente del mazo, encapsulando la lógica interna de manipulación de naipes.
* **Parte 2 (Extensión y Juego Completo):** Reutilización y extensión de los componentes de la primera etapa para implementar un sistema de juego real interactivo por consola. El equipo ha seleccionado el **Truco Simplificado**, estructurando la lógica necesaria para representar el flujo de las partidas, sus participantes y el cumplimiento de sus reglas.

---

## Funcionalidades e Implementación

### Componentes de la Baraja (Fase 1)
* **Mezclar/Barajar:** Reorganización aleatoria del mazo de cartas.
* **Flujo de Naipes:** Obtención de la siguiente carta disponible y control del pozo/descarte.
* **Contabilidad:** Consulta en tiempo real de las cartas restantes en la baraja.
* **Distribución:** Reparto dinámico de una cantidad determinada de cartas.

### Lógica del Juego: Truco Simplificado (Fase 2)
* **Flujo de Partida:** Control de una partida completa estructurada a través de un menú interactivo por consola.
* **Mesa y Manos:** Gestión de los turnos de juego, el reparto de naipes y las cartas jugadas en cada instancia utilizando estructuras basadas en `ArrayList`.
* **Resolución de Jugadas:** Implementación de la jerarquía de valores de las cartas según las reglas acordadas del Truco para evaluar los enfrentamientos de cada ronda.
* **Determinación del Ganador:** Control de los puntajes y asignación de la victoria al finalizar las condiciones del partido.

---

## Arquitectura y Diseño de Software
Para cumplir con los criterios de evaluación, el diseño del software se enfoca en los siguientes pilares:
* **Reutilización:** Uso directo de las clases base de la primera etapa (`Carta` y `Baraja`).
* **Modularidad:** Incorporación de nuevas clases destinadas a fragmentar las responsabilidades del juego (entidades para los participantes, la mesa de juego, el control de turnos, las reglas y la contabilidad de puntos).
* **Patrones de Diseño:** Análisis técnico de patrones arquitectónicos o de comportamiento que optimicen la estructura y el flujo de la aplicación.

---

## Entregables del Grupo
1. **Documento PDF Principal:** * Identificación de los integrantes y el Capitán del equipo.
   * Respuestas detalladas al **Análisis de Diseño** planteado en la consigna.
   * **Diagrama de Clases UML actualizado** que refleje la integración final del sistema.
   * Análisis y justificación de los Patrones de Diseño evaluados.
   * Capturas de pantalla de la ejecución y conclusión técnica del equipo.
2. **Código Fuente:** Proyecto Java completo, organizado de forma limpia en paquetes, documentado y ejecutable mediante un menú interactivo por consola.

---

## Criterios de Evaluación Considerados
* Reutilización correcta de Carta y Baraja (15 pts)
* Modelado de nuevas clases (15 pts)
* Implementación de reglas del juego (20 pts)
* Funcionamiento de la partida y menú por consola (15 pts)
* Uso correcto de `ArrayList` en colecciones (5 pts)
* Análisis de patrones de diseño (5 pts)
* Documentación y presentación del PDF/UML (25 pts)

---
**Fecha límite de entrega:** Lunes 22 de Junio de 2026  
*Entrega a cargo del Capitán del Equipo a través del Aula Virtual.*