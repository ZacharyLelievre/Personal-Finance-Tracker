import React, { useEffect, useRef } from 'react';
import Chart from 'chart.js/auto';

export default function CategoryBreakdownChart({ data }) {
    const chartRef = useRef(null);

    useEffect(() => {
        if (chartRef.current) {
            new Chart(chartRef.current, {
                type: 'pie',
                data: {
                    labels: ['PURCHASE', 'REFUND', 'TRANSFER', 'WITHDRAWAL', 'DEPOSIT'],
                    datasets: [{
                        label: 'Categories',
                        data,
                        backgroundColor: ['#4CAF50', '#FF6384', '#36A2EB', '#FFCE56', '#33FFDD'],
                        borderColor: 'black',
                        borderWidth: 3,
                    }]
                },
                options: {
                    responsive: true,
                }
            });
        }
    }, [data]);

    return <canvas ref={chartRef}></canvas>;
}