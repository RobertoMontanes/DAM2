// Inicializar tooltips
document.addEventListener('DOMContentLoaded', function () {
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });
});

// Función para cambiar la autorrenovación
function toggleAutoRenew(button) {
    const isCurrentlyActive = button.classList.contains('badge-active');
    const action = isCurrentlyActive ? 'desactivar' : 'activar'
    let suscripcionId = button.getAttribute('data-id');

    if (confirm(`¿Estás seguro de que quieres ${action} la autorrenovación?`)) {
        window.location.href = `/suscripciones/autorrenovacion/` + suscripcionId;
    }
}

// Gráfico de estadísticas
document.addEventListener('DOMContentLoaded', async function () {
    const ctx = document.getElementById('statsChart');
    let datosApi;

    try {
        const response = await fetch('http://localhost:9000/usuarios/estadisticas/rapidas');
        if (!response.ok) throw new Error('Error en la solicitud: ' + response.status);
        datosApi = await response.json();
    } catch (error) {
        console.error('Hubo un problema con la petición:', error);
        return;
    }

    if (ctx && datosApi) {
        if (Object.keys(datosApi).length === 0) {
            ctx.outerHTML = '<p class="text-center text-muted m-4">No hay datos suficientes para mostrar el gráfico.</p>';
            return;
        }
        const labels = Object.keys(datosApi);
        const data = Object.values(datosApi);
        const backgroundColors = ['#6b7fd7', '#8a9de8', '#a9b9f0', '#c8d4f8', '#f4a261', '#e76f51'];

        const statsChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: labels,
                datasets: [{
                    data: data,
                    backgroundColor: backgroundColors.slice(0, labels.length),
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom',
                    }
                }
            }
        });
    }
});