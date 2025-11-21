document.addEventListener('DOMContentLoaded', function() {
    const planSummary = document.getElementById('planSummary');
    const summaryContent = document.getElementById('summaryContent');
    const submitButton = document.getElementById('submitButton');

    // Elementos de frecuencia
    const diasInput = document.getElementById('dias');
    const mesesInput = document.getElementById('meses');
    const aniosInput = document.getElementById('anios');
    const precioInput = document.getElementById('planPrecio');
    const nombreInput = document.getElementById('planNombre');

    // Función para actualizar el resumen del plan
    function actualizarResumen() {
        const dias = parseInt(diasInput.value) || 0;
        const meses = parseInt(mesesInput.value) || 0;
        const anios = parseInt(aniosInput.value) || 0;
        const precio = parseFloat(precioInput.value) || 0;
        const nombre = nombreInput.value || 'Sin nombre';

        // Verificar si al menos un campo de frecuencia tiene valor
        const tieneFrecuencia = dias > 0 || meses > 0 || anios > 0;

        if (tieneFrecuencia && precio > 0) {
            let frecuenciaTexto = '';

            if (anios > 0) {
                frecuenciaTexto += anios + ' año' + (anios > 1 ? 's' : '');
            }

            if (meses > 0) {
                if (frecuenciaTexto) frecuenciaTexto += ', ';
                frecuenciaTexto += meses + ' mes' + (meses > 1 ? 'es' : '');
            }

            if (dias > 0) {
                if (frecuenciaTexto) frecuenciaTexto += ', ';
                frecuenciaTexto += dias + ' día' + (dias > 1 ? 's' : '');
            }

            // Calcular precio por mes aproximado
            let totalDias = (anios * 365) + (meses * 30) + dias;
            let precioPorMes = totalDias > 0 ? (precio / totalDias * 30).toFixed(2) : 0;

            summaryContent.innerHTML = `
                <strong>Resumen del Plan:</strong><br>
                • <strong>Nombre:</strong> ${nombre}<br>
                • <strong>Precio:</strong> $${precio.toFixed(2)}<br>
                • <strong>Frecuencia:</strong> ${frecuenciaTexto}<br>
                • <strong>Precio mensual aproximado:</strong> $${precioPorMes}
            `;

            planSummary.style.display = 'block';
        } else {
            planSummary.style.display = 'none';
        }

        // Validar el formulario
        validarFormulario();
    }

    // Función para validar el formulario
    function validarFormulario() {
        const dias = parseInt(diasInput.value) || 0;
        const meses = parseInt(mesesInput.value) || 0;
        const anios = parseInt(aniosInput.value) || 0;
        const precio = parseFloat(precioInput.value) || 0;

        const tieneFrecuencia = dias > 0 || meses > 0 || anios > 0;
        const tienePrecio = precio > 0;

        // Habilitar/deshabilitar el botón de envío
        submitButton.disabled = !(tieneFrecuencia && tienePrecio);

        // Mostrar mensajes de error si es necesario
        if (!tieneFrecuencia && precio > 0) {
            mostrarErrorFrecuencia('Debe especificar al menos un período de tiempo (días, meses o años)');
        } else {
            ocultarErrorFrecuencia();
        }

        if (!tienePrecio && tieneFrecuencia) {
            mostrarErrorPrecio('Debe especificar un precio mayor a 0');
        } else {
            ocultarErrorPrecio();
        }
    }

    // Funciones para mostrar/ocultar errores
    function mostrarErrorFrecuencia(mensaje) {
        let errorElement = document.getElementById('errorFrecuencia');
        if (!errorElement) {
            errorElement = document.createElement('div');
            errorElement.id = 'errorFrecuencia';
            errorElement.className = 'text-danger mt-2 small';
            diasInput.parentNode.appendChild(errorElement);
        }
        errorElement.textContent = mensaje;
    }

    function ocultarErrorFrecuencia() {
        const errorElement = document.getElementById('errorFrecuencia');
        if (errorElement) {
            errorElement.remove();
        }
    }

    function mostrarErrorPrecio(mensaje) {
        let errorElement = document.getElementById('errorPrecio');
        if (!errorElement) {
            errorElement = document.createElement('div');
            errorElement.id = 'errorPrecio';
            errorElement.className = 'text-danger mt-2 small';
            precioInput.parentNode.appendChild(errorElement);
        }
        errorElement.textContent = mensaje;
    }

    function ocultarErrorPrecio() {
        const errorElement = document.getElementById('errorPrecio');
        if (errorElement) {
            errorElement.remove();
        }
    }

    // Event listeners para actualizar el resumen en tiempo real
    diasInput.addEventListener('input', actualizarResumen);
    mesesInput.addEventListener('input', actualizarResumen);
    aniosInput.addEventListener('input', actualizarResumen);
    precioInput.addEventListener('input', actualizarResumen);
    nombreInput.addEventListener('input', actualizarResumen);

    // Validación del formulario al enviar
    const form = document.querySelector('form');
    form.addEventListener('submit', function(e) {
        const dias = parseInt(diasInput.value) || 0;
        const meses = parseInt(mesesInput.value) || 0;
        const anios = parseInt(aniosInput.value) || 0;
        const precio = parseFloat(precioInput.value) || 0;

        const tieneFrecuencia = dias > 0 || meses > 0 || anios > 0;
        const tienePrecio = precio > 0;

        if (!tieneFrecuencia || !tienePrecio) {
            e.preventDefault();
            alert('Por favor, complete todos los campos requeridos correctamente.');
            return false;
        }
    });

    // Inicializar el resumen
    actualizarResumen();
});