document.addEventListener('DOMContentLoaded', function() {
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirmPassword');
    const togglePassword = document.getElementById('togglePassword');
    const form = document.getElementById('registroForm');
    const emailInput = document.getElementById('email');
    const nombreInput = document.getElementById('nombre');
    const apellidosInput = document.getElementById('apellidos');

    // Función para mostrar/ocultar contraseña
    togglePassword.addEventListener('click', function() {
        const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        const type2 = confirmPasswordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordInput.setAttribute('type', type);
        confirmPasswordInput.setAttribute('type', type2);
        const icon = this.querySelector('i');
        icon.classList.toggle('fa-eye');
        icon.classList.toggle('fa-eye-slash');
    });

    // Validación en tiempo real
    function setupRealTimeValidation() {
        const inputs = [nombreInput, apellidosInput, emailInput, passwordInput, confirmPasswordInput];

        inputs.forEach(input => {
            input.addEventListener('blur', function() {
                validateField(this);
            });

            input.addEventListener('input', function() {
                clearFieldError(this);
            });
        });

        // Validación específica para confirmación de contraseña
        confirmPasswordInput.addEventListener('input', function() {
            validatePasswordMatch();
        });
    }

    // Validar campo individual
    function validateField(field) {
        const value = field.value.trim();
        let isValid = true;
        let errorMessage = '';

        switch(field.id) {
            case 'nombre':
            case 'apellidos':
                if (!value) {
                    isValid = false;
                    errorMessage = 'Este campo es obligatorio';
                } else if (value.length < 2) {
                    isValid = false;
                    errorMessage = 'Debe tener al menos 2 caracteres';
                }
                break;

            case 'email':
                if (!value) {
                    isValid = false;
                    errorMessage = 'El email es obligatorio';
                } else if (!isValidEmail(value)) {
                    isValid = false;
                    errorMessage = 'Formato de email inválido';
                }
                break;

            case 'password':
                if (!value) {
                    isValid = false;
                    errorMessage = 'La contraseña es obligatoria';
                } else if (!isValidPassword(value)) {
                    isValid = false;
                    errorMessage = 'La contraseña debe tener al menos 8 caracteres, incluir mayúsculas, minúsculas y números';
                }
                break;

            case 'confirmPassword':
                if (!value) {
                    isValid = false;
                    errorMessage = 'Confirma tu contraseña';
                } else if (value !== passwordInput.value) {
                    isValid = false;
                    errorMessage = 'Las contraseñas no coinciden';
                }
                break;
        }

        if (!isValid) {
            showFieldError(field, errorMessage);
        } else {
            clearFieldError(field);
        }

        return isValid;
    }

    // Validar coincidencia de contraseñas
    function validatePasswordMatch() {
        if (passwordInput.value && confirmPasswordInput.value) {
            if (passwordInput.value !== confirmPasswordInput.value) {
                showFieldError(confirmPasswordInput, 'Las contraseñas no coinciden');
            } else {
                clearFieldError(confirmPasswordInput);
            }
        }
    }

    // Mostrar error en campo
    function showFieldError(field, message) {
        field.classList.add('error-box');

        // Remover mensaje de error existente
        const existingError = field.parentNode.querySelector('.field-error');
        if (existingError) {
            existingError.remove();
        }

        // Crear mensaje de error
        const errorDiv = document.createElement('div');
        errorDiv.className = 'field-error text-danger small mt-1';
        errorDiv.textContent = message;

        field.parentNode.appendChild(errorDiv);
    }

    // Limpiar error de campo
    function clearFieldError(field) {
        field.classList.remove('error-box');
        const existingError = field.parentNode.querySelector('.field-error');
        if (existingError) {
            existingError.remove();
        }
    }

    // Validar formato de email
    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    // Validar fortaleza de contraseña
    function isValidPassword(password) {
        const minLength = 8;
        const hasUpperCase = /[A-Z]/.test(password);
        const hasLowerCase = /[a-z]/.test(password);
        const hasNumbers = /\d/.test(password);

        return password.length >= minLength && hasUpperCase && hasLowerCase && hasNumbers;
    }

    // Validación completa del formulario
    form.addEventListener('submit', function(e) {
        let isValid = true;
        const fields = [nombreInput, apellidosInput, emailInput, passwordInput, confirmPasswordInput];

        // Validar todos los campos
        fields.forEach(field => {
            if (!validateField(field)) {
                isValid = false;
            }
        });

        // Validar coincidencia de contraseñas
        if (passwordInput.value !== confirmPasswordInput.value) {
            showFieldError(confirmPasswordInput, 'Las contraseñas no coinciden');
            isValid = false;
        }

        if (!isValid) {
            e.preventDefault();
            showAlert('Por favor, corrige los errores en el formulario.', 'error');
        }
    });

    // Mostrar alerta personalizada
    function showAlert(message, type) {
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

        // Insertar después del primer alert existente o al principio del register-container
        const registerContainer = document.querySelector('.register-container');
        const firstAlert = registerContainer.querySelector('.alert');

        if (firstAlert) {
            firstAlert.parentNode.insertBefore(alertDiv, firstAlert.nextSibling);
        } else {
            const registerHeader = document.querySelector('.register-header');
            registerHeader.parentNode.insertBefore(alertDiv, registerHeader.nextSibling);
        }

        // Auto-remover después de 5 segundos
        setTimeout(() => {
            if (alertDiv.parentNode) {
                alertDiv.parentNode.removeChild(alertDiv);
            }
        }, 5000);
    }

    // Mejorar UX en móviles
    if (window.innerWidth < 768) {
        document.querySelectorAll('.form-control').forEach(input => {
            input.addEventListener('focus', function() {
                setTimeout(() => {
                    this.scrollIntoView({ behavior: 'smooth', block: 'center' });
                }, 300);
            });
        });
    }

    // Inicializar validación en tiempo real
    setupRealTimeValidation();
});