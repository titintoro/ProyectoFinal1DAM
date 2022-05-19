	
	document.getElementById("nombre").addEventListener("blur",comprobarNombre);
	document.getElementById("marca").addEventListener("blur",comprobarMarca);
    document.getElementById("imagen").addEventListener("blur",comprobarImagen);
    document.getElementById("fechaLiquidacion").addEventListener("blur",comprobarFechaLiquidacion);
    document.getElementById("precio").addEventListener("blur",comprobarPrecio);
    document.getElementById("uds").addEventListener("blur",comprobarunidades);

	function comprobarNombre(){
		
		let nombre = formulario.nombre;
		let resultado = nombre.value!=="";
		
		cambiarApariencia(nombre,resultado)
		return resultado;
	}
	
	function comprobarMarca(){
		
		let marca = formulario.marca;
		let resultado = marca.value!=="";
		
		cambiarApariencia(marca,resultado)
		return resultado;
	}
	
	function comprobarFechaLiquidacion(){
		let fechaLiquidacion = formulario.fechaLiquidacion;
		let resultado = fechaLiquidacion.value !=="" && Date.parse(fechaLiquidacion.value)>Date.now();
		
		cambiarApariencia(fechaLiquidacion,resultado)
		return resultado;
	}
	
	function comprobarImagen(){
		
		let imagen = formulario.imagen;
		let resultado = imagen.value!=="";
		
		cambiarApariencia(marca,resultado)
		return resultado;
	}
	
function cambiarApariencia(campo, estado){	
	if(estado){
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';
		
	}
	else{
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}
		
}