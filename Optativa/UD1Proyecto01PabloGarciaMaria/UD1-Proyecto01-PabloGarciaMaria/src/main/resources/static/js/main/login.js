// Función para mostrar/ocultar contraseña
document.getElementById('togglePassword').addEventListener('click', function() {
    const passwordInput = document.getElementById('password');
    const icon = this.querySelector('i');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        icon.classList.remove('fa-eye');
        icon.classList.add('fa-eye-slash');
    } else {
        passwordInput.type = 'password';
        icon.classList.remove('fa-eye-slash');
        icon.classList.add('fa-eye');
    }
});

// Validación del formulario
document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');

    form.addEventListener('submit', function(e) {
        let isValid = true;
        let errorMessage = '';

        // Validar email
        if (!emailInput.value.trim()) {
            isValid = false;
            errorMessage = 'Por favor, ingresa tu correo electrónico.';
        } else if (!isValidEmail(emailInput.value)) {
            isValid = false;
            errorMessage = 'Por favor, ingresa un correo electrónico válido.';
        }

        // Validar contraseña
        if (!passwordInput.value.trim()) {
            isValid = false;
            errorMessage = 'Por favor, ingresa tu contraseña.';
        }

        if (!isValid) {
            e.preventDefault();
            showCustomAlert(errorMessage, 'error');
        }
    });

    // Función para validar formato de email
    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    // Función para mostrar alertas personalizadas
    function showCustomAlert(message, type) {
        // Remover alerta existente si hay una
        const existingAlert = document.querySelector('.custom-alert');
        if (existingAlert) {
            existingAlert.remove();
        }

        const alertDiv = document.createElement('div');
        alertDiv.className = `alert alert-${type === 'error' ? 'danger' : 'success'} custom-alert`;
        alertDiv.innerHTML = `
            <i class="fas ${type === 'error' ? 'fa-exclamation-circle' : 'fa-check-circle'} me-2"></i>
            ${message}
        `;

        // Insertar después del primer alert existente o al principio del login-body
        const loginBody = document.querySelector('.login-body');
        const firstAlert = loginBody.querySelector('.alert');

        if (firstAlert) {
            firstAlert.parentNode.insertBefore(alertDiv, firstAlert.nextSibling);
        } else {
            loginBody.insertBefore(alertDiv, loginBody.firstChild);
        }

        // Auto-remover después de 5 segundos
        setTimeout(() => {
            if (alertDiv.parentNode) {
                alertDiv.parentNode.removeChild(alertDiv);
            }
        }, 5000);
    }

    // Efectos de focus en los inputs
    const inputs = document.querySelectorAll('.form-control');
    inputs.forEach(input => {
        input.addEventListener('focus', function() {
            this.parentElement.classList.add('focused');
        });

        input.addEventListener('blur', function() {
            if (!this.value) {
                this.parentElement.classList.remove('focused');
            }
        });
    });

    // Prevenir envío con Enter en campos individuales
    inputs.forEach(input => {
        input.addEventListener('keypress', function(e) {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault();
                // Solo enviar el formulario si estamos en el último campo
                if (input === passwordInput) {
                    form.dispatchEvent(new Event('submit'));
                } else {
                    // Mover al siguiente campo
                    const inputsArray = Array.from(inputs);
                    const currentIndex = inputsArray.indexOf(input);
                    if (currentIndex < inputsArray.length - 1) {
                        inputsArray[currentIndex + 1].focus();
                    }
                }
            }
        });
    });
});