document.addEventListener('DOMContentLoaded', function () {
    // Inicializar Select2 para todos los selects mejorados
    $('.select2-enhanced').select2({
        theme: 'bootstrap-5',
        width: '100%',
        language: {
            noResults: function () {
                return "No se encontraron resultados";
            },
            searching: function () {
                return "Buscando...";
            }
        },
        placeholder: function () {
            return $(this).data('placeholder');
        },
        allowClear: $(this).data('allow-clear') || false
    });

    const plataformaSelect = $('#plataforma');
    const planSelect = $('#plan');
    const submitButton = document.getElementById('submitButton');
    const planInfo = document.getElementById('planInfo');

    // Auto-enviar formulario cuando se selecciona plataforma (manteniendo funcionalidad original)
    plataformaSelect.on('change', function () {
        if (this.value) {
            submitButton.disabled = true;
            document.getElementById('formulario').submit();
        }
    });

    // Habilitar el botón de enviar cuando se carguen los planes
    if (planSelect.find('option').length > 1) {
        submitButton.disabled = false;
    }

    // Establecer fecha actual como valor por defecto para fecha de inicio
    const fechaInicio = document.getElementById('fechaInicio');
    if (fechaInicio && !fechaInicio.value) {
        const today = new Date();
        const formattedDate = today.toISOString().split('T')[0];
        fechaInicio.value = formattedDate;
    }

    // Validación del formulario
    const form = document.getElementById('formulario');
    form.addEventListener('submit', function (e) {
        const plataforma = document.getElementById('plataforma').value;
        const plan = document.getElementById('plan').value;
        const fecha = document.getElementById('fechaInicio').value;

        if (!plataforma || !plan || !fecha) {
            e.preventDefault();
            alert('Por favor, completa todos los campos requeridos');
            return false;
        }
    });

    // Mejorar la experiencia en móviles
    if (window.innerWidth < 768) {
        $('.select2-enhanced').select2({
            dropdownParent: $('.form-container')
        });
    }
});