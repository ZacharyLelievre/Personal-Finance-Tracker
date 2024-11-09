import React, { useEffect, useRef } from 'react';
import Chart from 'chart.js/auto';

export default function WeeklyExpenseChart({ data }) {
    const chartRef = useRef(null);

    useEffect(() => {
        if (chartRef.current) {
            new Chart(chartRef.current, {
                type: 'bar',
                data: {
                    labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
                    datasets: [{
                        label: 'Expenses',
                        data,
                        backgroundColor: '#4CAF50',
                        borderColor: 'black',
                        borderWidth: 3,
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        }
    }, [data]);

    return <canvas ref={chartRef}></canvas>;
}