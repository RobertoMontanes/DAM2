document.addEventListener('DOMContentLoaded', function () {
    let initializing = true;

    const dataContainer = document.getElementById("data-container");

    // Inicializar Select2
    $('.select2-enhanced').select2({
        theme: 'bootstrap-5',
        width: '100%'
    });

    // Gráfico de Evolución de Gastos Mensuales
    const gastosMensualesCtx = document.getElementById('gastosMensualesChart');
    if (gastosMensualesCtx) {
        new Chart(gastosMensualesCtx, {
            type: 'line',
            data: {
                labels: JSON.parse(dataContainer.getAttribute('data-mesesLabels')),
                datasets: [{
                    label: 'Gasto Mensual (€)',
                    data: JSON.parse(dataContainer.getAttribute('data-gastosMensualesData')),
                    borderColor: '#6b7fd7',
                    backgroundColor: 'rgba(107, 127, 215, 0.1)',
                    borderWidth: 3,
                    fill: true,
                    tension: 0.4
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { display: false }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: { color: 'rgba(0, 0, 0, 0.05)' }
                    },
                    x: {
                        grid: { display: false }
                    }
                }
            }
        });
    }

    // Gráfico de Distribución por Categoría
    const distribucionCategoriaCtx = document.getElementById('distribucionCategoriaChart');
    if (distribucionCategoriaCtx) {
        new Chart(distribucionCategoriaCtx, {
            type: 'doughnut',
            data: {
                labels: JSON.parse(dataContainer.getAttribute('data-categoriasLabels')),
                datasets: [{
                    data: JSON.parse(dataContainer.getAttribute('data-categoriasData')),
                    backgroundColor: JSON.parse(dataContainer.getAttribute('data-categoriasColores')),
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { position: 'bottom' }
                }
            }
        });
    }

    // Gráfico de Gasto por Plataforma
    const gastoPlataformaCtx = document.getElementById('gastoPlataformaChart');
    if (gastoPlataformaCtx) {
        new Chart(gastoPlataformaCtx, {
            type: 'bar',
            data: {
                labels: JSON.parse(dataContainer.getAttribute('data-plataformasLabels')),
                datasets: [{
                    label: 'Gasto Total (€)',
                    data: JSON.parse(dataContainer.getAttribute('data-plataformasData')),
                    backgroundColor: '#8a9de8',
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { display: false }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: { color: 'rgba(0, 0, 0, 0.05)' }
                    },
                    x: {
                        grid: { display: false }
                    }
                }
            }
        });
    }

    // Gráfico de Renovaciones por Mes
    const renovacionesCtx = document.getElementById('renovacionesChart');
    if (renovacionesCtx) {
        new Chart(renovacionesCtx, {
            type: 'bar',
            data: {
                labels: JSON.parse(dataContainer.getAttribute('data-renovacionesLabels')),
                datasets: [{
                    label: 'Renovaciones',
                    data: JSON.parse(dataContainer.getAttribute('data-renovacionesData')),
                    backgroundColor: '#8a9de8',
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { display: false },
                    tooltip: {
                        callbacks: {
                            label: function (c) {
                                return 'Renovacion: ' + c.raw + '%';
                            }
                        }
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: { color: 'rgba(0, 0, 0, 0.05)' },
                        ticks: {
                            callback: function (value) {
                                return value + '%';
                            }
                        }
                    },
                    x: {
                        grid: { display: false }
                    }
                }
            }
        });
    }

    // Configurar filtros desde URL
    const params = new URLSearchParams(window.location.search);

    const periodo = params.get('periodo');
    const categoria = params.get('categoria');
    const plataforma = params.get('plataforma');

    // Establecer valores sin disparar filtros
    if (periodo) $('#periodoSelect').val(periodo).trigger('change.select2');
    if (categoria) $('#categoriaSelect').val(categoria).trigger('change.select2');
    if (plataforma) $('#plataformaSelect').val(plataforma).trigger('change.select2');

    // Escuchar cambios reales en Select2 (no durante inicialización)
    $('#periodoSelect').on('change', function () {
        if (!initializing) aplicarFiltros();
    });

    $('#categoriaSelect').on('change', function () {
        if (!initializing) aplicarFiltros();
    });

    $('#plataformaSelect').on('change', function () {
        if (!initializing) aplicarFiltros();
    });

    initializing = false;

    // Función para aplicar filtros y recargar la página
    function aplicarFiltros() {
        const periodo = document.getElementById('periodoSelect').value;
        const categoria = document.getElementById('categoriaSelect').value;
        const plataforma = document.getElementById('plataformaSelect').value;

        let url = '/estadisticas?';
        if (periodo !== '30') url += `periodo=${periodo}&`;
        if (categoria !== 'all') url += `categoria=${categoria}&`;
        if (plataforma !== 'all') url += `plataforma=${plataforma}`;

        if (url.endsWith('&')) url = url.slice(0, -1);

        window.location.href = url;
    }

    // Mejorar la experiencia de usuario
    function setupUXEnhancements() {
        // Mostrar loading al aplicar filtros
        const originalApplyFilters = aplicarFiltros;
        aplicarFiltros = function() {
            // Mostrar indicador de carga
            const loadingOverlay = document.createElement('div');
            loadingOverlay.className = 'loading-overlay';
            loadingOverlay.innerHTML = `
                <div class="spinner-border text-primary" role="status">
                    <span class="visually-hidden">Cargando...</span>
                </div>
                <p class="mt-2">Aplicando filtros...</p>
            `;
            loadingOverlay.style.cssText = `
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(255, 255, 255, 0.9);
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                z-index: 9999;
            `;
            document.body.appendChild(loadingOverlay);

            setTimeout(() => {
                originalApplyFilters();
            }, 500);
        };

        // Añadir estilos para el loading
        const style = document.createElement('style');
        style.textContent = `
            .loading-overlay {
                backdrop-filter: blur(5px);
            }
        `;
        document.head.appendChild(style);
    }

    // Inicializar mejoras de UX
    setupUXEnhancements();
});