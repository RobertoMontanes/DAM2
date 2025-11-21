document.addEventListener('DOMContentLoaded', function() {
    // Inicializar Select2 para el campo de categoría
    $('#categoria').select2({
        theme: 'bootstrap-5',
        width: '100%',
        language: {
            noResults: function() {
                return "No se encontraron categorías";
            },
            searching: function() {
                return "Buscando...";
            },
            inputTooShort: function(args) {
                var remainingChars = args.minimum - args.input.length;
                return "Por favor ingresa " + remainingChars + " o más caracteres";
            }
        },
        placeholder: function() {
            return $(this).data('placeholder');
        },
        allowClear: $(this).data('allow-clear') || false,
        minimumResultsForSearch: 3 // Mostrar búsqueda solo si hay 3 o más opciones
    });

    // Mejorar la experiencia en móviles
    if (window.innerWidth < 768) {
        $('#categoria').select2({
            dropdownParent: $('.form-container')
        });
    }

    // Sugerir categorías populares si hay muchas opciones
    const categoriasSelect = $('#categoria');
    const categoriasCount = categoriasSelect.find('option').length - 1; // Restar la opción vacía

    if (categoriasCount > 10) {
        // Añadir funcionalidad de búsqueda mejorada
        categoriasSelect.on('select2:open', function() {
            setTimeout(function() {
                $('.select2-search__field').attr('placeholder', 'Escribe para buscar entre ' + categoriasCount + ' categorías...');
            }, 100);
        });
    }
});