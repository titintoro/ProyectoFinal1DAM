
	
	
	function validarFormulario(){
		let validarNombre = document.getElementById("nombre").value;
		let validarImagen = document.getElementById("imagen").value;
		let validarPrecio = document.getElementById("precio").value;
		let validarUnidades = document.getElementById("uds").value;

		if(validarNombre.length == 0){
			alert("Introduzca un nombre para la pala");
		}else if(validarImagen== 0){
			alert("Introduzca una imagen");
		}else if(validarPrecio<=0){
			alert("Introduzca un precio válido");
		}else if(validarUnidades<= 0){
			alert("Introduzca un número de unidades válido");
		}
	}
	


	//para asociar cada método al evento de retirar el foco del campo
	document.getElementById("nombre").addEventListener("blur",pasarNombreMarcaAMayusculas);
	document.getElementById("imagen").addEventListener("blur",pasarNombreApellidosAMayusculas);
	document.getElementById("marca").addEventListener("blur",comprobarDNI);
	document.getElementById("fechaLiquidacion").addEventListener("blur",comprobarCorreo);
	document.getElementById("precio").addEventListener("blur",comprobarContrasena);
	document.getElementById("uds").addEventListener("blur",comprobarEdad);


function revisarFormulario(){
	let resultado = false;

	//en las siguientes llamadas encadenadas con && hay que tener en cuenta que en el momento 
	//en el que una de las llamadas devuelva false, ya no se realizarán las siguientes
	resultado = pasarNombreApellidosAMayusculas()&&
				comprobarDNI()&&
				comprobarCorreo()&&
				comprobarContrasena()&&
				comprobarEdad();
	

	formulario.enviar.className = resultado?"btn btn-success mb-2":"btn btn-danger mb-2";

	return false; //lo tengo a false para que nunca envíe el formulario, cuando esto entrara en producción, habría que poner return resultado;
}

function pasarNombreMarcaAMayusculas(){
	//Es más fácil acceder a los campos del formulario de esta forma, ya que existe un objeto
	// global que tiene por nombre el id que le hayamos dado al formulario. 
	//Además, puedo acceder a todos los campos a través del name o del id (indistintamente)
	// que le hayamos dado a cada campo
	let campoNombre = formulario.nombre;
	let campoApellidos = formulario.apellidos;

	let resultado = (campoNombre.value!=="")&&(campoMarca.value!=="");
	if(resultado){		
		campoNombre.value = campoNombre.value.toUpperCase();
		campoMarca.value = campoMarca.value.toUpperCase();		
	}
	
	//ver el comentario explicativo en el método cambiarApariencia
	cambiarApariencia(campoNombre,resultado);
	cambiarApariencia(campoMarca,resultado);
	
	return resultado;
}

function comprobarDNI(){
	let dni = formulario.DNI;

	let resultado = dni.value!=="";
	//antes de comprobar la letra, estaría bien que en el HTML se comprobara con un regex 
	//que se cumple el formato

	if(resultado){
		dni.value = dni.value.toUpperCase();
		let numDNI = dni.value.substring(0,8); 
		let letraDNI = dni.value.substring(8);

		//Gracias al tipado débil de JS, cuando un string solo tiene números, el parseo es
		//automático, por lo que numDNI se puede tratar a partir de ahora como un entero

		let letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
		 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

		resultado = (numDNI > 0 && numDNI < 99999999) && (letras[numDNI%23]==letraDNI);					
	}

	cambiarApariencia(dni,resultado)
	
	return resultado;
}

function comprobarCorreo(){
	let correo = formulario.email;
	let resultado = correo.value!=="";

	//la comprobación consiste en que haya 1 arroba y que después de ella al menos haya un punto
	//también puede buscarse un regex que lo compruebe
	if(resultado){
		let partesCorreo = correo.value.split('@');
		resultado = partesCorreo.length==2;
		if(resultado){
			let partesDominio = partesCorreo[1].split('.');
			resultado = partesDominio.length>1;
		}			
	}
	
	cambiarApariencia(correo,resultado);
	
	return resultado;
}

