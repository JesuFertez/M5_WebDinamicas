// Función para validar el formulario
function validarFormulario() {
	// Obtener los valores de los campos del formulario
	var nombre = document.querySelector('input[name="nombre"]').value;
	var rutCliente = document.querySelector('input[name="rutCliente"]').value;
	var dia = document.querySelector('select[name="dia"]').value;
	var hora = document.querySelector('input[name="hora"]').value;
	var lugar = document.querySelector('input[name="lugar"]').value;
	var duracion = document.querySelector('input[name="duracion"]').value;
	var cantidadAsistentes = document.querySelector('input[name="cantidadAsistentes"]').value;

	// Variable para controlar si hay errores
	var errores = false;

	// Limpiar mensajes de error previos
	var mensajesError = document.querySelectorAll('.mensaje-error');
	mensajesError.forEach(function(mensaje) {
		mensaje.textContent = '';
	});

	// Validar Nombre (obligatorio, mínimo 5 caracteres, máximo 50)
	if (nombre.trim() === '') {
		mostrarError('nombre', 'El nombre es obligatorio');
		errores = true;
	} else if (nombre.length < 5 || nombre.length > 50) {
		mostrarError('nombre', 'El nombre debe tener entre 5 y 50 caracteres');
		errores = true;
	}else{
		document.querySelector('input[name="nombre"]').style.borderColor = '';
	}
	
	// Validar RUT cliente (obligatorio)
	if (rutCliente.trim() === '') {
		mostrarError('rutCliente', 'El RUT del cliente es obligatorio');
		errores = true;
	}else{
		document.querySelector('input[name="rutCliente"]').style.borderColor = '';
	}

	// Validar día (debe ser un valor permitido entre "lunes" y "Domingo")
	var diasPermitidos = ['lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo'];
	if (!diasPermitidos.includes(dia.toLowerCase())) {
		mostrarError('dia', 'El dia debe ser un valor entre "Lunes" y "Domingo"');
		errores = true;
	}else{
		document.querySelector('select[name="dia"]').style.borderColor = '';
	}

	// Validar hora (debe ser una hora válida en formato HH:MM)
	var horaRegex = /^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
	if (!hora.match(horaRegex)) {
		mostrarError('hora', 'La hora debe tener un formato valido (HH:MM)');
		errores = true;
	}else{
		document.querySelector('input[name="hora"]').style.borderColor = '';
	}

	// Validar lugar (obligatorio, mínimo 10 caracteres, máximo 50)
	if (lugar.trim() === '') {
		mostrarError('lugar', 'El lugar es obligatorio');
		errores = true;
	} else if (lugar.length < 10 || lugar.length > 50) {
		mostrarError('lugar', 'El lugar debe tener entre 10 y 50 caracteres');
		errores = true;
	}else{
		document.querySelector('input[name="lugar"]').style.borderColor = '';
	}

	// Validar duración (máximo 70 caracteres)
	if (duracion.length > 70) {
		mostrarError('duracion', 'La duracion debe tener maximo 70 caracteres');
		errores = true;
	}else{
		document.querySelector('input[name="duracion"]').style.borderColor = '';
	}

	// Validar cantidad de asistentes (obligatorio, número entero menor que 1000)
	if (cantidadAsistentes.trim() === '' || isNaN(cantidadAsistentes) || 
	parseInt(cantidadAsistentes) >= 1000 || parseInt(cantidadAsistentes) < 0) {
		mostrarError('cantidadAsistentes', 'La cantidad de asistentes debe ser un numero entero menor que 1000');
		errores = true;
	}else{
		document.querySelector('input[name="cantidadAsistentes"]').style.borderColor = '';
	}

	// Devolver true si no hay errores, o false si hay errores
	return !errores;
}

/// Función para mostrar una alerta de error
function mostrarError(campo, mensaje) {
	var elementoCampo = document.querySelector('input[name="' + campo + '"]');
	var alertaError = document.createElement('div');
	alertaError.className = 'alert alert-danger';
	alertaError.textContent = mensaje;
	elementoCampo.parentNode.insertBefore(alertaError, elementoCampo);

	elementoCampo.style.borderColor = 'red';

	elementoCampo.addEventListener('mouseover', function() {
		alertaError.style.display = 'block';
	});

	elementoCampo.addEventListener('mouseout', function() {
		alertaError.style.display = 'none';
	});
}

// Agregar estilos CSS para la alerta de error (Bootstrap ya debe estar incluido en tu página HTML)
var estiloCSS = document.createElement('style');
estiloCSS.innerHTML = `
.alert {
  display: none;
  position: absolute;
  top: -40px;
  left: 0;
  width: 100%;
  z-index: 1;
}
`;
document.head.appendChild(estiloCSS);

// Agregar evento al formulario para ejecutar la validación al enviar
var formulario = document.querySelector('form');
formulario.addEventListener('submit', function(event) {
	event.preventDefault(); // Evitar que el formulario se envíe automáticamente

	if (validarFormulario()) {
		formulario.submit(); // Enviar el formulario si pasa la validación
	}
});
