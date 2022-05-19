function validarFormulario(){
		let validarNombre = document.getElementById("nombre").value;
		let validarImagen = document.getElementById("imagen").value;
		let validarPrecio = document.getElementById("precio").value;
		let validarUnidades = document.getElementById("uds").value;

		if(validarNombre.length == 0){
			cambiarApariencia(nombre);
			alert("Introduzca un nombre para la pala");
		}else if(validarImagen== 0){
			alert("Introduzca una imagen");
		}else if(validarPrecio<=0){
			alert("Introduzca un precio válido");
		}else if(validarUnidades<= 0){
			alert("Introduzca un número de unidades válido");
		}
	}

function cambiarApariencia(campo){	
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		//parentNode es el nodo HTML padre que contiene a un nodo. NextElementSibling es el siguiente elemento hermano. 
		//por tanto, al desplazarme por el árbol estoy accediendo al siguiente hermano al nodo padre 
		//(ver el código HTML para comprender el recorrido que estamos haciendo)
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		
}