function comprobarContrasena(){
	let pwd1 = formulario.pwd1;
	let pwd2 = formulario.pwd2;
	let resultado = pwd1.value!=="" && pwd2.value!=="";
	let mensaje;
	if(pwd1.value !== pwd2.value){
		resultado = false;		
		mensaje = "Las contraseñas no coinciden";

	}else{
		//comprobar complejidad
		let regex = /^(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ]/;
		resultado = pwd1.value.length>7 && regex.test(pwd1.value);
		mensaje = !resultado?"La contraseña debe tener al menos 8 caracteres, algún número, alguna mayúsucula y alguna minúscula":"Contraseña correcta"
	}
	
	cambiarAparienciaPwd(pwd1,pwd2,resultado,mensaje);
	
	return resultado;
}

function comprobarEdad(){
	let fecha = formulario.fnac;
	let resultado = fecha.value!="";
	
	if(resultado){
		let fechaDate = fecha.valueAsDate; //valueAsDate es una propiedad (no función) que tiene el dato introducido en el campo pero en forma de objeto de tipo Date
		let hoy = new Date(); //al crear un Date vacío, se crea con la fecha de hoy

		let anyos = hoy.getYear()-fechaDate.getYear();		
		
		//hay que tener en cuenta que, si se está en el año que se cumplen 18, 
		//puede que aún se sea menor de edad, por lo que es necesario en ese caso comprobar 
		//el mes y el día del año
		
		resultado = anyos>18 ||
				    (anyos==18 && hoy.getMonth()>fechaDate.getMonth()) ||
					(anyos==18 && hoy.getMonth()==fechaDate.getMonth() && hoy.getDate()>=fechaDate.getDate());
		
		//no confundir Date.getDay() con Date.getDate(). getDay devuelve el número del día de la semana (un número del 1 al 7) y getDate devuelve el número del día en el mes (un número del 1 al 31)
	}

	cambiarApariencia(fecha,resultado);
	
	return resultado;
}

/* Cambia la apariencia de un campo del formulario. En caso de estado==true, 
   le pone el marco verde y oculta el mensaje de error. En caso de estado==false
   le pone el marco rojo y muestra el mensaje de error.

   Siempre hay que llamarlo, porque si no, puede darse el caso de que primero se 
   introdujeran datos incorrectos (por lo que se ponía el borde rojo). Si al corregir
   los datos no lo llamásemos, seguiría con el borde rojo y mostrando el mensaje.
*/
function cambiarApariencia(campo, estado){	
	if(estado){
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';
		//parentNode es el nodo HTML padre que contiene a un nodo. NextElementSibling es el siguiente elemento hermano. 
		//por tanto, al desplazarme por el árbol estoy accediendo al siguiente hermano al nodo padre 
		//(ver el código HTML para comprender el recorrido que estamos haciendo)
	}
	else{
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}
		
}

/*  Igual que el método cambiarApariencia pero teniendo en cuenta que pueden mostrarse 
	diferentes mensajes y que solo hay que mostrar mensaje después de pw2, no de pw1
*/
function cambiarAparienciaPwd(pw1,pw2,estado,mensaje){	
	if(estado){
		pw1.classList.remove("border-danger");
		pw1.classList.add("border-success");
		pw2.classList.remove("border-danger");		
		pw2.classList.add("border-success");
		pw2.parentNode.nextElementSibling.style.visibility = 'hidden';	
	}
	else{
		pw1.classList.remove("border-success");
		pw1.classList.add("border-danger");
		pw2.classList.remove("border-success");
		pw2.classList.add("border-danger");
		pw2.parentNode.nextElementSibling.innerText = mensaje;
		pw2.parentNode.nextElementSibling.style.visibility = 'visible';
	}
}