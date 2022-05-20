
document.getElementById("nombre").addEventListener("blur", comprobarNombre);
document.getElementById("marca").addEventListener("blur", comprobarMarca);
document.getElementById("imagen").addEventListener("blur", comprobarImagen);
document.getElementById("fechaLiquidacion").addEventListener("blur", comprobarFechaLiquidacion);
document.getElementById("precio").addEventListener("blur",comprobarPrecio);
document.getElementById("uds").addEventListener("blur", comprobarUnidades);
document.getElementById("formulario").addEventListener("submit",revisarFormulario);

function revisarFormulario(){
	let resultado = false;

	resultado = comprobarNombre()&&
				comprobarMarca()&&
				comprobarImagen()&&
				comprobarFechaLiquidacion()&&
				comprobarPrecio()&&
				comprobarUnidades();
	

	formulario.enviar.className = resultado?"btn btn-success mb-2":"btn btn-danger mb-2";

	return resultado; 
	
	}


function comprobarNombre() {

	let nombre = formulario.nombre;
	let resultado = nombre.value !== "";

	cambiarApariencia(nombre, resultado)
	return resultado;
}

function comprobarMarca() {

	let marca = formulario.marca;
	let resultado = marca.value !== "";

	cambiarApariencia(marca, resultado)
	return resultado;
}

function comprobarFechaLiquidacion() {
	let fechaLiquidacion = formulario.fechaLiquidacion;
	let resultado = fechaLiquidacion.value !== "" && Date.parse(fechaLiquidacion.value) > Date.now();

	cambiarApariencia(fechaLiquidacion, resultado)
	return resultado;
}

function comprobarImagen() {

	let imagen = formulario.imagen;
	let resultado = imagen.value !== "";

	cambiarApariencia(imagen, resultado)
	return resultado;
}

function comprobarPrecio() {

	let precio = formulario.precio;
	let resultado = precio.value > 0;

	cambiarApariencia(precio, resultado)
	return resultado;
}

function comprobarUnidades() {

	let uds = formulario.uds;
	let resultado = uds.value > 0;

	cambiarApariencia(uds, resultado)
	return resultado;
}


function cambiarApariencia(campo, estado) {
	if (estado) {
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';

	}
	else {
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}
	// Los mensajes no consigo que funcionen tras probar varias cosas, 
	// estan en formPala.html como h4 tras cada div explicando por que no esta correcto el campo.
}