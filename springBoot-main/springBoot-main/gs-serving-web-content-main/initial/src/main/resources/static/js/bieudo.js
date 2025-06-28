document.addEventListener('DOMContentLoaded', function() {
    const ctx = document.getElementById('revenueChart').getContext('2d');
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6'],
            datasets: [{
                label: 'Doanh thu (triệu ₫)',
                data: [120, 140, 100, 130, 160, 170],
                fill: true,
                backgroundColor: 'rgba(0, 168, 255, 0.1)',
                borderColor: '#00a8ff',
                tension: 0.3
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    display: true,
                    position: 'top'
                }
            }
        }
    });
});