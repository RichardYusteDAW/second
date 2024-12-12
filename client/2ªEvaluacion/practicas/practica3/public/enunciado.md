# <span style="color: blue;">PRACTICA 3</span>

## 1. Añadir Bootstrap a nuestro proyecto 🎨
- Buscar información de cómo añadir y configurar Bootstrap para poder utilizarlo conAngular.
`npm install bootstrap`

---
<br>

## 2. Trabaja con Angular CLI: Interfaces y Componentes 🛠️
- Vamos a trabajar con artículos que tengan un id, nombre, descripción, unidades y precio.
- Para ello nos definiremos una interface llamada Articulo, usaremos una carpeta dentro del proyecto para las interfaces llamada Modelos.
```typescript
// 1º Creamos la carpeta modelos en src/app

// 2º Creamos el fichero Articulo.ts en src/app/modelos
export interface Articulo {
    id: number;
    nombre: string;
    descripcion: string;
    unidades: number;
    precio: number;
}
```

---
<br>

## 3. Tipado y Mock de datos 📝
- Como vamos a trabajar con muchos artículos definir un array de los datos que vamos a usar dentro de ese fichero.
- Como vamos a utilizar esos datos en nuestros componentes deberemos exportar el array.
- Los datos a utilizar están en el fichero de recursos de la práctica, es un fichero llamado articulos.json.
- En esa carpeta también están guardadas las fotos de cada artículo, cada foto es un fichero jpg con el nombre del id de cada artículo.

---
<br>

## 4. El Data Binding 📡
- Crear un componente llamado artículos dentro de la carpeta Components.
- Una vez creado el componente artículos interpolar en un card de Bootstrap un artículo para mostrar, por ejemplo, probar con el artículo 3.
- Añadir un botón para comprar que cuando lo pulsemos nos muestre por consola que hemos comprado ese articulo

---
<br>

### 4.1. Comprar artículos con unidades 🛒
- Hacer que el botón de comprar este deshabilitado si el número de unidades del artículo es 0. 
- Como el artículo 3 no tiene unidades no se podrá comprar porque el botón estará desactivado.

---
<br>

### 4.2. Seleccionar el artículo 🖼️
- Añadir un cuadro de texto para que podamos introducir el código del artículo que queramos visualizar y al pulsar en un botón que se vea ese artículo. 
- Si el artículo no existe que muestre un error.

---
<br>

### 4.3. Modificar las unidades 📦
- Añadir dos botones al final del card para poder aumentar o disminuir el número de unidades del artículo que se muestra.